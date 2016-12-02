package com.neosoft.neostore;

/**
 * Created by webwerks1 on 2/12/16.
 */
public class AddressDetails {
    String name;
    String address;

    public AddressDetails(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
