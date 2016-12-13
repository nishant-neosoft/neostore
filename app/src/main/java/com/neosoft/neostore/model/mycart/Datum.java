
package com.neosoft.neostore.model.mycart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("product")
    @Expose
    private Product product;

    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The product_id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity
     *     The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return
     *     The product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 
     * @param product
     *     The product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

}
