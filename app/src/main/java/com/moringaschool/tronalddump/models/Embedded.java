
package com.moringaschool.tronalddump.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.tronalddump.models.Tag;

public class Embedded {

    @SerializedName("tag")
    @Expose
    private List<Tag> tag = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embedded() {
    }

    /**
     * 
     * @param tag
     */
    public Embedded(List<Tag> tag) {
        super();
        this.tag = tag;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

}
