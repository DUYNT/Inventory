package com.tecapro.inventory.common.model;

import java.io.Serializable;

public class Admin extends AdminKey implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1989273567106607388L;
    private int id;
    private String tenDangNhap;
    private String matKhau;
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
    private String capchar;
    
    public String getCapchar() {
        return capchar;
    }
    public void setCapchar(String capchar) {
        this.capchar = capchar;
    }
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTenDangNhap() {
        return tenDangNhap;
    }
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
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
    public String getDonVi() {
        return donVi;
    }
    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }
    
}