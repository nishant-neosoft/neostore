package com.neosoft.neostore.serviceapi;

import com.neosoft.neostore.model.Product.ProductResponseModel;
import com.neosoft.neostore.model.login.LoginResponseModel;
import com.neosoft.neostore.model.register.RegisterResponseModel;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;

import static com.neosoft.neostore.serviceapi.UserAPI.LOGIN_URL;
import static com.neosoft.neostore.serviceapi.UserAPI.REGISTER_URL;

public class GetServices{

    public void login(String email, String pass, ApiResponse responseListener)
    {
        RequestBody requestBody = new FormBody.Builder()
                .add("email",email)
                .add("password",pass)
                .build();

        Services<LoginResponseModel> loginResponseModelServices = new Services<>(LOGIN_URL, requestBody, responseListener,LoginResponseModel.class);
        loginResponseModelServices.execute();
    }

    public void register(String fname, String lname, String email, String pass, String cpass, String gender, String ph_no, ApiResponse responseListener)
    {
        RequestBody requestBody = new FormBody.Builder()
                .add("first_name",fname)
                .add("last_name",lname)
                .add("email",email)
                .add("password",pass)
                .add("confirm_password",cpass)
                .add("gender",gender)
                .add("phone_no",ph_no)
                .build();
        Services<RegisterResponseModel> ser = new Services<>(REGISTER_URL, requestBody, responseListener, RegisterResponseModel.class);
        ser.execute();
    }

    public void getProductlist(String productid, ApiResponse responseListener)
    {

        HttpUrl url = new HttpUrl.Builder().scheme("http")
                .host("staging.php-dev.in")
                .port(8844)
                .addPathSegments("trainingapp/api/products/getList")
                .addQueryParameter("product_category_id",productid)
                .build();
//        Request request = new Request.Builder().url(PRODUCTS_URL).get(requestBody).build();
        Services<ProductResponseModel> ser = new Services<>(url.toString(), responseListener,ProductResponseModel.class);
        ser.execute();
    }

//    http://staging.php-dev.in:8844/trainingapp/api/products/getList?product_category_id=2
}
