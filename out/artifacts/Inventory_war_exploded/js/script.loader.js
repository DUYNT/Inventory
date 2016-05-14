/**
 * JS script loader
 */
var JSLOADER = {
    IS_JS_LOADED : {},
    IS_TAB_INIT : {},
    PARENT_ELE : {},

    /* load JS for tab */
    loadJSforTAB : function(sec, script) {
        this.loadJS(script, 'tab', sec);
    },

    /* load JS for sec */
    loadJSforSEC : function(script) {
        this.loadJS(script, 'sec');
    },

    /* load JS for sec */
    loadJS : function(script, folder, sec) {
        for (var i = 0; i < script.length; i++) {
            this.loadJSByName(script[i], folder, sec);
        }
    },

    /* load JS file */
    loadJSByName : function(jsName, folder, sec, cache) {
        if (typeof JSLOADER.IS_JS_LOADED[folder + jsName] == 'undefined' || !JSLOADER.IS_JS_LOADED[folder + jsName]) {
            JSLOADER.IS_JS_LOADED[folder + jsName] = true;
            JSLOADER.PARENT_ELE[jsName] = (sec == null || sec == '') ? 'BaseForm' : sec;
            folder = (folder == null || folder == '') ? '' : '/' + folder;
            var url = CONTEXT_PATH + '/js' + folder + '/' + jsName + '.js';
            /*$.loadScript(url, {cache : false});*/
            $.loadScript(url, {cache : (typeof cache === 'undefined' || cache == null ? true : cache)});
            
            /*var script = $('<script type="text/javascript" src="' + url + '" charset="UTF-8" async="true" />').appendTo('head');
            setTimeout(function(){script.remove();}, 5000);*/
        }
    },

    /* get section ID */
    getSecId : function(sec) {
        return JSLOADER.PARENT_ELE[sec];
    },

    /**
     * @param callback
     *            is function
     * @param args
     *      Array argument
     * @param aryObj
     *      Array object depend
     */
    setCallback : function(callback, args, aryObj) {
    	var inter = 0;
        var objValid = [];
        var res = null;
        res = setInterval(function() {
            if (aryObj != null) {
                var j = 0;
                for (var i = 0; i < aryObj.length; i++) {
                    var obj = null;
                    try {
                        eval('obj = ' + aryObj[i] + ';');
                    } catch (e) {
                        
                    }
                    if (obj != null && typeof obj == 'object') {
                        objValid[j++] = true;
                    }
                }
                if (objValid.length == aryObj.length) {
                    if (args == null || typeof args != 'object') {
                        args = [];
                    }
                    callback.apply(this, args);
                    clearInterval(res);
                }
                if (inter >= 1800) {
                    clearInterval(res);
                }
                inter++;
            }
        }, 50);
    },
    
    /**
     * init TAB
     */
    initTab : function(ids) {
        var inter = 0;
        var res = null;
        res = setInterval(function() {
            $.each(ids, function(k, id) {
                if ($(id).length > 0 && (typeof JSLOADER.IS_TAB_INIT[id] == 'undefined' || !JSLOADER.IS_TAB_INIT[id])) {
                    $(document).ready(function() {
                        $(id).tabs();
                    });
                    JSLOADER.IS_TAB_INIT[id] = true;
                    ids.splice(k, 1);
                    if (ids.length == 0) {
                        clearInterval(res);
                    }
                }
            });
            if (inter >= 1800) {
                clearInterval(res);
            }
            inter++;
        }, 50);
    }
};