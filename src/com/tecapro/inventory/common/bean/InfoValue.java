/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tecapro.inventory.popup.bean.PopupResultValue;

/**
 * Value class contain info common 
 *
 */
public class InfoValue implements Serializable {

    private static final long serialVersionUID = -2445504834762943668L;
    
    private PopupResultValue pop = new PopupResultValue();
    
    
    public PopupResultValue getPop() {
        return pop;
    }

    public void setPop(PopupResultValue pop) {
        this.pop = pop;
    }

    /**
     * Item check info
     */
    private ItemCheckInfoValue item = new ItemCheckInfoValue();

    /**
     * file info value
     */
    private List<FileInfoValue> file = new ArrayList<FileInfoValue>();
    
    /**
     * back action (use CO101 screen)
     */
    private String backAction = "";
    
    /**
     * subtile on CO101 screen
     */
    private String subTitle = "";
    
    /**
     * info message
     */
    private List<String> infoMsg = new ArrayList<String>();
    
    /**
     * flag check to reset data when has error message
     */
    private Boolean resetFlag = true;
    
    /**
     * Map data contain session
     */
    private Map<String, Object> mainSessInfo = new HashMap<String, Object>();
    
    private PageInfoValue page = new PageInfoValue();
    
    private PageInfoValue page1 = new PageInfoValue();
    
    private PageInfoValue page2 = new PageInfoValue();
    
    private PageInfoValue page3 = new PageInfoValue();
    
    /**
     * User info
     */
    private UserInfoValue userInfo = new UserInfoValue();
    
    /**
     * Admin info
     */
    private AdminInfoValue adminInfo = new AdminInfoValue();
    
   
    /**
     * window name
     */
    private String winName;
    
    /**
     * window name
     */
    private static final String WIN_NAME = "MAIN_SESSION_KEY";

    /**
     * get file
     * @return file
     */
    public List<FileInfoValue> getFile() {
        return file;
    }

    /**
     * set file
     * @param file
     */
    public void setFile(List<FileInfoValue> file) {
        this.file = file;
    }

    /**
     * get item
     * @return item
     */
    public ItemCheckInfoValue getItem() {
        return item;
    }

    /**
     * set item
     * @param item
     */
    public void setItem(ItemCheckInfoValue item) {
        this.item = item;
    }

    /**
     * set backAction(use at CO101 screen)
     * @param backAction
     */
    public void setBackAction(String backAction) {
        this.backAction = backAction;
    }

    /**
     * get backAction(use at CO101 screen)
     * @return backAction
     */
    public String getBackAction() {
        return backAction;
    }

    /**
     * set subTitle(use at CO101 screen)
     * @param subTitle
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * get subTitle(use at CO101 screen)
     * @return subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * set info msg
     * @param infoMsg
     */
    public void setInfoMsg(List<String> infoMsg) {
        this.infoMsg = infoMsg;
    }

    /**
     * get info msg
     * @return infoMsg
     */
    public List<String> getInfoMsg() {
        return infoMsg;
    }

    /**
     * set flag reset data after submit (false is not reset). Default to reset data
     * 
     * @param resetFlag
     */
    public void setResetFlag(Boolean resetFlag) {
        this.resetFlag = resetFlag;
    }

    /**
     * get resetFlag
     * @return resetFlag
     */
    public Boolean getResetFlag() {
        return resetFlag;
    }

    /**
     * Getter for sessInfo
     * @return the sessInfo
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getSessInfo() {
        if (this.winName == null || "".equals(this.winName)) {
            return new HashMap<String, Object>();
        } else {
            if (mainSessInfo.get(this.winName) == null) {
                mainSessInfo.put(this.winName, new HashMap<String, Object>());
            }
            return (Map<String, Object>) mainSessInfo.get(this.winName);
        }
    }

    /**
     * @return the mainSessInfo
     */
    public Map<String, Object> getMainSessInfo() {
        return mainSessInfo;
    }

    /**
     * @param mainSessInfo the mainSessInfo to set
     */
    public void setMainSessInfo(Map<String, Object> mainSessInfo) {
        this.mainSessInfo = mainSessInfo;
    }

    /**
     * @return the page
     */
    public PageInfoValue getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(PageInfoValue page) {
        this.page = page;
    }

    /**
     * @return the userInfo
     */
    public UserInfoValue getUserInfo() {
        return userInfo;
    }

    /**
     * @param userInfo the userInfo to set
     */
    public void setUserInfo(UserInfoValue userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return the page1
     */
    public PageInfoValue getPage1() {
        return page1;
    }

    /**
     * @param page1 the page1 to set
     */
    public void setPage1(PageInfoValue page1) {
        this.page1 = page1;
    }

    /**
     * @return the page2
     */
    public PageInfoValue getPage2() {
        return page2;
    }

    /**
     * @param page2 the page2 to set
     */
    public void setPage2(PageInfoValue page2) {
        this.page2 = page2;
    }

    /**
     * @return the page3
     */
    public PageInfoValue getPage3() {
        return page3;
    }

    /**
     * @param page3 the page3 to set
     */
    public void setPage3(PageInfoValue page3) {
        this.page3 = page3;
    }

    /**
     * @return the winName
     */
    public String getWinName() {
        return (winName == null || winName.length() <= 0) ? WIN_NAME : winName;
    }

    /**
     * @param winName the winName to set
     */
    public void setWinName(String winName) {
        this.winName = winName;
    }
    
    public AdminInfoValue getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfoValue adminInfo) {
        this.adminInfo = adminInfo;
    }
}