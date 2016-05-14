/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * UserInfoValue class archive user info login
 *
 */
public class UserInfoValue implements Serializable {
    
    private static final long serialVersionUID = 3572378540868253705L;
    
    private Integer idAdmin;
    
    private String username;
    
    private String password;
    
    private String role;
    
    private String tenDayDu;
    private String soDienThoai;
    private String chungMinhThu;
    private String ngayCap;
    private String noiCap;
    private String donVi;
    private int quyenSuDung;
    private int kieuHangHoa;
    private String ngayTaoSuDung;
    private boolean deleteflag;
    
    
    public String getTenDayDu() {
        return tenDayDu;
    }

    public void setTenDayDu(String tenDayDu) {
        this.tenDayDu = tenDayDu;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChungMinhThu() {
        return chungMinhThu;
    }

    public void setChungMinhThu(String chungMinhThu) {
        this.chungMinhThu = chungMinhThu;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getQuyenSuDung() {
        return quyenSuDung;
    }

    public void setQuyenSuDung(int quyenSuDung) {
        this.quyenSuDung = quyenSuDung;
    }

    public int getKieuHangHoa() {
        return kieuHangHoa;
    }

    public void setKieuHangHoa(int kieuHangHoa) {
        this.kieuHangHoa = kieuHangHoa;
    }

    public String getNgayTaoSuDung() {
        return ngayTaoSuDung;
    }

    public void setNgayTaoSuDung(String ngayTaoSuDung) {
        this.ngayTaoSuDung = ngayTaoSuDung;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    private List<AdminrightInputDataValue> permission = new ArrayList<AdminrightInputDataValue>();
    
    public List<AdminrightInputDataValue> getPermission() {
        return permission;
    }

    public void setPermission(List<AdminrightInputDataValue> permission) {
        this.permission = permission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
