
package com.moringaschool.tronalddump.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TronaldDump {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TronaldDump() {
    }

    /**
     * 
     * @param total
     * @param count
     * @param embedded
     */
    public TronaldDump(Integer count, Integer total, Embedded embedded) {
        super();
        this.count = count;
        this.total = total;
        this.embedded = embedded;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

}
