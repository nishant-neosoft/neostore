
package com.neosoft.neostore.model.mycart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("product_category")
    @Expose
    private String productCategory;
    @SerializedName("product_images")
    @Expose
    private String productImages;
    @SerializedName("sub_total")
    @Expose
    private Integer subTotal;

    /**
     * 
     * @return
     *     The id
     */
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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * 
     * @param cost
     *     The cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * 
     * @return
     *     The productCategory
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * 
     * @param productCategory
     *     The product_category
     */
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * 
     * @return
     *     The productImages
     */
    public String getProductImages() {
        return productImages;
    }

    /**
     * 
     * @param productImages
     *     The product_images
     */
    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    /**
     * 
     * @return
     *     The subTotal
     */
    public Integer getSubTotal() {
        return subTotal;
    }

    /**
     * 
     * @param subTotal
     *     The sub_total
     */
    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

}
