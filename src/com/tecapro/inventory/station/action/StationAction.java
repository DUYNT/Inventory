package com.tecapro.inventory.station.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.station.bean.StationValue;

/**
 * Process action for StationAction
 */
@Controller("StationAction")
@Scope("request")
public class StationAction extends DelegateAction {
    private static String LAYOUT_DANH_SACH_NGUOI_DUNG = "1";
    private static String LAYOUT_THEM_NGUOI_DUNG = "2";
    private static String LAYOUT_SUA_XOA_NGUOI_DUNG = "3";
    
    private StationValue value;
    
    
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_DANH_SACH_NGUOI_DUNG);
        return result;
    }
    
    public String adding(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_THEM_NGUOI_DUNG);
        return result;
    }
    
    public String editing(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_SUA_XOA_NGUOI_DUNG);
        return result;
    }

    public StationValue getValue() {
        return value;
    }

    public void setValue(StationValue value) {
        this.value = value;
    }

}
