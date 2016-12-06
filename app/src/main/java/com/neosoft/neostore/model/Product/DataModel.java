package com.neosoft.neostore.model.Product;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("product_images")
    private String tableImage;

    @SerializedName("name")
    private String tableTitle;

    @SerializedName("producer")
    private String tableShop;

    @SerializedName("cost")
    private String tablePrice;

    @SerializedName("rating")
    private String tableRating;

    public String getTableImage() {
        return tableImage;
    }

    public void setTableImage(String tableImage) {
        this.tableImage = tableImage;
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public String getTableShop() {
        return tableShop;
    }

    public void setTableShop(String tableShop) {
        this.tableShop = tableShop;
    }

    public String getTablePrice() {
        return tablePrice;
    }

    public void setTablePrice(String tablePrice) {
        this.tablePrice = tablePrice;
    }

    public String getTableRating() {
        return tableRating;
    }

    public void setTableRating(String tableRating) {
        this.tableRating = tableRating;
    }


}
