package com.neosoft.neostore.serviceapi;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Services<U> extends AsyncTask<Void, Void, String> {

	private String url;
	private RequestBody requestBody;
	private ApiResponse<U> apiResponse;
	private Class<U> responseType;
	private ApiFailure apiError;
	private Request request;

	public Services(String url,RequestBody requestBody, ApiResponse apiResponse, ApiFailure apiFailure,	Class<U> responseType) {
		this.url = url;
		this.requestBody = requestBody;
		this.apiResponse = apiResponse;
		this.apiError = apiFailure;
		this.responseType = responseType;
		request = new Request.Builder().url(url).post(requestBody).build();
	}

	public Services(String url, ApiResponse<U> apiResponse, ApiFailure failureListener, Class<U> responseType) {
		this.url = url;
		this.apiResponse = apiResponse;
		this.responseType = responseType;
		request = new Request.Builder().url(url).get().build();
	}

	public Services(String url, String key, String value, RequestBody requestBody, ApiResponse<U> apiResponse, ApiFailure failureListener, Class<U> responseType) {
		this.url = url;
		this.apiResponse = apiResponse;
		this.responseType = responseType;
		request = new Request.Builder().url(url).get().addHeader(key,value).build();
	}

	@Override protected String doInBackground(Void... requestBodies) {
		String responseString = null;
		try {
			OkHttpClient client = new OkHttpClient();
			Response response = client.newCall(request).execute();
			responseString = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseString;
	}

	@Override protected void onPostExecute(String response) {
		super.onPostExecute(response);
		int status = 0;
		try {
			status = (new JSONObject(response)).getInt("status");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (status != 200) {
			apiError.onError(String.valueOf(status));
		} else {
			Gson gson = new Gson();
			apiResponse.onSuccess(gson.fromJson(response, responseType));
		}
	}
}
