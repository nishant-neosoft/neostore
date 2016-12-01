package com.neosoft.neostore.serviceapi;

import android.os.AsyncTask;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class Services<U> extends AsyncTask<Void, Void, String> {

	private String url;
	private RequestBody requestBody;
	private ApiResponse<U> apiResponse;
	private Class<U> responseType;

	public Services(String url, RequestBody requestBody, ApiResponse apiResponse,
			Class<U> responseType) {
		this.url = url;
		this.requestBody = requestBody;
		this.apiResponse = apiResponse;
		this.responseType = responseType;
	}

	@Override protected String doInBackground(Void... requestBodies) {
		String responseString = null;
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(url).post(requestBody).build();
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
			status = new JSONObject(response).getInt("status");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (status != 200) {
			apiResponse.onError("Error");
		} else {
			Gson gson = new Gson();
			apiResponse.onSuccess(gson.fromJson(response, responseType));
		}
	}
}
