package com.neosoft.neostore.serviceapi;

/**
 * Created by webwerks on 1/12/16.
 */

public class ErrorHandler implements ApiFailure {

    @Override
    public String onError(String msg) {
        if(msg != "200")
        {
            return msg;
        }
        else {
            msg += "success";
            return msg;
        }
    }
}
