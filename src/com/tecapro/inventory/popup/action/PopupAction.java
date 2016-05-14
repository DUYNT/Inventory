package com.tecapro.inventory.popup.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.popup.bean.PopupValue;

/**
 * Process action for PopupAction
 */
@Controller("PopupAction")
@Scope("request")
public class PopupAction extends DelegateAction {
    private static String THEM_HANG_HOA = "1";
    
    private PopupValue value;
    
    /**
     * init Home
     * 
     * @return
     * @throws Throwable
     */
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getInfo().getPop().setTypeLayout(THEM_HANG_HOA);
        return result;
    }
}
