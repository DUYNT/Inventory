/**
 * JS common
 */
var LIST_AJAX_REQUEST = {};
var HAS_ERROR = false;

/* list window popup */
var LIST_POPUP = [];

/**
 * Console Error handle
 */
window.onerror = function(message, filename, linenumber) {
    if (!HAS_ERROR) {
        console.log('message: ' + message);
        console.log('filename: ' + filename);
        console.log('linenumber: ' + linenumber);
    }
    HAS_ERROR = true;
};
$(document).ready(function() {

    /*Console Error handle for Jquery*/
    var temp = jQuery.event.handle;
    jQuery.event.handle = function() {
        try {
            temp.apply(this, arguments);
        } catch (e) {
            console.log(e);
        }
    };
    
    $.each($("input[type=button]"), function(k, o) {
        if ($(o).val() == CLOSE_BTN && !$(o).hasClass('enabled')) {
            $(o).addClass('enabled');
        }
    });
    
    /* check download file after response */
    if (typeof DOWNLOAD_VAL != 'undefined' && DOWNLOAD_VAL != "") {
        var act = String(window.location).substring(document.forms[0].action.lastIndexOf("/"));
        act = act.substring(0, act.lastIndexOf("."));
        $('form[name="BaseForm"]').append(
                '<input id="' + DOWNLOAD_KEY + '" type="hidden" name="' + DOWNLOAD_KEY + '" value="' + DOWNLOAD_VAL + '" />');
        try {
            send(act);
        } finally {
            enabledBtn();
            $('#' + DOWNLOAD_KEY + '').remove();
        }
    }

    /* Set default data type response for $.post, $.get */
    $.ajaxSetup({
        dataType : 'text'
    });

    /* Overwrite $.post method */
    $.myAjaxPost = $.post;
    $.post = function(url, params, callback) {
        try {
            if ($.isFunction(params)) {
                callback = params;
                params = {};
            }
            disabledBtn();
            params['type'] = 'ajax';
            var paging = '';
            
            /*check and put parameter paging for paging*/
            for (var key in params) {
                if (String(key).indexOf('value.info.page') != -1) {
                    var ary = String(key).split('value.info.page', 2);
                    paging = String(ary[1]).substring(0, String(ary[1]).indexOf('.'));
                    break;
                };
            }
            if (paging != '') {
                params['paging'] = paging;
            }

            var lastChar = '_';
            if (typeof params['value.info.page'+ paging +'.hyojiKensu'] != 'undefined') {
                lastChar = '.';
            }
            
            /* check the same action */
            var curAct = String(window.location).substring(document.forms[0].action.lastIndexOf("/"));
            curAct = curAct.substring(0, curAct.lastIndexOf(lastChar));
            var act = url.substring(url.lastIndexOf("/"));
            act = act.substring(0, act.lastIndexOf(lastChar));
            
            var base64Flag = false;
            var isMyAct = (curAct == act);
            
            /*set parameter winName to control session of window*/
            var winMain = getWindowMain();
            params['value.info.winName'] = winMain.name;
            
            /*check and put parameter valueBase64 for paging*/
            if (typeof params['value.info.page'+ paging +'.hyojiKensu'] != 'undefined') {
                act = (typeof params['actKey'] != 'undefined') ? params['actKey'] : act;
                params['valueBase64'] = (typeof LIST_VALUE_BASE[act] == 'undefined') ? $('input[name="valueBase64"]').val()
                        : LIST_VALUE_BASE[act];
                base64Flag = true;
            } else {
                params['valueBase64'] = $('input[name="valueBase64"]').val();
            }
            
            /*set flag start request*/
            LIST_AJAX_REQUEST[act] = true;
            
            /*archive url request*/
            AJAX_URL = url;
            
            /*call ajax request*/
            $.myAjaxPost(url, params, function(data) {
                myAjaxCallBack.apply(this, [ data, callback, isMyAct, act,  base64Flag]);
            });
        } catch (e) {
            enabledBtn();
        };
    };

    /* Overwrite $.get method */
    $.get = $.post;
    
    /*init input file*/
    $('input.fileInput').change(function(){
        var pathFile = $(this).val();
        var ary = pathFile.split('\\');
        var val = ary[ary.length - 1]; 
        var name = $(this).attr('name');
        ary = name.split('[');
        ary = ary[1].split(']');
        var idx = ary[0];
        $('input[name="files\\\['+ idx +'\\\].formFileName"]').val(val);
    });
    
    $( document ).ajaxComplete(function(){
        setTimeout(function(){
            iniTabIndexOut();
        }, 1000);
        $.each($("input[type=button]"), function(k, o) {
            $(this).removeClass('ui-state-focus').removeClass('ui-state-hover');
        });
    });
    
    /*script final load*/
    if (typeof JSLOADER == 'object') {
        JSLOADER.loadJSByName('footer.load', null, null, true);
    }
});

/**
 * Close all popup
 */
var closeAllPopup = function() {
    $.each(LIST_POPUP, function(k, o) {
        if (typeof o === 'object' && 'close' in o) {
            o.close();
            LIST_POPUP.splice(k, 1);
        }
    });
};


/**
 * init tabindex out (-1)
 */
var LIST_ELE_FOCUS = {};
var iniTabIndexOut = function() {
    var listItem = [];
    var act = String(window.location).substring(String(window.location).lastIndexOf('/') + 1);
    act = act.substring(0, act.lastIndexOf('_'));
    if (SCREEN_INT_TABINDEX.inArray(act)) {
        /*set index -1*/
        $.each($("input, textarea, select, a"), function(k, o) {
            var tabIndex = $(o).attr('tabindex');
            if (tabIndex == undefined || isNaN(parseInt(tabIndex)) || (tabIndex.length > 0 && parseInt(tabIndex) < 1)) {
                $(o).attr('tabindex', '-1');
            } else if ($(o).length > 0) {
                listItem[tabIndex] = $(o);
            }
        });
        
        /*fire element input text for enter next focus*/
        _fireEleForEnter(listItem);
    }
};

/**
 * fire element input text for enter next focus
 */
var _fireEleForEnter = function(listItem) {
    
    if (!$.isEmptyObject(LIST_ELE_FOCUS) || listItem.length == 0) {
        return;
    }
    
    var item = '';
    var name = '';
    $.each(listItem, function(k, oEle) {
        if (!oEle) {
            return;
        }
        if (item != '') {
            LIST_ELE_FOCUS[item] = oEle;
        }
        name = oEle.attr('name');
        
        item = (name) ? name : 'a' + k;
        if (name) {
            oEle.on('keypress', function(event) {
                if (event.keyCode == 13) {
                    if ($(this).getType() == 'text' || $(this).getType() == 'password') {
                        var oItem = LIST_ELE_FOCUS[$(this).attr('name')];
                        if (oItem) {
                            if (oItem.getType() == 'button') {
                                setTimeout(function() {oItem.focus();}, 100);
                            } else {
                                oItem.focus();
                            }
                        }
                    }
                }
            });
        }
    });
};

/**
 * get window main
 */
var getWindowMain = function() {
    var winMain = null;
    if (typeof window.dialogArguments != 'undefined') {
        winMain = window.dialogArguments[1].win;
    } else if (typeof window.opener != 'undefined' && window.opener != null
            && typeof window.opener.closed != 'undefined' && !window.opener.closed 
            && window.name.indexOf(WINDOW_MAIN) > 0) {
        winMain = window.opener;
    } else {
        winMain = window;
    }
    return winMain;
};

