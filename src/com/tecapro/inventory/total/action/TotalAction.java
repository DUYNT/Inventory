package com.tecapro.inventory.total.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.total.bean.TotalValue;

/**
 * Process action for Total
 */
@Controller("TotalAction")
@Scope("request")
public class TotalAction extends DelegateAction {
    private static String LAYOUT_CAN_DOI_XUAT_NHAP_TON = "1";
    private static String LAYOUT_XEM_CAN_DOI_XUAT_NHAP_TON = "2";
    private static String LAYOUT_XEM_THE_KHO = "3";
    private static String LAYOUT_XEM_THE_TON_KHO = "4";
    private static String LAYOUT_DAU_KY_VAT_TU = "5";
    
    private TotalValue value;
    
    
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_CAN_DOI_XUAT_NHAP_TON);
        return result;
    }
    
    public String ioProductSave(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_XEM_CAN_DOI_XUAT_NHAP_TON);
        return result;
    }
    
    public String viewProduct(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_XEM_THE_KHO);
        return result;
    }
    
    public String viewProductSave(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_XEM_THE_TON_KHO);
        return result;
    }
    
    public String viewStartMonth(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DAU_KY_VAT_TU);
        return result;
    }

    public TotalValue getValue() {
        return value;
    }

    public void setValue(TotalValue value) {
        this.value = value;
    }
}
