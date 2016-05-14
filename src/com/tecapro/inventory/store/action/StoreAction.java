package com.tecapro.inventory.store.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.store.bean.StoreValue;

/**
 * Process action for Total
 */
@Controller("StoreAction")
@Scope("request")
public class StoreAction extends DelegateAction {
    private static String LAYOUT_QUAN_LY_PHIEU_NHAP = "1";
    private static String LAYOUT_QUAN_LY_PHIEU_XUAT = "2";
    private static String LAYOUT_HAN_MUC_CAC_DON_VI = "3";
    private static String LAYOUT_XUAT_UNG_HAN_MUC_CAC_DON_VI = "4";
    
    private StoreValue value;
    
    
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_QUAN_LY_PHIEU_NHAP);
        return result;
    }
    
    public String output(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_QUAN_LY_PHIEU_XUAT);
        return result;
    }
    
    public String outputLimitUnit(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_HAN_MUC_CAC_DON_VI);
        return result;
    }
    
    public String advanceOLimitUnit(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_XUAT_UNG_HAN_MUC_CAC_DON_VI);
        return result;
    }

    public StoreValue getValue() {
        return value;
    }

    public void setValue(StoreValue value) {
        this.value = value;
    }
}
