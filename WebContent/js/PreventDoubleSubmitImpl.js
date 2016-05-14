//***********************************************************************
//* OKI標準Web-APフレームワーク共通部品　javascript 二重押下防止機能
//* VERSION  : 1.01
//* 更新日   : 2013/01/21
//* 謝辞     : このスクリプトは、TERASOLUNA Framework for .NETの二重押下
//*            防止機能のJavaScriptコードを参考にして開発した。その著作
//*            権表示を以下に示す。
//***********************************************************************
//*****************************************************
//  Copyright (c) 2008, NTT DATA Corporation.
//  
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
//  <Summary>
//     本モジュールは、ページのロード時に呼び出され
//     任意のSubmitボタンが押されている間、
//     全ての'submit'ボタンを無効化する機能を提供する為のスクリプトです。
//  </Summary>
//*****************************************************

var PreventDoubleSubmit = (function () {
    var strEventElement =  '';
    function addEvent(elem, ev, func) {
        if (elem.addEventListener) {
	        elem.addEventListener(ev, func, false);
        } else if (elem.attachEvent) {
	        elem.attachEvent("on" + ev, func);
        }
    }
    
    function removeEvent(elem, ev, func) {
        if (elem.removeEventListener)  {
            elem.removeEventListener(ev, func, false);
        } else if (elem.attachEvent) {
            elem.detachEvent("on" + ev, func);
        }
    }

    function storeEventSource(e) {
        strEventElement = '';
        var ev = (window.event ? window.event : e);
        if (ev) {
            var el = (ev.srcElement ? ev.srcElement : ev.target);
            if ((el.type == 'submit') || (el.type == 'button')) {
                strEventElement = (el.name ? el.name : el.id);
            }
        }
    }
    
    function disableButtons(elements) {
        var elem;
        for (var i = 0; i < elements.length; i++) {
            elem = elements[i];
            if ((elem.type == 'submit') ||
                (elem.type == 'button')) {
                elem.disabled = true;
            }
        }
    }

    function enableButtons(elements) {
        var elem;
        for (var i = 0; i < elements.length; i++) {
            elem = elements[i];
            if ((elem.type == 'submit') ||
                (elem.type == 'button')) {
                elem.disabled = false;
            }
        }
    }

    function ignoreLinkClick(e) { 
        var ev = (window.event ? window.event : e);
        if (ev) {
            ev.cancelBubble = true; 
            if (ev.preventDefault) {
                ev.preventDefault();
            }
        } 
        return false; 
    }

    function disableLinks(links) {
        var elem;
        if (! links) {
            return;
        }
        for (var i = 0; i < links.length; i++) {
            elem = links[i];
            if ((elem.tagName == 'a' || elem.tagName == 'A') && elem.href) {
                addEvent(elem, "click", ignoreLinkClick);
            }
        }
    }

    function enableLinks(links) {
        var elem;
        if (! links) {
            return;
        }
        for (var i = 0; i < links.length; i++) {
            elem = links[i];
            if ((elem.tagName == 'a' || elem.tagName == 'A') && elem.href) {
                removeEvent(elem, "click", ignoreLinkClick);
            }
        }
    }

    function aspNetValidationFailed() {
        if (typeof(Page_ValidationActive) != 'undefined' && Page_ValidationActive) {
            if (typeof(Page_BlockSubmit) != 'undefined' && Page_BlockSubmit) {
                return true; 
            }
        }
        return false;
    }
    
    function disableControls() {
        if (aspNetValidationFailed()) {
            return;
        }
        if (strEventElement && strEventElement.length > 0) {
            var objElment = document.getElementById('__EVENTTARGET');
            if (objElment) { 
                objElment.value = strEventElement; 
            }
        }
        for (var i = 0; i < document.forms.length; i++) {
            disableButtons(document.forms[i].elements);
        }
    }

    function enableControls() {
        for (var i = 0; i < document.forms.length; i++) {
            enableButtons(document.forms[i].elements);
        }
    }

    function registerHiddenField(fm, id, value) {
        var el = document.getElementById(id);
        if (el) {
            return;
        }
        el = document.createElement('input');
        el.id = id;
        el.type = 'hidden';
        el.name = id;
        el.value = value;
        fm.appendChild(el);
    }

    function aspNetOnWindowLoad() {
        var fm = document.forms[0];
        addEvent(fm, "click", storeEventSource);
        registerHiddenField(fm, '__EVENTTARGET', '');
    }

    function registerOnSubmitForAspNet() {
        var fm = document.forms[0];
        var orig_func = fm.onsubmit;
        fm.onsubmit = function (e) { 
            if ((typeof(orig_func) === 'function') && (orig_func(e) === false)) { 
                return false;
            }
            disableControls();
            return true;
        };
        
        fm = null;

    }

    return {
        "initForAspNet": function () {
            addEvent(window, "load",   aspNetOnWindowLoad);
            addEvent(window, "unload", enableControls);
        },
        "disableOnSubmitForAspNet":    function () {
            addEvent(window, "load",   registerOnSubmitForAspNet);
        },
        "disableControls":    disableControls,
        "enableControls":     enableControls
    };
})();