/**
 * check parent window
 */
var checkParentWindow = function(win, level) {
    var hasParent = true;
    try {
        /* is modal popup */
        if (typeof win.dialogArguments != 'undefined' && win.dialogArguments[1].win.name.indexOf(WINDOW_MAIN) == -1) {
            hasParent = false;
            win = win.dialogArguments[1].win;
        /* is window popup */
        } else if (typeof win.opener != 'undefined' && win.opener != null && win.opener.name.indexOf(WINDOW_MAIN) == -1) {
            hasParent = false;
            win = win.opener;
        /* request invalid */
        } else if ((typeof win.dialogArguments == 'undefined' || win.dialogArguments == null) && window.parent != null && window.parent.name.indexOf(WINDOW_MAIN) == -1) {
            hasParent = false;
            win = window.parent;
        } else if ((typeof win.dialogArguments == 'undefined' || win.dialogArguments == null) && (typeof win.opener == 'undefined' || win.opener == null)) {
            hasParent = false;
        }
    
        if (!hasParent && level > 0) {
            hasParent = checkParentWindow(win, level - 1);
        }
    } catch (e) {
        hasParent = false;
    }
    return hasParent;
};

/* Close all child window when close parent window */
window.onbeforeunload = function() {
    /*closeAllPopup();*/
};

/* Check and define window.console */
if (!(window.console && console && console.log)) {
    var console = {
        log : function() {},
        debug : function() {},
        info : function() {},
        warn : function() {},
        error : function() {}
    };
}

/**
 * 右クリック抑止
 */
document.oncontextmenu = function() {
    return false;
};

/* define callback method for ajax request */
var myAjaxCallBack = function(data, callback, isMyAct, act, base64Flag) {
    
    try {
        if (data != null && typeof data == 'string' && data.trim() != '') {
            var obj = eval('(' + String(data).trim() + ')');
            if (isMyAct && obj != null && typeof obj.valueBase64 != 'undefined' && obj.valueBase64 != '') {
                /* update object value */
                $('input[name="valueBase64"]').val(obj.valueBase64);
            } else if (base64Flag) {
                LIST_VALUE_BASE[act] = obj.valueBase64;
            }
    
            /* check error */
            if (obj != null && typeof obj.value != 'undefined' && typeof obj.value.errorMessage != 'undefined' && obj.value.errorMessage != "") {
                if (SESSION_TIMEOUT_CODE != obj.value.errorId) {
                    removeClassError();
                    $('[name="' + obj.value.errorId + '"]').addClass('color_error');
                    $('[name="' + obj.value.errorId + '"]').trigger('validateError');
                }
                
                /*Check error code to forward error screen*/
                if (SYSTEM_ERROR_CODE == obj.value.errorId || SESSION_TIMEOUT_CODE == obj.value.errorId) {
    
                    $('form[name="BaseForm"]').append('<input type="hidden" name="system_error" value="' + obj.value.errorId + '" />');
    
                    var act = convertNullToEmpty(AJAX_URL.split(CONTEXT_PATH, 2)[1]);
                    if (act == "") {
                        window.location.replace(CONTEXT_PATH);
                    } else {
                        act = act.substring(0, act.lastIndexOf('.'));
                        send(act);
                    }
                } else {
                    var ele = elementFocus(obj.value.errorId, true);
                    if (!IS_TABLET) {
                        setTimeout(function() {
                            showMessage(obj.value.errorMessage);
                            try {
                                ele.focus();
                            } catch(e) {}
                        }, 300);
                    } else {
                        showMessage(obj.value.errorMessage);
                    }
                    focusTab(ele);
                    focusPage(ele);
                    
                    /* call callback method of function */
                    if (typeof callback === 'function') {
                        callback.apply(this, [ obj.value ]);
                    }
                    if (IS_TABLET) {
                        try {
                            ele.focus();
                        } catch(e) {}
                    }
                }
            } else if (obj != null) {/* no error */
                PAGING_VALUE = obj.paging;
                if (typeof callback === 'function') {
                    var objVal = {};
                    if (typeof obj.value != 'undefined') {
                        objVal = obj.value;
                    }
                    /* call callback method of function */
                    callback.apply(this, [ objVal ]);
                    
                    /*set row hover to data list*/
                    if (objVal.length > 0 && $('div#scrollTableBoxBody').length > 0) {
                        $('div#scrollTableBoxBody').each(function() {
                            addRowHover(this);
                        });
                    }
                }
            }
        };
    } finally {
        
        /*remove flag when request finished*/
        delete LIST_AJAX_REQUEST[act];
        setTimeout(function() {
            enabledBtn();
        }, 500);
        
    }
};

/**
 * check object error
 */
var isNotError = function(obj) {
    return !(typeof obj.errorMessage !== 'undefined' && obj.errorMessage !== null);
};

var LIST_VALUE_BASE = {};
var PAGING_VALUE = {};
var AJAX_URL = "";

/**
 * Paging for AJAX request
 */
var pagingAJAX = function(func) {
    var html = [];
    var pInfo = PAGING_VALUE;

    try {
        html[html.length] = '<table style="height:20px;"><tr>';

        if (pInfo.showHyojiKensu == 1) {
            html[html.length] = '<td class="hideNumRecord" style="width: 120px; text-align:left;padding-left:2px;">Số bản ghi/trang：</td>';
            html[html.length] = '<td class="hideNumRecord" style="width: 48px; text-align:left;">';
            html[html.length] = '<select class="listNumRecord" onchange="' + func + '(1, this.value);">';
            for ( var key in pInfo.listNumRecord) {
                var selected = (key == pInfo.hyojiKensu) ? ' selected="selected"' : '';
                html[html.length] = '<option value="' + key + '"' + selected + '>' + pInfo.listNumRecord[key] + '</option>';
            }
            html[html.length] = '</select></td>';
        }

        html[html.length] = '<td class="center pageNo" align="center" style="padding-left: 20px;">';

        if (pInfo.listPaging.length > 0) {
            html[html.length] = '<table align="center" style="margin: 0px auto;"><tr>';
            
            /*check first page*/
            if (pInfo.currentPage > 1) {
                html[html.length] = '<td align="center"><a onclick="' + func + '(1, ' + pInfo.hyojiKensu + ');" href="javascript:void(0);">|&lt;</a>&nbsp;</td>';
            } else {
                html[html.length] = '<td>|&lt;&nbsp;</td>';
            }

            /*check rang list prev*/
            if (pInfo.currentPage > 10) {
                html[html.length] = '<td><a onclick="' + func + '(' + (pInfo.currentPage - 10 - ((pInfo.currentPage - 1) % 10)) + ', ' + pInfo.hyojiKensu
                        + ');" href="javascript:void(0);">&lt;&lt;</a>&nbsp;</td>';
            } else {
                html[html.length] = '<td>&lt;&lt;&nbsp;</td>';
            }

            /*write paging*/
            for (var i = 0, l = pInfo.listPaging.length; i < l; i++) {
                if (pInfo.currentPage == pInfo.listPaging[i]) {
                    html[html.length] = '<td><span class="curPage">' + addCommaJS(pInfo.listPaging[i]) + '</span>&nbsp;</td>';
                } else {
                    html[html.length] = '<td><a onclick="' + func + '(' + pInfo.listPaging[i] + ', ' + pInfo.hyojiKensu
                            + ');" href="javascript:void(0);">' + addCommaJS(pInfo.listPaging[i]) + '</a>&nbsp;</td>';
                }
            }

            /*check rang list next*/
            if (pInfo.listPaging[pInfo.listPaging.length - 1] < pInfo.lastPage) {
                html[html.length] = '<td><a onclick="' + func + '(' + (pInfo.currentPage + (10 - ((pInfo.currentPage - 1) % 10))) + ', '
                        + pInfo.hyojiKensu + ');" href="javascript:void(0);">&gt;&gt;</a>&nbsp;</td>';
            } else {
                html[html.length] = '<td>&gt;&gt;&nbsp;</td>';
            }

            /*check last page*/
            if (pInfo.currentPage < pInfo.lastPage) {
                html[html.length] = '<td><a onclick="' + func + '(' + pInfo.lastPage + ', ' + pInfo.hyojiKensu
                        + ');" href="javascript:void(0);">&gt;|</a>&nbsp;</td>';
            } else {
                html[html.length] = '<td>&gt;|&nbsp;</td>';
            }
            html[html.length] = '</tr></table>';
        }

        html[html.length] = '</td>';
        html[html.length] = '<td align="right" style="padding-left: 20px;" class="countPage">';

        if (pInfo.allKensu > 0) {
            html[html.length] = addCommaJS(pInfo.startKensu) + '&nbsp;-&nbsp;' + addCommaJS(pInfo.currentKensu) + '&nbsp;/&nbsp;' + addCommaJS(pInfo.allKensu) + '&nbsp;bản ghi';
        } else {
            html[html.length] = '<span class="display_hidden">000&nbsp;-&nbsp;000&nbsp;/&nbsp;000&nbsp;</span>';
        }

        html[html.length] = '</td></tr></table>';
    } finally {
        PAGING_VALUE = {};
    }

    return html.join('');
};

