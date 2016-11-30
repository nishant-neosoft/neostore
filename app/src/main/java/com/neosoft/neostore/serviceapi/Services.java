package com.neosoft.neostore.serviceapi;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class Services extends AsyncTask<RequestBody, Void, String> {
private final String TAG=Services.class.getSimpleName();
    private String url ;
    String res, modelClass;
    RequestBody requestBody;
    ApiResponse apiResponse;
    public Services(String url, RequestBody requestBody, ApiResponse apiResponse){
        this.url = url;
        this.requestBody = requestBody;
        this.apiResponse = apiResponse;
    }

    @Override
    protected String doInBackground(RequestBody... requestBodies) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBodies[0])
                    .build();
            Response response = client.newCall(request).execute();
            res = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        apiResponse.onSuccess(response);
    }

    public interface ApiResponse
   {
       void onSuccess(String response);
   }
}
