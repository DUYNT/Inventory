package com.tecapro.inventory.common.model;

import java.io.Serializable;

public class AdminKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table admin
     *
     * @author MbGenerated
     */
    private static final long serialVersionUID = -6395943503655815577L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.id
     *
     * @author MbGenerated
     */
    private Integer id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.id
     *
     * @return the value of admin.id
     *
     * @author MbGenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.id
     *
     * @param id the value for admin.id
     *
     * @author MbGenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }
}