/**
 * Overwrite window.alert method
 */
(function() {
    var proxied = window.alert;
    window.alert = function() {
        if (typeof arguments[0] != 'undefined' && arguments[0] != null 
                && arguments[0] != 'undefined' && arguments[0] != 'object' 
                    && arguments[0] != '') {
            arguments[0] = String(arguments[0]).unhtmls().breakLine();
            proxied.apply(this, arguments);
        }
    };
})();

/**
 * Check and show message error
 * 
 * @param errorId
 * @param errorMsg
 */
var cnt = 10;

ShowNotification = function(options) {
  var message = "<div id='ntf" + cnt + "' class='text alert-" + options.type + "' style='display:none'><h2><i class='fa fa-bell'></i> " + options.title +
    "</h2><div class='close'><a href='javascript:;' class='notification_close'><i class='fa fa-close'></i></a></div><p>" + options.text + "</p></div>";

  if (!document.getElementById('custom_notifications')) {
    alert('doesnt exists');
  } else {
    $('#custom_notifications ul.notifications').append("<li><a id='ntlink" + cnt + "' class='alert-" + options.type + "' href='#ntf" + cnt + "'><i class='fa fa-bell animated shake'></i></a></li>");
    $('#custom_notifications #notif-group').append(message);
    cnt++;
    CustomTabs(options);
  }
};

CustomTabs = function(options) {
  $('.tabbed_notifications > div').hide();
  $('.tabbed_notifications > div:first-of-type').show();
  $('#custom_notifications').removeClass('dsp_none');
  $('.notifications a').click(function(e) {
    e.preventDefault();
    var $this = $(this),
      tabbed_notifications = '#' + $this.parents('.notifications').data('tabbed_notifications'),
      others = $this.closest('li').siblings().children('a'),
      target = $this.attr('href');
    others.removeClass('active');
    $this.addClass('active');
    $(tabbed_notifications).children('div').hide();
    $(target).show();
  });
};

CustomTabs();

var tabid = idname = '';

$(document).on('click', '.notification_close', function(e) {
  idname = $(this).parent().parent().attr("id");
  tabid = idname.substr(-2);
  $('#ntf' + tabid).remove();
  $('#ntlink' + tabid).parent().remove();
  $('.notifications a').first().addClass('active');
  $('#notif-group div').first().css('display', 'block');
});

/**
 * Focus element error
 */
function elementFocus(errorId, isError) {
    var eleFocus = null;

    /* check errorId and focus element */
    var ele = $('input[name="' + errorId + '"]');
    ele = (ele.length > 0) ? ele : $('textarea[name="' + errorId + '"]');
    ele = (ele.length > 0) ? ele : $('select[name="' + errorId + '"]');
    
    if (isError && ele.length > 0 && typeof ele.prev().children == 'function') {
        var cls = ele.prev().attr('class');
        if (cls && (cls.indexOf('Fake') != -1 || cls.indexOf('fake') != -1)) {
            ele.prev().addClass('color_error');
        }
    }
    
    if (isError && !ele.hasClass('color_error')) {
        ele.addClass('color_error');
    }
    
    if (ele.length > 0) {
        if (isFocusEnabled(ele.get(0))) {
            changeFlag();
            eleFocus = ele;
            eleFocus.focus();
            textSelect(eleFocus.get(0));
        }
    } else {
        /* Find first element can focus */
        var listObjEle = [];
        var listIndexEle = [];
        $.each($("input[type=text], input[type=password], input[type=radio], input[type=checkbox], input[type=file], textarea, select"), function(k, o) {
            listObjEle[listObjEle.length] = o;
            var tabIndex = $(o).attr('tabindex');
            try {
                if (tabIndex != undefined && tabIndex.length > 0 && parseInt(tabIndex) >= 0) {
                    listIndexEle[parseInt(tabIndex)] = o;
                }
            } catch(e){}
        });
        
        if (listIndexEle.length > 0) {
            for (var i = 0, l = listIndexEle.length; i < l; i++) {
                if (listIndexEle[i] != null && typeof listIndexEle[i] == 'object' && isFocusEnabled(listIndexEle[i])) {
                    eleFocus = $(listIndexEle[i]);
                    eleFocus.focus();
                    break;
                }
            }
        } else if (listObjEle.length > 0) {
            for (var i = 0, l = listObjEle.length; i < l; i++) {
                if (isFocusEnabled(listObjEle[i])) {
                    eleFocus = $(listObjEle[i]);
                    eleFocus.focus();
                    break;
                }
            }
        }
    }
    
    return eleFocus;
}

/**
 * Remove class error
 */
function removeClassError(parent) {
    var eles = null;
    if (parent) {
        eles = $('input[type=text], input[type=password], input[type=file], input[type=radio], input[type=checkbox], textarea, select', parent);
    } else {
        eles = $('input[type=text], input[type=password], input[type=file], input[type=radio], input[type=checkbox], textarea, select');
    }
    $.each(eles, function(k, o) {
        $(o).removeClass('color_error');
    });
}

/**
 * Process focus tab has element error
 * 
 * @param ele
 */
function focusTab(ele) {
    if (ele != null && ele.length > 0) {
        var oPanel = ele.closest('div.ui-tabs-panel');
        var oTab = oPanel.parent().closest('div.ui-tabs');
        if (oTab.length > 0 && oPanel.length > 0) {
            oTab.tabs("option", "active", $('ul li[aria-controls="' + oPanel.attr('id') + '"]', oTab).index());
            if (oTab.parent().closest('div.ui-tabs').length > 0) {
                focusTab(oTab.parent());
            }
        }
    }
}

/**
 * Process focus page has element error
 * 
 * @param ele
 */
