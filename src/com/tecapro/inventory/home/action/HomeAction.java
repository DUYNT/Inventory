package com.tecapro.inventory.home.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;

/**
 * Process action for Home
 */
@Controller("HomeAction")
@Scope("request")
public class HomeAction extends DelegateAction {

    /**
     * init Home
     * 
     * @return
     * @throws Throwable
     */
    public String init(){
        String result = SUCCESS_FORWARD;
        return result;
    }
}
