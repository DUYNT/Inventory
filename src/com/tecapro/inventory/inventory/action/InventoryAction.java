package com.tecapro.inventory.inventory.action;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.inventory.bean.InventoryValue;

/**
 * Process action for Inventory
 */
@Controller("InventoryAction")
@Scope("request")
public class InventoryAction extends DelegateAction {
    private static String LAYOUT_TONG_HOP_DU_LIEU_KIEM_KE = "1";
    private static String LAYOUT_GHI_THUC_KIEM = "2";
    private static String LAYOUT_BAO_CAO_KIEM_KE = "3";
    
    private InventoryValue value;
    
    
    public String init(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_TONG_HOP_DU_LIEU_KIEM_KE);
        return result;
    }
    
    public String recordTruth(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_GHI_THUC_KIEM);
        return result;
    }
    
    public String report(){
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_BAO_CAO_KIEM_KE);
        return result;
    }

    public InventoryValue getValue() {
        return value;
    }

    public void setValue(InventoryValue value) {
        this.value = value;
    }
}