function focusPage(ele) {
    if (ele != null && ele.length > 0) {
        var oPanel = ele.closest('div.ui-tabs-panel');
        var oSwPage = ele.closest('div.swPage');
        if (oSwPage.length > 0) {
            var pageIndex = oSwPage.attr('page');
            if (oPanel.length > 0) {
                $('.swControls .swPage' + pageIndex, oPanel).click();
                
            } else {
                $('.swControls .swPage' + pageIndex).click();
            }
        }
    }
}

/**
 * 指定elementにフォーカスが当たるか判定する
 * 
 * @param elem
 * @return
 */
function isFocusEnabled(elem) {

    if (elem.nodeType != 1) {
        return false;
    }

    if (elem.style != null) {
        style = elem.style.display;
    }
    var className = elem.className;

    /* FOCUSが当たらない要素の場合 */
    if ((style != null && (style.toUpperCase() == 'NONE') || (style.toUpperCase() == 'HIDDEN'))
            || (className != null && (className.indexOf('display_none') != -1 || className.indexOf('display_hidden') != -1))) {
        return false;
    }

    if ((elem.nodeName == 'INPUT' && elem.type != null && elem.type.toUpperCase() != 'HIDDEN' && elem.type.toUpperCase() != 'BUTTON')
            || elem.nodeName == 'SELECT' || elem.nodeName == 'TEXTAREA') {

        if (!elem.disabled && !elem.readOnly) {
            return true;
        }
    }

    return false;
}

/**
 * テキストを大文字に変換する
 * 
 * @param elem
 */
function toUpperText(elem) {
    elem.value = elem.value.toUpperCase();
}

var commonBtnDisabled = false;
var commonBtnIgnore = false;

/**
 * Disabled all button
 * @param ignore
 *      TRUE: is ignore enabledBtn() function
 *          button enabled when enabledBtn(true)
 */
function disabledBtn(ignore) {
    if (ignore) {
        commonBtnIgnore = true;
    }
    if (ignore || !commonBtnDisabled) {
        commonBtnDisabled = true;
        $("input[type=button], input[type=reset], input[type=submit]").each(function(i) {
            if (!$(this).hasClass('enabled')) {
                $(this).disabled(true);
            }
        });
    }
}

/**
 * Enabled all button
 * @param force TRUE: force enable
 */
function enabledBtn(force) {
    if (force) {
        commonBtnIgnore = false;
    }

    if (!$.isEmptyObject(LIST_AJAX_REQUEST)) {
        return; 
    }
    
    if (commonBtnDisabled && !commonBtnIgnore) {
        $("input[type=button], input[type=reset], input[type=submit]").each(function(i) {
            if (!$(this).hasClass('disabled')) {
                $(this).disabled(false);
            }
        });
        commonBtnDisabled = false;
    }
}

/**
 * Go to page
 * 
 * @param act
 * @param page
 * @param paging
 */
function gotoPage(act, page, paging) {
    if (page == null || isNaN(parseInt(page)) || parseInt(page) < 1) {
        page = 1;
    }
    
    if (paging == null || isNaN(parseInt(paging)) || parseInt(paging) < 1) {
        paging = '';
    }
    if ($('#currentPageId'+ paging).length > 0) {
        $('#currentPageId'+ paging).val(page);
    } else {
        $('#BaseForm').append('<input type="hidden" id="currentPageId'+ paging +'" name="value.info.page' + paging + '.currentPage" value="' + page + '" />');
    }
    if ($('#usePaging'+ paging).length > 0) {
        $('#usePaging'+ paging).val(page);
    } else {
        $('#BaseForm').append('<input id="usePaging" type="hidden" name="paging" value="' + paging + '" />');
    }
    send(act);
}

/**
 * Set record on page
 * 
 * @param e
 * @param paging
 */
function setHyojiKensu(e, paging) {
    if (paging == null || isNaN(parseInt(paging)) || parseInt(paging) < 1) {
        paging = "";
    }
    if ($('#hyojiKensuId'+ paging +'').length > 0) {
        $('#hyojiKensuId'+ paging +'').val(e.value);
    } else {
        $('#BaseForm').append('<input type="hidden" id="hyojiKensuId'+ paging +'" name="value.info.page' + paging + '.hyojiKensu" value="' + e.value + '" />');
    }
    $.each($('.listNumRecord'), function(k, o) {
        $(o).val(e.value);
    });
}

/**
 * 
 * submit関数
 * 
 * @param act
 *            アクション名(.doを除く)
 * @param time
 *            (milliseconds to enabled button)
 */
function download(act, time) {
    try {
        var target = formTarget();
        formTarget('_self');
        send(act);
        formTarget(target);
    } finally {
        time = (time != null && typeof time != 'undefined' && time > 0) ? time : BTN_DOWNLOAD_TIMER;
        setTimeout(function() {
            enabledBtn();
        }, time);
    }
}

/**
 * set ang get form target
 * @param target
 * @returns
 */
function formTarget(target) {
    if (arguments.length == 1) {
        if (target) {
            document.forms[0].target = target;
            $('#BaseForm').attr('target', target);
        } else {
            $('#BaseForm').removeAttr('target');
        }
    } else {
        return $('#BaseForm').attr('target');
    }
}

/**
 * 
 * submit関数
 * 
 * @param act
 *            アクション名(.doを除く)
 */
function send(act) {
    disabledBtn();
    $('form[name=BaseForm]').ready(function() {
        ValidatePlus.buildItemPattern();
        var isDisabled = $("input[type=file]").is(':disabled');
        if (!isDisabled) {
            $("input[type=file]").attr("disabled", "disabled");
        }
        document.forms[0].action = CONTEXT_PATH + act + ".do";
        document.forms[0].submit();
        if (!isDisabled) {
            $("input[type=file]").removeAttr("disabled");
        }
    });
    return true;
}


/**
 * 
 * ファイルアップロード 処理
 * 
 * セキュリティエラー(存在しないファイルのアップロード等）の場合、 ファイルタグを無効にして送信する。
 * 
 * @param act
 *            アクション名(.doを除く)
 * @return
 */
function upload(act) {
    disabledBtn();
    $('form[name=BaseForm]').ready(function() {
        ValidatePlus.buildItemPattern();
        try {
            document.forms[0].encoding = "multipart/form-data";
            document.forms[0].action = CONTEXT_PATH + act + ".do";
            document.forms[0].submit();
        } catch (e) {
            var isDisabled = $("input[type=file]").is(':disabled');
            if (!isDisabled) {
                $("input[type=file]").attr("disabled", "disabled");
            }
            document.forms[0].submit();
            if (!isDisabled) {
                $("input[type=file]").removeAttr("disabled");
            }
        }
    });
    return true;
}


function fnExcelReport(table, fileName){
    var tab_text="<table border='1px'><tr bgcolor='#87AFC6'>";
    var j=0;
     tab = document.getElementById(table); // id of table
     //get content from table
     for(j = 0 ; j < tab.rows.length ; j++) 
     {     
           tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
     }
     tab_text=tab_text+"</table>";
     
     
     tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
     tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
     tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

     var ua = window.navigator.userAgent;
     var msie = ua.indexOf("MSIE "); 

    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
       {
              txtArea1.document.open("txt/html","replace");
              txtArea1.document.write(tab_text);
              txtArea1.document.close();
              txtArea1.focus(); 
              sa=txtArea1.document.execCommand("SaveAs", true, fileName);
             }  
     else                 //other browser not tested on IE 11
         sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  
return (sa);
}

