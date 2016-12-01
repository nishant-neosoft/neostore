package com.neosoft.neostore.serviceapi;

/**
 * Created by Nishant Shah on 30-Nov-16.
 */

public interface ApiResponse<T> {

	void onSuccess(T response);
	void onError(String message);
}
