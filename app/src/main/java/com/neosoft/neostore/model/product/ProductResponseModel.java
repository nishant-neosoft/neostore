package com.neosoft.neostore.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProductResponseModel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<DataModel> data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user_msg")
    @Expose
    private String userMsg;

    /**
     *
     * @return
     *     The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     *     The data
     */
    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }

    /**
     *
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     *     The userMsg
     */
    public String getUserMsg() {
        return userMsg;
    }

    /**
     *
     * @param userMsg
     *     The user_msg
     */
    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    @Override public String toString() {
        return "ProductResponseModel{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", userMsg='" + userMsg + '\'' +
                '}';
    }

}