/**
 * ダイアログ起動関数
 * 
 * @param act :
 *            アクションパス
 * @param dwidth :
 *            ダイアログ幅
 * @param dheight :
 *            ダイアログ高さ
 * @param params :
 *            入出力パラメータ(0 : inparam / 1 : outParam)
 */
function openShowModal(act, dwidth, dheight, params) {
    try {
        var date = new Date();
        var url = CONTEXT_PATH + act + '.do?t=' + date.getTime();

        params = (params == null) ? [] : params;
        params[0] = (typeof params[0] == "undefined") ? {} : params[0];
        params[1] = (typeof params[1] == "undefined") ? {} : params[1];
        params[1].win = window;

        var pLeft = window.screenX + ((window.innerWidth - dwidth) / 2);
        var pTop = window.screenY + ((window.innerHeight - dheight) / 2);
        var rc = showModalDialog(url, params, "dialogWidth:" + dwidth + "px;dialogHeight:" + dheight + "px;dialogLeft:" + pLeft + "px;dialogTop:" + pTop + "px;resizable:0;scroll:0;status:0");
        if (rc == 1) { /*return normal*/
            changeFlag();
        } else if (rc == 2) { /*session timeout*/
            /* config URL login */
            window.location.replace(CONTEXT_PATH + '/Login_init.do');
        } else if (rc = 100) { /*Close popup by [X]*/
            if (typeof params[0].func != 'undefined' && typeof params[0].func == 'function') {
                params[0].func.apply(this, []);
            }
        }
        return rc;
    } finally {
    }
}

/**
 * Modal dialog return
 * 
 * @param func :
 *            function name
 */
function dialogReturn() {
    var iParam = window.dialogArguments[0];
    var f = eval("window.dialogArguments[1].win." + iParam.func);
    if (typeof f == 'function') {
        f.apply(this, arguments);
        window.returnValue = 1; /* 1: return success */
    } else {
        alert('Function [' + iParam.func + '] not existed.');
    }
    window.close();
}

/**
 * Open popup window normal
 * 
 * @param act:
 *            action
 * @param winName :
 *            window name
 * @param pwidth :
 *            window eidth
 * @param pheight :
 *            window height
 * @param isReload : 
 *            optional (true | false), default is true
 */
function openWindow(act, popupName, pwidth, pheight, isReload) {
    var win = null;
    var pLeft = 0;
    var pTop = 0;
    try {
        pLeft = window.screenX + ((window.innerWidth - pwidth) / 2);
        pTop = window.screenY + ((window.innerHeight - pheight) / 2);
        var opts = 'toolbar=no,status=yes,menubar=no,scrollbars=no,resizable=no,directories=no,location=no,width=' + pwidth + ',height=' + pheight
                + ',left='+ pLeft +',top='+ pTop +'';
        if (!popupName) {
            popupName = '_winChild';
        }
        popupName = popupName + '_' + window.name;
        win = window.open('', popupName, opts);
        isReload = (isReload == null) ? true : isReload;
        if (isReload || win.location == 'about:blank') {
            LIST_POPUP[LIST_POPUP.length] = win;
            var orgTarget = formTarget();
            formTarget(popupName);
            var changeFlag = $('input[name="changeflag"]').val();
            $('input[name="value.info.winName"]').val(window.name);
            send(act);
            formTarget(orgTarget);
            $('input[name="changeflag"]').val(changeFlag);
        }
    } finally {
        enabledBtn();
        if (win != null) {
            win.moveTo(pLeft, pTop);
            win.focus();
        }
    }
    return win;
}

/**
 * Jquery dialog
 * 
 * @param act :
 *            アクションパス
 * @param dwidth :
 *            ダイアログ幅
 * @param dheight :
 *            ダイアログ高さ
 * @param params :
 *            key1: value1, key1: value2, ....
 * @param isModal : true or false
 */
function openDialogJquery(act, dwidth, dheight, params, isModal) {
    
    var dialog = null;
    var targetDialog = act.substr(1, 7) + '_' + window.name;
    if ($('iframe[name="' + targetDialog + '"]').length == 0) {
        isModal = (typeof isModal == 'undefined' || isModal == null) ? true : isModal;
        dialog = $('<iframe name="' + targetDialog + '" frameborder="0" scrolling="no" />').appendTo('body').dialog({
            height: dheight,
            width: dwidth,
            resizable: false,
            modal: isModal
        }).width(dwidth - 25).height(dheight - 30);
    } else {
        dialog = $('iframe[name="' + targetDialog + '"]').dialog('open').width(dwidth - 25).height(dheight - 30);
    }
    
    var target = formTarget();
    formTarget(targetDialog);
    
    var items = [];
    var name = '';
    $.each($('input, textarea, select'), function(k, o) {
        name = $(o).attr('name');
        if (!$(o).is(':disabled') && name != 'valueBase64' && name != 'value.info.responseClassCode' && name != 'value.info.receiptFormCode') {
            items[items.length] = $(o);
            $(o).disabled(true, true);
        }
    });
    
    var _tmp = [];
    if (typeof params == 'object') {
        $.each(params, function(k, v) {
            _tmp[_tmp.length] = $('<input type="hidden" name="'+ k +'" value="' + String(v).htmls() + '" />').appendTo('#BaseForm');
        });
    }
    
    send(act);
    formTarget(target);
    
    setTimeout(function() {
        $.each(items, function(k, o) {
            o.disabled(false, true);
        });
        
        $.each(_tmp, function(k, o) {
            o.remove();
        });
    }, 2000);
    
    return dialog;
}

/**
 * 確認ダイアログを開く。 ダイアログでキャンセルされた場合、ボタンのロックを解除する。
 * 
 * @param msg
 * @return
 */
function windowConfirm(msg) {

    var result = null;
    if (window.confirm(msg.unhtmls().breakLine())) {
        result = true;
    } else {
        result = false;
    }

    return result;
}

/**
 * Copy value to element target
 * 
 * @param value
 * @param target
 */
function copyValuetoName(value, target) {
    $('input[name="' + target + '"]').val(value);
}

/**
 * チェックボックスクリック時の切り替え制御
 */
function clickCheckBox(elem, onValue, offValue, target) {
    if (elem.checked) {
        copyValuetoName(onValue, target);
    } else {
        copyValuetoName(offValue, target);
    }
}

/**
 * Fix code for element
 * 
 * @param elem
 * @param len
 * @returns
 */
function fixCode(elem, len) {
    var val = toHalfSize(elem.value).replace(/,/g, "").replace(/，/g, "").replace(/、/g, "").replace(/．/g, "").replace(/¥/g, "");
    if (val.trim() != "") {
        elem.value = fixCodeJS(val.trim(), len);
    }
}

/**
 * Fix code for string
 * 
 * @param val
 * @param len
 */
function fixCodeJS(val, len) {
    if (val.trim() != "") {
        for (var i = val.trim().length; i < len; i++) {
            val = '0' + val;
        }
    }
    return val;
}

/**
 * 小数点以下整形
 * 
 * @param elem
 * @param num
 */
function formatDecimal(elem, num) {
    var value = toHalfSize(elem.value).replace(/,/g, "").replace(/，/g, "").replace(/、/g, "").replace(/．/g, "").replace(/¥/g, "");
    if (!isNaN(value) && String(value).trim() != '') {
        elem.value = formatDecimalJS(value, num);
    }
}

/**
 * Fomat Decimal
 * 
 * @param val
 * @param num
 */
