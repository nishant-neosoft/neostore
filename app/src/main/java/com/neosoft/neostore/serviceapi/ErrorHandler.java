package com.neosoft.neostore.serviceapi;

/**
 * Created by webwerks on 1/12/16.
 */

public class ErrorHandler implements ApiFailure {


    @Override
    public String onError(String msg) {
        if(msg.equals(200))
        {
            msg += "success";
            return msg;
        }
        if(msg.equals("401"))
        {
            msg = "failure";
            return msg;
        }
        else {
            return msg;
        }
    }
}