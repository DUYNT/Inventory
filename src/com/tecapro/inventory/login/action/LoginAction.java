package com.tecapro.inventory.login.action;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.common.model.Admin;
import com.tecapro.inventory.common.util.PropertiesUtil;
import com.tecapro.inventory.login.bean.LoginValue;
import com.tecapro.inventory.login.logic.LoginLogic;

/**
 * Process action for Login
 */
@Controller("LoginAction")
@Scope("request")
public class LoginAction extends DelegateAction {

    // private static final Log LOG = LogFactory.getLog(LoginAction.class);

    /* Instance of LoginValue */
    private LoginValue value;

    /* Instance of LoginLogic */
    @Autowired
    private LoginLogic loginLogic;

    @Autowired
    private HttpServletRequest session;

    @Autowired
    private PropertiesUtil util;

    /**
     * @param value
     *            the value to set
     */
    public void setValue(LoginValue value) {
        this.value = value;
    }

    /**
     * init Login
     * 
     * @return
     * @throws Throwable
     */
    public String init() throws Throwable {
        String result = SUCCESS_FORWARD;
        if (value.getInfo().getUserInfo().getUsername() == null) {
            result = ERROR_FORWARD;
        }
        return result;
    }
    
    public String login() throws Throwable {
        String result = SUCCESS_FORWARD;
        if (value.getInfo().getUserInfo().getUsername() != null) {
            return result;
        }
        if (value.getUser().getCheckFail() >= 4) {
            if (session.getSession().getAttribute("captchar") != null) {
                if (value.getUser().getCapchar().equals(session.getSession().getAttribute("captchar"))) {
                    result = checkLogin();
                } else {
                    value.setErrorMsg(util.getMsgProperty("MSG001B"));
                    result = ERROR_FORWARD;
                }
            } else {
                value.setErrorMsg(util.getMsgProperty("MSG001A"));
                result = ERROR_FORWARD;
            }
        } else {
            result = checkLogin();
        }
        return result;
    }

    public String checkLogin() {
        String result = SUCCESS_FORWARD;
        try {
            Admin user = new Admin();
            user.setTenDangNhap(value.getUser().getTenDangNhap());
            user = loginLogic.getUser(user);

            String password = value.getUser().getMatKhau();
            // encryption md5
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            if (user != null && hashtext.equals(user.getMatKhau())) {
                value.getInfo().getUserInfo().setUsername(user.getTenDangNhap());
                value.getInfo().getUserInfo().setPassword(password);
                value.getInfo().getUserInfo().setIdAdmin(user.getId());
                value.getInfo().getUserInfo().setChungMinhThu(user.getChungMinhThu());
                value.getInfo().getUserInfo().setDeleteflag(user.isDeleteflag());
                value.getInfo().getUserInfo().setDonVi(user.getDonVi());
                value.getInfo().getUserInfo().setKieuHangHoa(user.getKieuHangHoa());
                value.getInfo().getUserInfo().setNgayCap(user.getNgayCap());
                value.getInfo().getUserInfo().setNgayTaoSuDung(user.getNgayTaoSuDung());
                value.getInfo().getUserInfo().setNoiCap(user.getNoiCap());
                value.getInfo().getUserInfo().setQuyenSuDung(user.getQuyenSuDung());
                value.getInfo().getUserInfo().setSoDienThoai(user.getSoDienThoai());
                value.getInfo().getUserInfo().setTenDayDu(user.getTenDayDu());
                result = SUCCESS_FORWARD;
                value.setErrorMsg("");
            } else {
                value.setErrorMsg(util.getMsgProperty("MSG002A"));
                value.getInfo().getInfoMsg().add(0, value.getErrorMsg());
                result = ERROR_FORWARD;
            }
        } catch (Exception e) {
            value.setErrorMsg(util.getMsgProperty("MSG003A"));
            value.getInfo().getInfoMsg().add(0, value.getErrorMsg());
            result = ERROR_FORWARD;
        }
        return result;
    }
    
    public String loguot() {
        String result = SUCCESS_FORWARD;
        value.getInfo().getUserInfo().setUsername(null);
        value.getInfo().getUserInfo().setPassword(null);
        value.getInfo().getUserInfo().setIdAdmin(null);
        value.getInfo().getUserInfo().setChungMinhThu(null);
        value.getInfo().getUserInfo().setDonVi(null);
        value.getInfo().getUserInfo().setKieuHangHoa(0);
        value.getInfo().getUserInfo().setNgayCap(null);
        value.getInfo().getUserInfo().setNgayTaoSuDung(null);
        value.getInfo().getUserInfo().setNoiCap(null);
        value.getInfo().getUserInfo().setQuyenSuDung(0);
        value.getInfo().getUserInfo().setSoDienThoai(null);
        value.getInfo().getUserInfo().setTenDayDu(null);
        return result;
    }
}
