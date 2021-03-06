package com.tecapro.inventory.common.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String capchar;
    
    private String tenDangNhap;
    
    private String matKhauMoi;
    
    private String tenDayDu;
    private String soDienThoai;
    private String chungMinhThu;
    private String ngayCap;
    private String noiCap;
    private String donVi;
    private String quyenSuDung;
    private String kieuHangHoa;
    private String ngayTaoSuDung;

    
    /**
     * @return the tenDayDu
     */
    public String getTenDayDu() {
        return tenDayDu;
    }

    /**
     * @param tenDayDu the tenDayDu to set
     */
    public void setTenDayDu(String tenDayDu) {
        this.tenDayDu = tenDayDu;
    }

    /**
     * @return the soDienThoai
     */
    public String getSoDienThoai() {
        return soDienThoai;
    }

    /**
     * @param soDienThoai the soDienThoai to set
     */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    /**
     * @return the chungMinhThu
     */
    public String getChungMinhThu() {
        return chungMinhThu;
    }

    /**
     * @param chungMinhThu the chungMinhThu to set
     */
    public void setChungMinhThu(String chungMinhThu) {
        this.chungMinhThu = chungMinhThu;
    }

    /**
     * @return the ngayCap
     */
    public String getNgayCap() {
        return ngayCap;
    }

    /**
     * @param ngayCap the ngayCap to set
     */
    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    /**
     * @return the noiCap
     */
    public String getNoiCap() {
        return noiCap;
    }

    /**
     * @param noiCap the noiCap to set
     */
    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    /**
     * @return the donVi
     */
    public String getDonVi() {
        return donVi;
    }

    /**
     * @param donVi the donVi to set
     */
    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    /**
     * @return the quyenSuDung
     */
    public String getQuyenSuDung() {
        return quyenSuDung;
    }

    /**
     * @param quyenSuDung the quyenSuDung to set
     */
    public void setQuyenSuDung(String quyenSuDung) {
        this.quyenSuDung = quyenSuDung;
    }

    /**
     * @return the kieuHangHoa
     */
    public String getKieuHangHoa() {
        return kieuHangHoa;
    }

    /**
     * @param kieuHangHoa the kieuHangHoa to set
     */
    public void setKieuHangHoa(String kieuHangHoa) {
        this.kieuHangHoa = kieuHangHoa;
    }

    /**
     * @return the ngayTaoSuDung
     */
    public String getNgayTaoSuDung() {
        return ngayTaoSuDung;
    }

    /**
     * @param ngayTaoSuDung the ngayTaoSuDung to set
     */
    public void setNgayTaoSuDung(String ngayTaoSuDung) {
        this.ngayTaoSuDung = ngayTaoSuDung;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    private int checkFail;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @author MbGenerated
     */
    private static final long serialVersionUID = 5340549980819286079L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @author MbGenerated
     */
    private String matKhau;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.salt
     *
     * @author MbGenerated
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.pass_reset_code
     *
     * @author MbGenerated
     */
    private String passResetCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.pass_reset_time
     *
     * @author MbGenerated
     */
    private Date passResetTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.created_time
     *
     * @author MbGenerated
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.closed_time
     *
     * @author MbGenerated
     */
    private Date closedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.account_status
     *
     * @author MbGenerated
     */
    private Integer accountStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.failed_auth_num
     *
     * @author MbGenerated
     */
    private Integer failedAuthNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.auth_lock_time
     *
     * @author MbGenerated
     */
    private Date authLockTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.capacity
     *
     * @author MbGenerated
     */
    private Long capacity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.used_space
     *
     * @author MbGenerated
     */
    private Long usedSpace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.capacity_id
     *
     * @author MbGenerated
     */
    private Integer capacityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.fs_warning_time
     *
     * @author MbGenerated
     */
    private Date fsWarningTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.last_charge_time
     *
     * @author MbGenerated
     */
    private Date lastChargeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.next_charge_time
     *
     * @author MbGenerated
     */
    private Date nextChargeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.num_charged_fail
     *
     * @author MbGenerated
     */
    private Byte numChargedFail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.balance
     *
     * @author MbGenerated
     */
    private Integer balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nick_name
     *
     * @author MbGenerated
     */
    private String nickName;


    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.salt
     *
     * @return the value of user.salt
     *
     * @author MbGenerated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.salt
     *
     * @param salt the value for user.salt
     *
     * @author MbGenerated
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.pass_reset_code
     *
     * @return the value of user.pass_reset_code
     *
     * @author MbGenerated
     */
    public String getPassResetCode() {
        return passResetCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.pass_reset_code
     *
     * @param passResetCode the value for user.pass_reset_code
     *
     * @author MbGenerated
     */
    public void setPassResetCode(String passResetCode) {
        this.passResetCode = passResetCode == null ? null : passResetCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.pass_reset_time
     *
     * @return the value of user.pass_reset_time
     *
     * @author MbGenerated
     */
    public Date getPassResetTime() {
        return passResetTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.pass_reset_time
     *
     * @param passResetTime the value for user.pass_reset_time
     *
     * @author MbGenerated
     */
    public void setPassResetTime(Date passResetTime) {
        this.passResetTime = passResetTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.created_time
     *
     * @return the value of user.created_time
     *
     * @author MbGenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.created_time
     *
     * @param createdTime the value for user.created_time
     *
     * @author MbGenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.closed_time
     *
     * @return the value of user.closed_time
     *
     * @author MbGenerated
     */
    public Date getClosedTime() {
        return closedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.closed_time
     *
     * @param closedTime the value for user.closed_time
     *
     * @author MbGenerated
     */
    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.account_status
     *
     * @return the value of user.account_status
     *
     * @author MbGenerated
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.account_status
     *
     * @param accountStatus the value for user.account_status
     *
     * @author MbGenerated
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.failed_auth_num
     *
     * @return the value of user.failed_auth_num
     *
     * @author MbGenerated
     */
    public Integer getFailedAuthNum() {
        return failedAuthNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.failed_auth_num
     *
     * @param failedAuthNum the value for user.failed_auth_num
     *
     * @author MbGenerated
     */
    public void setFailedAuthNum(Integer failedAuthNum) {
        this.failedAuthNum = failedAuthNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.auth_lock_time
     *
     * @return the value of user.auth_lock_time
     *
     * @author MbGenerated
     */
    public Date getAuthLockTime() {
        return authLockTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.auth_lock_time
     *
     * @param authLockTime the value for user.auth_lock_time
     *
     * @author MbGenerated
     */
    public void setAuthLockTime(Date authLockTime) {
        this.authLockTime = authLockTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.capacity
     *
     * @return the value of user.capacity
     *
     * @author MbGenerated
     */
    public Long getCapacity() {
        return capacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.capacity
     *
     * @param capacity the value for user.capacity
     *
     * @author MbGenerated
     */
    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.used_space
     *
     * @return the value of user.used_space
     *
     * @author MbGenerated
     */
    public Long getUsedSpace() {
        return usedSpace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.used_space
     *
     * @param usedSpace the value for user.used_space
     *
     * @author MbGenerated
     */
    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.capacity_id
     *
     * @return the value of user.capacity_id
     *
     * @author MbGenerated
     */
    public Integer getCapacityId() {
        return capacityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.capacity_id
     *
     * @param capacityId the value for user.capacity_id
     *
     * @author MbGenerated
     */
    public void setCapacityId(Integer capacityId) {
        this.capacityId = capacityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.fs_warning_time
     *
     * @return the value of user.fs_warning_time
     *
     * @author MbGenerated
     */
    public Date getFsWarningTime() {
        return fsWarningTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.fs_warning_time
     *
     * @param fsWarningTime the value for user.fs_warning_time
     *
     * @author MbGenerated
     */
    public void setFsWarningTime(Date fsWarningTime) {
        this.fsWarningTime = fsWarningTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.last_charge_time
     *
     * @return the value of user.last_charge_time
     *
     * @author MbGenerated
     */
    public Date getLastChargeTime() {
        return lastChargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.last_charge_time
     *
     * @param lastChargeTime the value for user.last_charge_time
     *
     * @author MbGenerated
     */
    public void setLastChargeTime(Date lastChargeTime) {
        this.lastChargeTime = lastChargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.next_charge_time
     *
     * @return the value of user.next_charge_time
     *
     * @author MbGenerated
     */
    public Date getNextChargeTime() {
        return nextChargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.next_charge_time
     *
     * @param nextChargeTime the value for user.next_charge_time
     *
     * @author MbGenerated
     */
    public void setNextChargeTime(Date nextChargeTime) {
        this.nextChargeTime = nextChargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.num_charged_fail
     *
     * @return the value of user.num_charged_fail
     *
     * @author MbGenerated
     */
    public Byte getNumChargedFail() {
        return numChargedFail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.num_charged_fail
     *
     * @param numChargedFail the value for user.num_charged_fail
     *
     * @author MbGenerated
     */
    public void setNumChargedFail(Byte numChargedFail) {
        this.numChargedFail = numChargedFail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.balance
     *
     * @return the value of user.balance
     *
     * @author MbGenerated
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.balance
     *
     * @param balance the value for user.balance
     *
     * @author MbGenerated
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nick_name
     *
     * @return the value of user.nick_name
     *
     * @author MbGenerated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nick_name
     *
     * @param nickName the value for user.nick_name
     *
     * @author MbGenerated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getCapchar() {
        return capchar;
    }

    public void setCapchar(String capchar) {
        this.capchar = capchar;
    }

    public int getCheckFail() {
        return checkFail;
    }

    public void setCheckFail(int checkFail) {
        this.checkFail = checkFail;
    }
    
    
}