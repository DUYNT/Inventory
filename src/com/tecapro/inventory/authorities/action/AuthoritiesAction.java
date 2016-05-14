package com.tecapro.inventory.authorities.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.authorities.bean.AuthoritiesValue;
import com.tecapro.inventory.common.action.DelegateAction;

/**
 * Process action for Authorities
 */
@Controller("AuthoritiesAction")
@Scope("request")
public class AuthoritiesAction extends DelegateAction {
    private static String LAYOUT_NGUOI_DUNG_LEVEL1 = "1";
    private static String LAYOUT_NGUOI_DUNG_LEVEL2 = "2";
    private static String LAYOUT_NGUOI_DUNG_LEVEL3 = "3";
    private static String LAYOUT_NGUOI_DUNG_LEVEL4 = "4";
    
    private AuthoritiesValue value;
    
    
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_NGUOI_DUNG_LEVEL1);
        return result;
    }
    
    public String level2(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_NGUOI_DUNG_LEVEL2);
        return result;
    }
    
    public String level3(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_NGUOI_DUNG_LEVEL3);
        return result;
    }
    
    public String level4(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_NGUOI_DUNG_LEVEL4);
        return result;
    }
   
    public AuthoritiesValue getValue() {
        return value;
    }

    public void setValue(AuthoritiesValue value) {
        this.value = value;
    }

}
