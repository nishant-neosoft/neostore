package com.neosoft.neostore;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterAcivity {

    public static final String URL_REGISTER = "http://staging.php-dev.in:8844/trainingapp/api/users/register";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public String doGetRequest(String url) throws IOException
    {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String paramsRegister()
    {

//        return "{'winCondition':'HIGH_SCORE',"
//                + "'name':'Bowling',"
//                + "'round':4,"
//                + "'lastSaved':1367702411696,"
//                + "'dateStarted':1367702378785,"
//                + "'players':["
//                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
//                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
//                + "]}";
        return "{'first_name':'abhijeet1234'," +
                "'last_name':'vaidya1234'," +
                "'email':'abhijeet@vaidya1234.com'," +
                "'password':'abhijeetvaidya1234'," +
                "'confirm_password':'abhijeetvaidya1234'," +
                "'gender':'M'," +
                "'phone_no':9889988998}";
    }

    public RegisterAcivity() {
        super();
    }

    public String doPostRequest(String url, String json) throws IOException {
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body().string();
    }
}
