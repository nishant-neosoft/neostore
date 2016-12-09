package com.neosoft.neostore.serviceapi;

import com.neosoft.neostore.model.login.LoginResponseModel;
import com.neosoft.neostore.model.mycart.MyCartResponseModel;
import com.neosoft.neostore.model.product.ProductResponseModel;
import com.neosoft.neostore.model.register.RegisterResponseModel;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;

import static com.neosoft.neostore.serviceapi.UserAPI.CART_LIST_URL;
import static com.neosoft.neostore.serviceapi.UserAPI.LOGIN_URL;
import static com.neosoft.neostore.serviceapi.UserAPI.REGISTER_URL;

public class GetServices{

    public void login(String email, String pass, ApiResponse responseListener, ApiFailure failureListener)
    {
        RequestBody requestBody = new FormBody.Builder()
                .add("email",email)
                .add("password",pass)
                .build();
        Services<LoginResponseModel> loginResponseModelServices = new Services<LoginResponseModel>(LOGIN_URL, requestBody,responseListener, failureListener,LoginResponseModel.class);
        loginResponseModelServices.execute();
    }

    public void register(String fname, String lname, String email, String pass, String cpass, String gender, String ph_no, ApiResponse responseListener, ApiFailure failureListener)
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
        Services<RegisterResponseModel> ser = new Services<RegisterResponseModel>(REGISTER_URL, requestBody,responseListener, failureListener,RegisterResponseModel.class);
        ser.execute();
    }

    public void getProductlist(String productid, ApiResponse responseListener,ApiFailure failureListener)
    {

        HttpUrl url = new HttpUrl.Builder().scheme("http")
                .host("staging.php-dev.in")
                .port(8844)
                .addPathSegments("trainingapp/api/products/getList")
                .addQueryParameter("product_category_id",productid)
                .build();
        Services<ProductResponseModel> ser = new Services<ProductResponseModel>(url.toString(),null,null, null,responseListener, failureListener, ProductResponseModel.class);
        ser.execute();
    }

    public void getCartItems(String access_token, ApiResponse responseListener, ApiFailure failureListener)
    {
        RequestBody requestBody = new FormBody.Builder().build();
        Services<MyCartResponseModel> ser = new Services<MyCartResponseModel>(CART_LIST_URL, "access_token", access_token,requestBody, responseListener, failureListener, MyCartResponseModel.class);
        ser.execute();
    }
}
