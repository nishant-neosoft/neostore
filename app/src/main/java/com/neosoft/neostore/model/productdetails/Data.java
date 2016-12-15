
package com.neosoft.neostore.model.productdetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_category_id")
    @Expose
    private Integer productCategoryId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("product_images")
    @Expose
    private List<ProductImage> productImages = null;

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
     *     The productCategoryId
     */
    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * 
     * @param productCategoryId
     *     The product_category_id
     */
    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
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
     *     The producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * 
     * @param producer
     *     The producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
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
     *     The rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The viewCount
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * 
     * @param viewCount
     *     The view_count
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * 
     * @param modified
     *     The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * 
     * @return
     *     The productImages
     */
    public List<ProductImage> getProductImages() {
        return productImages;
    }

    /**
     * 
     * @param productImages
     *     The product_images
     */
    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

}
