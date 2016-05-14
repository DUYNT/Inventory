/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;

/**
 * button info value
 *
 */
public class ButtonInfoValue implements Serializable {
    
    private static final long serialVersionUID = -493481408533914119L;

    /**
     * button name
     */
    private String buttonName = null;
    
    /**
     * button index
     */
    private int index = 0;
    
    /**
     * message code to build confirm message
     */
    private String messageId = null;
    
    /**
     * parameter put to message confirm
     */
    private String messageParam = null;
    
    /**
     * contain javascript method for event click on button
     */
    private String onClick = null;
    
    /**
     * setting up attribute disable for button
     */
    private String disable = null;
    
    /**
     * contain action to request for event click on button
     */
    private String action = null;
    
    /**
     * setting up attribute invisible for button
     */
    private String invisible = null;
    
    /**
     * setting up flag for button long
     */
    private boolean longButton = false;

    /**
     * setting up flag dirty check for button
     */
    private boolean dirtyCheck = false;
    
    /**
     * setting up message for dirty check
     */
    private String dirtyMsgId = null;

    /**
     * get longButton
     * @return longButton
     */
    public boolean isLongButton() {
        return longButton;
    }

    /**
     * set longButton
     * @param longButton
     */
    public void setLongButton(boolean longButton) {
        this.longButton = longButton;
    }

    /**
     * get disable
     * @return disable
     */
    public String getDisable() {
        return disable;
    }

    /**
     * set disable
     * @param disable
     */
    public void setDisable(String disable) {
        this.disable = disable;
    }

    /**
     * get onClick
     * @return onClick
     */
    public String getOnClick() {
        return onClick;
    }

    /**
     * set onClick
     * @param onClick
     */
    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    /**
     * get messageParam
     * @return messageParam
     */
    public String getMessageParam() {
        return messageParam;
    }

    /**
     * set messageParam
     * @param messageParam
     */
    public void setMessageParam(String messageParam) {
        this.messageParam = messageParam;
    }

    /**
     * get invisible
     * @return invisible
     */
    public String getInvisible() {
        return invisible;
    }

    /**
     * set invisible
     * @param invisible
     */
    public void setInvisible(String invisible) {
        this.invisible = invisible;
    }

    /**
     * get buttonName
     * @return buttonName
     */
    public String getButtonName() {
        return buttonName;
    }

    /**
     * set buttonName
     * @param buttonName
     */
    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    /**
     * get index
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * set index
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * get messageId
     * @return messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * set messageId
     * @param messageId
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * get action
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * set action
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * set dirtyCheck
     * @param dirtyCheck
     */
    public void setDirtyCheck(boolean dirtyCheck) {
        this.dirtyCheck = dirtyCheck;
    }

    /**
     * get dirtyCheck
     * @return dirtyCheck
     */
    public boolean isDirtyCheck() {
        return dirtyCheck;
    }

    /**
     * set dirtyMsgId
     * @param dirtyMsgId
     */
    public void setDirtyMsgId(String dirtyMsgId) {
        this.dirtyMsgId = dirtyMsgId;
    }

    /**
     * get dirtyMsgId
     * @return dirtyMsgId
     */
    public String getDirtyMsgId() {
        return dirtyMsgId;
    }
}