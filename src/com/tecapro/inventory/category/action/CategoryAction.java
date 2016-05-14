package com.tecapro.inventory.category.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.category.bean.CategoryValue;
import com.tecapro.inventory.category.logic.CategoryLogic;
import com.tecapro.inventory.common.action.DelegateAction;

/**
 * Process action for Category
 */
@Controller("CategoryAction")
@Scope("request")
public class CategoryAction extends DelegateAction {
    private static String LAYOUT_DANH_MUC_VAT_TU = "1";
    private static String LAYOUT_DANH_MUC_KHO = "2";
    private static String LAYOUT_DANH_MUC_TINH_CHAT_XUAT = "3";
    private static String LAYOUT_DANH_MUC_TINH_CHAT_NHAP = "4";
    private static String LAYOUT_DANH_MUC_KHACH_HANG = "5";
    private static String LAYOUT_DANH_MUC_NHA_CUNG_CAP = "6";
    private static String LAYOUT_DANH_MUC_VCF = "7";
    
    private CategoryValue value;
    
    @Autowired
    private CategoryLogic logic;
    
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_VAT_TU);
        return result;
    }
    
    public String inventory(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_KHO);
        return result;
    }
    
    public String natureOutput(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_TINH_CHAT_XUAT);
        return result;
    }
    
    public String natureInput(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_TINH_CHAT_NHAP);
        return result;
    }
    
    public String custome(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_KHACH_HANG);
        return result;
    }

    public String supplier(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_NHA_CUNG_CAP);
        return result;
    }
    
    public String mnOrderOffer(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_MUC_VCF);
        return result;
    }

    public String addPhanKho() {
        String result = SUCCESS_FORWARD;
        String tenThuKho = value.getParams().getThukho();
        String tenPhanKho = value.getParams().getTenPhanKho();
        
        if(logic.addPhanKho(value.getParams()) == 0){
            result = ERROR_FORWARD;
        }else {
            result = SUCCESS_FORWARD;
        }
        return result;
    }
    
    
    public CategoryValue getValue() {
        return value;
    }

    public void setValue(CategoryValue value) {
        this.value = value;
    }
    
    
}
