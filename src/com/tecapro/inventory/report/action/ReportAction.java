/**
 * @author duynt
 *
 */
package com.tecapro.inventory.report.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.report.bean.ReportValue;

@Controller("ReportAction")
@Scope("request")
public class ReportAction extends DelegateAction {
    private static final String LAYOUT_FORM1 = "1";
    private static final String LAYOUT_FORM2 = "2";
    private static final String LAYOUT_FORM2A = "3";
    private static final String LAYOUT_FORM2B = "4";
    private static final String LAYOUT_FORM3 = "5";
    private static final String LAYOUT_FORM3A = "6";
    private static final String LAYOUT_FORM3B = "7";
    private static final String LAYOUT_FORM4 = "8";
    private static final String LAYOUT_FORM5 = "9";
    private static final String LAYOUT_FORM6 = "10";
    private static final String LAYOUT_FORM6A = "11";
    private static final String LAYOUT_FORM6B = "12";
    private static final String LAYOUT_FORM7 = "13";
    private static final String LAYOUT_FORM7A = "14";
    private static final String LAYOUT_FORM7B = "15";
    private static final String LAYOUT_FORM8 = "16";
    private static final String LAYOUT_FORM9 = "17";
    private static final String LAYOUT_FORM10 = "18";
    private static final String LAYOUT_FORM11 = "19";
    private static final String LAYOUT_FORM12 = "20";
    private static final String LAYOUT_FORM13 = "21";
    private static final String LAYOUT_FORM14 = "22";
    
    private ReportValue value;
    
    public String init() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM1);
        return result;
    }
    
    public String form1() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM1);
        return result;
    }
    public String form2() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM2);
        return result;
    }
    public String form2A() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM2A);
        return result;
    }
    public String form2B() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM2B);
        return result;
    }
    public String form3() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM3);
        return result;
    }
    public String form3A() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM3A);
        return result;
    }
    public String form3B() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM3B);
        return result;
    }
    public String form4() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM4);
        return result;
    }
    public String form5() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM5);
        return result;
    }
    public String form6() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM6);
        return result;
    }
    public String form6A() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM6A);
        return result;
    }
    public String form6B() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM6B);
        return result;
    }
    public String form7() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM7);
        return result;
    }
    public String form7A() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM7A);
        return result;
    }
    public String form7B() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM7B);
        return result;
    }
    public String form8() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM8);
        return result;
    }
    public String form9() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM9);
        return result;
    }
    public String form10() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM10);
        return result;
    }
    public String form11() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM11);
        return result;
    }
    public String form12() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM12);
        return result;
    }
    public String form13() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM13);
        return result;
    }
    public String form14() {
        String result = SUCCESS_FORWARD;
        value.getResultValue().setTypeLayout(LAYOUT_FORM14);
        return result;
    }

    public ReportValue getValue() {
        return value;
    }

    public void setValue(ReportValue value) {
        this.value = value;
    }
}