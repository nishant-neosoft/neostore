package com.neosoft.neostore.ServiceAPI;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.neosoft.neostore.Login.LoginResponseModel;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Services extends AsyncTask<RequestBody, Void, String> {

    private String url ;
    String res;
    RequestBody requestBody;
    public Services(String url, RequestBody requestBody){
        this.url = url;
        this.requestBody = requestBody;
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
        LoginResponseModel model = new Gson().fromJson(response, LoginResponseModel.class);
        String resUname = model.getData().getUsername();
        String resEmail = model.getData().getEmail();

        Log.d("Name and email --->  ",resUname+ "  and  "+resEmail);
    }
}
