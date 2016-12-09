
package com.neosoft.neostore.model.mycart;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyCartResponseModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("total")
    @Expose
    private Integer total;

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
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

}