function formatDecimalJS(val, num) {

    if (isNaN(val) || val == '' || val.length == 0) {
        return;
    }

    var shosu = '';
    var seisu = '';

    if (val.length == 0) {

        seisu = '0';

        for (var i = 0; i < num; i++) {
            shosu += '0';
        }
    } else {
        if (String(val).substring(0, 1) == '.') {
            return val;
        }

        var periodIndex = String(val).lastIndexOf('.');

        if (periodIndex > 0) {
            shosu += String(val).substring(periodIndex + 1, val.length);
            shosu = (shosu.length <= num) ? shosu : (String(shosu).substring(0, num));
            shosu = String(shosu).replace(/[0]+$/, "0");
            shosu = String(shosu).replace(/([1-9]{1})[0]+$/, "$1");
            seisu += String(val).substring(0, periodIndex);
        } else {
            seisu += val;
        }

        for (var i = shosu.length; i < num; i++) {
            shosu += '0';
        }
    }

    var ret = '';
    if (num == 0 && shosu == '') {
        ret = seisu;
    } else if (shosu.length > 0) {
        ret = seisu + "." + shosu;
    }

    if (parseFloat(ret) == 0) {
        ret = 0;
    }
    return ret;
}

/**
 * カンマ付加
 * 
 * @param value
 * @return
 */
function addComma(elem) {
    var value = toHalfSize(elem.value).replace(/,/g, "").replace(/，/g, "").replace(/、/g, "").replace(/．/g, "").replace(/¥/g, "");
    if (!isNaN(value) && String(value).trim() != '') {
        elem.value = addCommaJS(value);
    }
}

/**
 * Convert String Null to Empty
 * @param val
 * @returns {String}
 */
function convertNullToEmpty(val) {
    var s = '';
    if (typeof val !== 'undefined' && val !== null) {
        s = val;
    }
    return s;
}
/**
 * Add comma to string number
 * 
 * @param val
 * @returns {String}
 */
function addCommaJS(val) {
	
    if (isNaN(val) || String(val).trim() == '') {
        return '';
    }
    
    val = String(val).replace(/^([+-]?)([0]+)/, "$1" + "0");
    val = String(val).replace(/^([+-]?)([0]+)([1-9]{1})/, "$1$3");

    for (var i = 0; i < val.length / 3; i++) {
        val = String(val).replace(/^([+-]?[1-9]{1}\d*)(\d\d\d)/, "$1,$2");
    }
    return val;
}
function to0(val){
	if(val == ''){
		return 0;
	}
	return val;
}

/**
 * Remove comma, JPY
 * 
 * @param val
 */
function removeCommaJS(val) {
    if (val == null || typeof val == 'undefined' || val == '') {
        return '-';
    }
    return val.split(',').join('').split('¥').join('');
}

/**
 * Add comma, JPY to string in element
 * 
 * @param elem
 * @returns
 */
function addJPY(elem) {
    var value = toHalfSize(elem.value).replace(/,/g, "").replace(/，/g, "").replace(/、/g, "").replace(/．/g, "").replace(/¥/g, "");
    if (!isNaN(value) && String(value).trim() != '') {
        elem.value = addCommaJPYJS(value);
    }
}
/**
 * Add JPY to string
 * 
 * @param val
 * @returns
 */
function addJPYJS(val) {
    if (val == null || String(val).trim() == '') {
        return '';
    } else {
        return '¥' + val;
    }
}

/**
 * Add comma, JPY to string
 * 
 * @param val
 * @returns
 */
function addCommaJPYJS(val) {
    if (val == null || String(val).trim() == '') {
        return '';
    } else {
        return addJPYJS(addCommaJS(val));
    }
}

/**
 * カンマ削除
 * 
 * @param value
 * @param item
 * @return
 */
function removeItem(value, item) {
    return value.split(item).join("");
}

/**
 * カンマ削除
 * 
 * @param elem
 * @return
 */
function removeComma(elem) {
    elem.value = removeItem(removeItem(elem.value, ","), "¥");
}

/**
 * スラッシュ削除
 * 
 * @param elem
 * @return
 */
function removeSlash(elem) {
    elem.value = removeItem(elem.value, "/");
}

/**
 * コロン削除
 * 
 * @param elem
 * @return
 */
function removeColon(elem) {
    elem.value = removeItem(elem.value, ":");
}

/**
 * INPUTタグのvalue値trim
 * 
 * @param elem
 * @return
 */
function trim(elem) {
    elem.value = elem.value.trim();
}

/**
 * To half-size
 * 
 * @param str
 * @returns {String}
 */
function toHalfSize(str) {
    var tmp = "";
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 65248 && str.charCodeAt(i) < 65375) {
            tmp += String.fromCharCode(str.charCodeAt(i) - 65248);
        } else {
            tmp += String.fromCharCode(str.charCodeAt(i));
        }
    }
    return tmp;
}

/**
 * To full-size
 * 
 * @param txtstring
 * @returns {String}
 */
function toFullSize(txtstring) {
    var tmp = "";
    for (var i = 0; i < txtstring.length; i++) {
        if (txtstring.charCodeAt(i) == 32) {
            tmp = tmp + String.fromCharCode(12288);
        } else {
            if (txtstring.charCodeAt(i) < 127) {
                tmp = tmp + String.fromCharCode(txtstring.charCodeAt(i) + 65248);
            } else {
                tmp = tmp + String.fromCharCode(txtstring.charCodeAt(i));
            }
        }
    }
    return tmp;
}

/**
 * yyyymmdd形式文字列をyyyy/mm/dd形式へフォーマット
 * 
 * @param elem
 * @return
 */
