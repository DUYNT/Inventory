/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;

/**
 * AdminInfoValue class archive user info login
 *
 */
public class AdminInfoValue implements Serializable {
    
   
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int idAdmin;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private String role;
    
    private String description;
    
    private String delete_flg;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelete_flg() {
        return delete_flg;
    }

    public void setDelete_flg(String delete_flg) {
        this.delete_flg = delete_flg;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
}
