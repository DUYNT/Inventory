/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.tecapro.inventory.common.util.Constants;

/**
 * PageInfoValue class info paging
 * 
 */
public class PageInfoValue implements Serializable {

    private static final long serialVersionUID = 5878828514240155934L;

    private static final int PAGE_RANG = 10;
    private int hyojiKensu = 0;

    private int currentKensu = 0;

    private int startKensu = 0;

    private long allKensu = 0;

    private int showHyojiKensu = 1;

    private LinkedHashMap<String, String> listNumRecord = new LinkedHashMap<String, String>();

    private List<Integer> listPaging = new ArrayList<Integer>();
    private int currentPage = 1;
    private int lastPage = 1;
    private String actionPaging = "";

    public String getShowPrev() {

        if (allKensu < 0) {
            return new BigDecimal("-1").toString();
        }

        if (allKensu > hyojiKensu && currentKensu > hyojiKensu) {
            return Constants.ONE;
        }

        return Constants.ZERO;
    }

    public String getShowNext() {

        if (allKensu < 0) {
            return new BigDecimal("-1").toString();
        }

        if (allKensu > hyojiKensu && currentKensu < allKensu) {
            return Constants.ONE;
        }

        return Constants.ZERO;
    }

    public int getHyojiKensu() {
        return hyojiKensu;
    }

    public void setHyojiKensu(int hyojiKensu) {
        if (this.hyojiKensu != hyojiKensu) {
            this.hyojiKensu = hyojiKensu;
        }
    }

    public int getCurrentKensu() {
        return currentKensu;
    }

    /**
     * Set total record from 0 to current page
     * 
     * @param currentKensu
     */
    public void setNumKensu(int currentKensu) {
        setCurrentKensu(currentKensu);

        int gap = hyojiKensu;
        
        if (currentKensu == allKensu && hyojiKensu > 0) {
            int rest = currentKensu % hyojiKensu;
            if (rest != 0) {
                gap = rest;
            }
        }

        setStartKensu(currentKensu - gap + 1);
    }

    public void setCurrentKensu(int currentKensu) {
        this.currentKensu = currentKensu;
    }

    public int getStartKensu() {
        return startKensu;
    }

    public void setStartKensu(int startKensu) {
        if (startKensu < 0) {
            this.startKensu = 1;
        } else {
            this.startKensu = startKensu;
        }
    }

    public long getAllKensu() {
        return allKensu;
    }

    /**
     * Set total record
     * 
     * @param allKensu
     */
    public void setAllKensu(long allKensu) {
        this.listPaging.clear();
        int lPage = 1;
        if (this.hyojiKensu > 0 && allKensu > 0) {
            lPage = (int) (Math.floor(allKensu / this.hyojiKensu) + (allKensu % this.hyojiKensu > 0 ? 1 : 0));
        } else {
            setNumKensu(0);
        }
        if (this.lastPage != lPage) {
            this.lastPage = lPage;
            this.currentPage = 1;
        }
        setCurrentPage(this.currentPage);
        // not display list paging when lastPage <= 1
        if (this.lastPage > 1) {
            int start = (int) (Math.floor((this.currentPage - 1) / PAGE_RANG) * PAGE_RANG + 1);
            int end = start + PAGE_RANG - 1;
            end = (end > this.lastPage) ? this.lastPage : end;
            for (int i = start; i <= end; i++) {
                this.listPaging.add(i);
            }
        }
        this.allKensu = allKensu;
    }

    /**
     * @return the pages
     */
    public LinkedHashMap<String, String> getListNumRecord() {
        return listNumRecord;
    }

    /**
     * @param pages
     *            the pages to set
     */
    public void setListNumRecord(String strListRecord) {
        String[] listRecord = strListRecord.split(",");
        for (int i = 0; i < listRecord.length; i++) {
            this.listNumRecord.put(listRecord[i].trim(), listRecord[i]);
        }
    }

    public int getShowHyojiKensu() {
        return showHyojiKensu;
    }

    public void setShowHyojiKensu(int showHyojiKensu) {
        this.showHyojiKensu = showHyojiKensu;
    }

    /**
     * get offset
     * 
     * @return
     */
    public int getOffset() {
        if (currentPage > lastPage) {
            currentPage = 1;
        }
        return ((currentPage - 1) * hyojiKensu);
    }

    /**
     * @return the listPaging
     */
    public List<Integer> getListPaging() {
        return listPaging;
    }

    /**
     * @param listPaging
     *            the listPaging to set
     */
    public void setListPaging(List<Integer> listPaging) {
        this.listPaging = listPaging;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage
     *            the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the lastPage
     */
    public int getLastPage() {
        return lastPage;
    }

    /**
     * @param lastPage
     *            the lastPage to set
     */
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * @return the actionPaging
     */
    public String getActionPaging() {
        return actionPaging;
    }

    /**
     * @param actionPaging
     *            the actionPaging to set
     */
    public void setActionPaging(String actionPaging) {
        this.actionPaging = actionPaging;
    }
}
