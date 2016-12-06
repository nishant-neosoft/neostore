package com.neosoft.neostore.serviceapi;

public class UserAPI {

    public static final String URL = "http://staging.php-dev.in:8844/trainingapp/api/";
    public static final String LOGIN_URL = URL+"users/login";
    public static final String REGISTER_URL = URL+"users/register";
    public static final String FORGOT_PASS_URL = URL+"users/forgot";
    public static final String CHANGE_PASS_URL = URL+"users/change";
    public static final String UPDATE_ACCOUNT_URL = URL+"users/update";
    public static final String ACCOUNT_DETAILS_URL = URL+"users/getUserData";
    public static final String PRODUCTS_URL = URL+"products/getList";
    public static final String PROD_DETAILS_URL = URL+"products/getDetail";
    public static final String PROD_RATING_URL = URL+"products/setRating";
    public static final String ADD_TO_CART_URL = URL+"addToCart";
    public static final String EDIT_CART_URL = URL+"editCart";
    public static final String DELETE_CART_URL = URL+"deleteCart";
    public static final String CART_LIST_URL = URL+"cart";
    public static final String PLACE_ORDER_URL = URL+"order";
    public static final String ORDER_LIST_URL = URL+"orderList";
    public static final String ORDER_DETAIL_URL = URL+"orderDetail";
}