function formatYMD(elem) {
    var value = toHalfSize(elem.value).replace(/・/g, "/").replace(/\./g, "/");
    if (value != '') {
        var tmp = $.formatDateTime('yy/mm/dd', new Date(value.replace(/-/g, '/')));
        if (tmp.indexOf('NaN') == -1) {
            value = tmp; 
        }
        var val = value.replace(/-/g, "").replace(/\//g, "");
        if (isNaN(val) || val.length != 8) {
            return;
        }
        var _date = new Date();
        if (value.indexOf('-') != -1 || value.indexOf('/') != -1) {
            value = value.replace(/-/g, "/");
            var ary = value.split("/");
            if (ary.length != 3) {
                return;
            }
            ary[0] = (typeof ary[0] == 'undefined') ? '' : ary[0];
            ary[1] = (typeof ary[1] == 'undefined') ? '' : ary[1];
            ary[2] = (typeof ary[2] == 'undefined') ? '' : ary[2];
            value = ary[0] + ((String(ary[1]).length < 2 && ary[1] != '') ? '0' + ary[1] : ary[1])
                    + ((String(ary[2]).length < 2 && ary[2] != '') ? '0' + ary[2] : ary[2]);
        }
        var m = value.substring("yyyy".length, "yyyymm".length);
        m = (isNaN(m) || m == '' || m == '0') ? (_date.getMonth() + 1) : m;
        m = (String(m).length < 2) ? '0' + m : m;
        var d = value.substring("yyyymm".length);
        d = (isNaN(d) || d == '' || d == '0') ? _date.getDate() : d;
        d = (String(d).length < 2) ? '0' + d : d;
        value = value.substring(0, "yyyy".length) + '/' + m + '/' + d;
        elem.value = value;
    }
}

/**
 * yyyymm形式文字列をyyyy/mm形式へフォーマット
 * 
 * @param elem
 * @return
 */
function formatYM(elem) {
    var value = toHalfSize(elem.value).replace(/・/g, "/").replace(/\./g, "/");
    if (value != '') {
        var tmp = $.formatDateTime('yy/mm', new Date(value.replace(/-/g, '/') + '/01'));
        if (tmp.indexOf('NaN') == -1) {
            value = tmp; 
        }
        var val = value.replace(/-/g, "").replace(/\//g, "");
        if (isNaN(val) || val.length != 6) {
            return;
        }
        var _date = new Date();
        if (value.indexOf('-') != -1 || value.indexOf('/') != -1) {
            value = value.replace(/-/g, "/");
            var ary = value.split("/");
            if (ary.length != 2) {
                return;
            }
            ary[0] = (typeof ary[0] == 'undefined') ? '' : ary[0];
            ary[1] = (typeof ary[1] == 'undefined') ? '' : ary[1];
            value = ary[0] + ((String(ary[1]).length < 2 && ary[1] != '') ? '0' + ary[1] : ary[1]);
        }
        var m = value.substring("yyyy".length, "yyyymm".length);
        m = (isNaN(m) || m == '' || m == '0') ? (_date.getMonth() + 1) : m;
        m = (String(m).length < 2) ? '0' + m : m;
        value = value.substring(0, "yyyy".length) + '/' + m;
        elem.value = value;
    }
}

/**
 * hhMM形式文字列をhh:MM形式へフォーマット
 * 
 * @param elem
 * @return
 */
function formatHH_MM(elem) {

    var value = toHalfSize(elem.value);
    var tmp = $.formatDateTime('hh:ii', new Date('1970/01/01 ' + value + ':00'));
    if (tmp.indexOf('NaN') == -1) {
        value = tmp; 
    }
    value = value.replace(/：/g, "");

    if (value.length == "hhMM".length && !isNaN(value)) {
        value = value.substring(0, "hh".length) + ":" + value.substring("hh".length, "hhMM".length);
    }

    elem.value = value;
}

/**
 * hhMMss形式文字列をhh:MM:ss形式へフォーマット
 * 
 * @param elem
 * @return
 */
function formatHH_MM_SS(elem) {

    var value = toHalfSize(elem.value);
    var tmp = $.formatDateTime('hh:ii:ss', new Date('1970/01/01 ' + value));
    if (tmp.indexOf('NaN') == -1) {
        value = tmp; 
    }
    value = value.replace(/：/g, "");

    if (value.length == "hhMMss".length && !isNaN(value)) {
        value = value.substring(0, "hh".length) + ":" + value.substring("hh".length, "hhMM".length) + ":" + value.substring("hhMM".length, "hhMMss".length);
    }

    elem.value = value;
}
/**
 * @param bytes
 * @return 
 * 		String value
 */
function formatByte (bytes) {

	try {

		if (bytes < 1048576)
			return (bytes / 1024).toFixed(2) + "KB";

		if (bytes < 1073741824)
			return (bytes / 1048576).toFixed(2) + "MB";

		if (bytes >= 1073741824)
			return (bytes / 1073741824).toFixed(2) + "GB";

	} catch (err) {
		
		console.log("Exception: " + err);
		return "";
	}

}

/**
 * @param Long millisecond, 
 * @param format String
 */
function formatLongToDate (longMillisecond, formatString) {

	try {

		var date = new Date(longMillisecond);
		return formatDate(date, formatString).toString();
	} catch (err) {

		console.log("Can't convert " + longMillisecond + " to date.\n");
		console.log("Exception: " + err);
		return "--";
	}
}
/**
 * Format PostalCode
 */
function formatPostalCode(s) {
    s = String(s).trim();
    if (s.length > 0) {
        if (s.length > 3) {
            return s.substring(0, 3) + "-" + s.substring(3);
        } else {
            return s;
        }
    } else
        return '';
}

/**
 * delete minus in string
 * 
 * @param s
 * @returns
 */
function delMinusChar(s) {
    s = String(s).trim();
    if (s.length > 0) {
        s = removeItem(s, "-");
        return s;
    } else {
        return '';
    }
}

/**
 * selected TextRange when focus
 * 
 * @param elem
 */
function textSelect(elem) {
    try {
        if (typeof elem.createTextRange == 'function') {
            var rng = elem.createTextRange();
            elem.caretPos = elem.value.length;
            rng.select();
        } else {
            elem.select();
        }
    } catch (e) {
    }
}

/**
 * 入力項目変更フラグを立てる
 * 
 * @return
 */
function changeFlag(e) {
    if (e == null || !$(e).hasClass('ignore')) {
        $('input[name=changeflag]').val('1');
    }
}

/**
 * 入力項目変更フラグを立てる
 *
 * @return
 */
function clearChangeFlag() {
    $('input[name=changeflag]').val('0');
}

/**
 * 更新画面から移動する際の確認メッセージ表示
 *
 * @return
 */
function lossMessage(msg) {
    if ($('input[name=changeflag]').val() == '1' && $('#update_gamen').html() == '1') {
        return windowConfirm(msg);
    }
    return true;
}

/**
 * Count byte UTF8
 * 
 * @param chars
 * @returns
 */
function toBytesUTF8(chars) {
    return unescape(encodeURIComponent(chars));
}

/**
 * convert byte to String
 * @param bytes
 * @returns
 */
function fromBytesUTF8(bytes) {
    return decodeURIComponent(escape(bytes));
}

/**
 * Calculate janCode
 * 
 * @param janCode
 * @returns
 */
function calculateJanCode(janCode) {
    var isNumber = Number(janCode);
    
    if (isNaN(isNumber)) {
        return janCode;
    }
    
    var multiple = new Array( 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3 );
    var sum = 0;
    var result = "";
    
    if (janCode.length == multiple.length + 1) {
        janCode = janCode.substring(0, 12);
    } else if (janCode.length != multiple.length) {
        return janCode;
    }
        
    for (var i = 0; i < janCode.length; i++) {
        var c = janCode.substring(i, i + 1);
        var value = parseInt(c);

        value *= multiple[i];

        sum += value;
    }

    if (sum % 10 == 0) {
        sum = 0;
    } else {
        sum = 10 - sum % 10;
    }
    
    result = janCode + sum.toString();

    return result;
}

/**
 * HTML encode
 */
String.prototype.htmls = function() {
    var s = this.replace(/&/gi, '&amp;');
    s = s.replace(/\"/gi, '&quot;');
    s = s.replace(/\'/gi, '&#039;');
    s = s.replace(/</gi, '&lt;');
    return s.replace(/>/gi, '&gt;');
};

/**
 * HTML decode
 */
String.prototype.unhtmls = function() {
    var s = this.replace(/&amp;/gi, '&');
    s = s.replace(/&quot;/gi, '"');
    s = s.replace(/&#039;/gi, '\'');
    s = s.replace(/&lt;/gi, '<');
    return s.replace(/&gt;/gi, '>');
};

/**
 * convert nl to br (\n => <br ?>
 */
String.prototype.nl2br = function() {
    var s = this.replace(/\r\n/gi, "<br/>");
    return s.replace(/\n/gi, "<br/>");
};

/**
 * Delete space first and end of string
 */
String.prototype.trim = function() {
    var s = this.replace(/(^\s*)|(\s*$)/g, "");
    return s.replace(/(^　*)|(　*$)/g, "");
};

/**
 * Break line data
 */
String.prototype.breakLine = function() {
    var s = this.replace(/&lt;/gi, '<');
    s = s.replace(/&gt;/gi, '>');
    s = s.replace(/\\n/, "\n");
    return s.replace(/<br\s*[\/]?>/gi, "\n");
};

/**
 * Kanji to Kana
 */
String.prototype.toKana = function() {
    var s = this.trim();
    if (s != '') {
        var url = CONTEXT_PATH + '/Convert_kana.do';
        var winMain = getWindowMain();
        var params = {
            'type' : 'ajax',
            'value.kanji' : s,
            "value.info.winName": winMain.name
        };
        $.ajax({
            type : 'POST',
            url : url,
            data : params,
            success : function(data) {
                myAjaxCallBack.apply(this, [ data, function(obj) {
                    s = convertNullToEmpty(obj.kana);
                } ]);
            },
            dataType : 'text',
            async : false
        });
    }
    return s;
};

/**
 * Convert hiragana to katakana
 */
String.prototype.hiraToKana = function() {
    var s = this.replace(/[^ 　ぁあ-んァー]/g, '');
    if (s != '') {
        var c, a = [];
        for (var i = s.length - 1; 0 <= i; i--) {
            c = s.charCodeAt(i);
            a[i] = (0x3041 <= c && c <= 0x3096) ? c + 0x0060 : c;
        }
        s = String.fromCharCode.apply(null, a);
    }
    return s;
};

/**
 * Truncate data
 */
String.prototype.truncate = function(n) {
    var bytes= toBytesUTF8(this).substring(0, n);
    while (true) {
        try {
            return fromBytesUTF8(bytes);
        } catch(e) {};
        bytes= bytes.substring(0, bytes.length-1);
    }
};

/**
 * item contain Array
 * @param item
 * @returns {Boolean}
 */
Array.prototype.inArray = function(item) {
    if (typeof item != 'undefined') {
        for (var i = 0; i < this.length; i++) {
            if (this[i].trim() == item.trim()) {
                return true;
            }
        }
    }
    return false;
};

/**
 * Object function support valiadte plus
 */
var ValidatePlus = {
    /** start new row */
    startNewRow : null,
    /** end new row */
    totalNewRow : 0,
    /** list Pattern validate */
    listPattern : {},

    /**
     * add pattern validate plus
     */
    addPatternValidate : function(areaData, formBean, rowCount, items, requires) {
        if (typeof ValidatePlus.listPattern[areaData] == 'undefined') {
            ValidatePlus.listPattern[areaData] = {};
        }
        ValidatePlus.listPattern[areaData].formBean = formBean;
        ValidatePlus.listPattern[areaData].rowCount = rowCount;
        ValidatePlus.listPattern[areaData].items = items;
        ValidatePlus.listPattern[areaData].requires = requires;
        if (ValidatePlus.startNewRow == null) {
            ValidatePlus.startNewRow = rowCount;
        }
        ValidatePlus.totalNewRow++;
    },

    /**
     * remove pattern validate plus
     */
    removePatternValidate : function(areaData, formBean, items) {
        var key, keyChange;
        var endRow = ValidatePlus.startNewRow + ValidatePlus.totalNewRow;

        for (var i = 0, l = items.length; i < l; i++) {
            for (var cnt = ValidatePlus.startNewRow; cnt < endRow; cnt++) {
                key = (formBean != '') ? (formBean + '[' + cnt + '].' + items[i]) : (formBean + '.' + items[i]);
                keyChange = (formBean != '') ? (formBean + '[' + (cnt + 1) + '].' + items[i]) : (formBean + '.' + items[i]);
                if ($('[name="' + key + '"]').length <= 0) {
                    $('[name="' + keyChange + '"]').attr("name", key);
                }
            }
        }
        ValidatePlus.totalNewRow--;
    },

    /**
     * build hidden field with name=validatePlus[<area data>]
     */
    buildItemPattern : function() {

        try {
            var oPattern, oItem, key, cnt, endRow;
            oPattern = {};

            for ( var areaData in ValidatePlus.listPattern) {
                oPattern[areaData] = [];

                var formBean = ValidatePlus.listPattern[areaData].formBean;
                var items = ValidatePlus.listPattern[areaData].items;
                var requires = ValidatePlus.listPattern[areaData].requires;
                cnt = ValidatePlus.startNewRow;
                endRow = cnt + ValidatePlus.totalNewRow;
                for (; cnt < endRow; cnt++) {
                    for (var i = 0, l = items.length; i < l; i++) {
                        key = (formBean != '') ? (formBean + '[' + cnt + '].' + items[i]) : (formBean + '.' + items[i]);
                        oItem = {};
                        oItem[key] = (requires[i] != 0) ? true : false;
                        oPattern[areaData][oPattern[areaData].length] = oItem;
                    }
                }

                $('#BaseForm').append('<input id="validatePlus_' + areaData + '" type="hidden" name="validatePlus[' + areaData + ']" value="" />');
                $('#validatePlus_' + areaData).val(JSON.stringify(oPattern[areaData]));
            }
        } catch (e) {
            /* TODO HT側だけ原因不明のエラーが発生する。後日調査後修正。一旦エラーを無視する。 */
        }
    }
};

/**
 * export data from table to excel
 */
 

/**
 * 
 * キー押下抑止
 * 
 */
$(document).on('keydown', function(event, o) {

    var KEY_BS = 8;
    var KEY_ENTER = 13;
    var KEY_ARROW_LEFT = 37;
    var KEY_ARROW_RIGHT = 39;
    var KEY_F1 = 112;
    var KEY_F3 = 114;
    var KEY_F7 = 118;
    var KEY_F11 = 122;
    var KEY_F12 = 123;
    var KEY_ZENHAN = 229;
    
    /*キー押下時にタグにフォーカスが当たっている場合*/
    switch (event.target.tagName) {
        /*INPUTタグの場合*/
        case "INPUT" : {
            if (event.target.type == "text" ||
                event.target.type == "password" ||
                event.target.type == "file") {
                
                if (event.target.readOnly == true){
                } else if (event.keyCode == KEY_BS) {
                    return true;
                }
            }
            else if (event.target.type == "button" ||
                    event.target.type == "reset") { 
                
                if (event.keyCode == KEY_ENTER) {
                    return true;
                }
            }
            break;
        }
        case "TEXTAREA" : {
            if (event.target.readOnly == true){
            } else if (event.keyCode == KEY_BS ||
                event.keyCode == KEY_ENTER) {
                return true;
            }
            break;
        }
        case "A" : {
            if (event.keyCode == KEY_ENTER) {
                return true;
            }
            break;
        }
        case "SELECT" : {
            if (event.keyCode == KEY_ZENHAN) {
                return false;
            }
        }
    }
    
    /* Disabled F1 in Internet Explorer*/
    if ('onhelp' in window) {
        document.onhelp = function() {
            return false;
        };
        window.onhelp = function () { 
            return false;
        };
    }
    
    /*タグ内、タグ外にかかわらず抑止対象*/
    if (event.keyCode == KEY_BS || 
        event.keyCode == KEY_F1 ||
        event.keyCode == KEY_F3 ||
        event.keyCode == KEY_F7 ||
        event.keyCode == KEY_F11 ||
        event.keyCode == KEY_F12) {
        try {
            event.keyCode = null;
        }
        catch (e) {
            /*fileタグ上でのボタン押下抑止時、セキュリティエラーが発生するため*/
        }
        return false;
    }
    
    if ((event.keyCode == KEY_ARROW_LEFT && event.altKey) || (event.keyCode == KEY_ARROW_RIGHT && event.altKey)) {
        /*Alt+矢印はevent.keyCodeに値を設定すると有効になってしまう為、別で判定*/
        return false;
    }
    
    return true;
});
