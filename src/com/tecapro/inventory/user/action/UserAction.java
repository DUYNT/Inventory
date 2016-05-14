package com.tecapro.inventory.user.action;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.common.util.PropertiesUtil;
import com.tecapro.inventory.user.bean.UserValue;
import com.tecapro.inventory.user.logic.UserLogic;

/**
 * Process action for UserAction
 */
@Controller("UserAction")
@Scope("request")
public class UserAction extends DelegateAction {
    private static String LAYOUT_DANH_SACH_NGUOI_DUNG = "1";
    private static String LAYOUT_THEM_NGUOI_DUNG = "2";
    private static String LAYOUT_SUA_NGUOI_DUNG = "3";
    private static String LAYOUT_THONG_TIN_CA_NHAN = "4";

    @Autowired
    private PropertiesUtil util;

    @Autowired
    private UserLogic logic;

    private UserValue value;

    public String init() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_SACH_NGUOI_DUNG);
        return result;
    }

    public String adding() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_THEM_NGUOI_DUNG);
        return result;
    }

    public String editing() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_SUA_NGUOI_DUNG);
        return result;
    }

    public String control() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_THONG_TIN_CA_NHAN);
        return result;
    }

    public String changePassword() {
        String result = SUCCESS_FORWARD;
        String password = value.getUser().getMatKhauMoi();
        JSONObject response = new JSONObject();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            if (value.getInfo().getUserInfo().getPassword().equals(value.getUser().getMatKhau())) {
                value.getUser().setTenDangNhap(value.getInfo().getUserInfo().getUsername());
                value.getUser().setMatKhauMoi(hashtext);
                int update = logic.updatePassword(value.getUser());
                if (update > 0) {
                    response.put("msg", util.getMsgProperty("MSG005A"));
                    result = SUCCESS_FORWARD;
                } else {
                    response.put("msg", util.getMsgProperty("MSG004B"));
                    result = ERROR_FORWARD;
                }
            } else {
                response.put("msg", util.getMsgProperty("MSG004A"));
                result = ERROR_FORWARD;
            }
        } catch (Exception e) {
            try {
                response.put("msg", util.getMsgProperty("MSG004A"));
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            result = ERROR_FORWARD;
        }
        value.getResultValue().setTypeLayout(LAYOUT_THONG_TIN_CA_NHAN);
        value.setJsonData(response.toString());
        return result;
    }

    public String changeInfomation() {
        String result = SUCCESS_FORWARD;
        JSONObject jsonData = new JSONObject();
        try {
            if (value.getInfo().getUserInfo().getPassword().equals(value.getUser().getMatKhau())) {
                value.getUser().setTenDangNhap(value.getInfo().getUserInfo().getUsername());
                int update = logic.updateInfo(value.getUser());
                if (update > 0) {
                    jsonData.put("msg", util.getMsgProperty("MSG005A"));
                    result = SUCCESS_FORWARD;
                } else {
                    jsonData.put("msg", util.getMsgProperty("MSG003A"));
                    result = ERROR_FORWARD;
                }
            } else {
                jsonData.put("msg", util.getMsgProperty("MSG004A"));
                result = ERROR_FORWARD;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        value.getResultValue().setTypeLayout(LAYOUT_THONG_TIN_CA_NHAN);
        value.setJsonData(jsonData.toString());
        return result;
    }

    public UserValue getValue() {
        return value;
    }

    public void setValue(UserValue value) {
        this.value = value;
    }
}
