/**
 * Defined function add to jQuery
 */
jQuery.fn.extend({

    /**
     * set element readonly
     */
    readonly : function(flag) {
        var ele = $(this[0]);
        flag = (!ele.hasClass('readonly') || flag) ? flag : !flag;
        jQuery.access(this, jQuery.prop, 'readonly', flag, true);
        if (flag) {
            ele.addClass('color_readonly');
        } else {
            ele.removeClass('color_readonly');
        }
    },

    /**
     * set element disabled (change to readonly) exclusion button flag: true is
     * disabled, false enabled force: true is ignore flag parameter and allway
     * disabled
     */
    disabled : function(flag, force) {
        var ele = $(this[0]);
        if (ele.attr('name') == 'value.info.winName') {
            return;
        }
        if (force) { /*force disabled*/
            if (flag) {
                ele.addClass('color_disabled');
            } else {
                ele.removeClass('color_disabled');
            }
            jQuery.access(this, jQuery.prop, 'disabled', flag, true);
        } else {
            
            flag1 = ((!ele.hasClass('disabled') && !ele.hasClass('color_readonly')) || flag) ? flag : !flag;
            
            if (ele.attr('type') == 'button') { /*button to disabled*/
                
                jQuery.access(this, jQuery.prop, 'disabled', flag1, true);
                
            } else if (ele.attr('type') == 'radio') { /*radio to display none*/
                if (flag1) {
                    if (!ele.hasClass('color_disabled')) {
                        var cls = ele.is(':checked') ? 'radioFakeChecked' : 'radioFake';
                        var val = '';
                        if (ele.next().length > 0) {
                            val = ele.next().text();
                            ele.next().addClass('display_none');
                        }
                        ele.before('<span class="' + cls + ' ' + convertNullToEmpty(ele.attr('class')) + '" style="'
                                + convertNullToEmpty(ele.attr('style')) + '"' + (ele.attr('tabindex') > 0?' tabindex="'+ ele.attr('tabindex') +'"':'') + '>' + val + '</span>');
                        ele.addClass('display_none');
                    }
                } else if (ele.hasClass('color_disabled')) {
                    ele.prev().remove();
                    ele.removeClass('display_none');
                    if (ele.next().length > 0) {
                        ele.next().removeClass('display_none');
                    }
                }
            } else if (ele.attr('type') == 'checkbox') { /*checkbox to display none*/
                if (flag1) {
                    if (!ele.hasClass('color_disabled')) {
                        var cls = ele.is(':checked') ? 'checkboxFakeChecked' : 'checkboxFake';
                        var val = '';
                        if (ele.next().length > 0 && ele.next().next().length > 0) {
                            val = ele.next().next().text();
                            if (val != '') {
                                ele.next().next().addClass('display_none');
                            }
                        }
                        ele.before('<div class="color_disabled fakeCheckInDiv"' + (ele.attr('tabindex') > 0?' tabindex="'+ ele.attr('tabindex') +'"':'') + '><span class="' + cls + ' ' + convertNullToEmpty(ele.attr('class')) + '" style="'
                                + convertNullToEmpty(ele.attr('style')) + '">' + val + '</span></div>');
                        ele.addClass('display_none');
                    }
                } else if (ele.hasClass('color_disabled')) {
                    ele.prev().remove();
                    ele.removeClass('display_none');
                    if (ele.next().length > 0 && ele.next().next().length > 0) {
                        ele.next().next().removeClass('display_none');
                    }
                }
            } else if (ele.getType() == 'select') { /*selectbox to display none*/
                if (flag1) {
                    if (!ele.hasClass('color_disabled')) {
                        var val = $('option:selected', ele).text();
                        var stw = (ele.width() > 5) ? ele.width() + 'px;' : '';
                        ele.before('<div class="selectFake ' + convertNullToEmpty(ele.attr('class')) + '" style="height:100%;width:' + stw
                                + convertNullToEmpty(ele.attr('style')) + '"' + (ele.attr('tabindex') > 0?' tabindex="'+ ele.attr('tabindex') +'"':'') + '><div class="fakeSelectInDiv"> ' + (val != '' ? val : '　') + '</div></div>');
                        ele.addClass('display_none');
                        ele.on('change', $._selectChange);
                    }
                } else if (ele.hasClass('color_disabled')) {
                    ele.off('change', $._selectChange);
                    ele.prev().remove();
                    ele.removeClass('display_none');
                }
            } else { /*other element selectbox to readOnly*/
                jQuery.access(this, jQuery.prop, 'readonly', flag1, true);
            }
            
            flag2 = (!ele.hasClass('disabled') || flag) ? flag : !flag;
            if (flag2) {
                ele.addClass('color_disabled');
            } else {
                ele.removeClass('color_disabled');
            }
        }
    },

    /**
     * overwite attr jquery method to implement with attribute disabled
     */
    attr : function(name, value) {
        if (arguments.length === 2 && String(name).toLowerCase() == 'disabled') {
            var val = String(value).toLowerCase() == 'disabled' || String(value).toLowerCase() == 'true' || String(value) == '1';
            return this.disabled(val);
        } else if (arguments.length === 2 && String(name).toLowerCase() == 'readonly') {
            var val = String(value).toLowerCase() == 'readonly' || String(value).toLowerCase() == 'true' || String(value) == '1';
            return this.readonly(val);
        } else {
            return jQuery.access(this, jQuery.attr, name, value, arguments.length > 1);
        }
    },

    /**
     * overwite removeAttr jquery method to implement with attribute disabled
     */
    removeAttr : function(name) {
        if (String(name).toLowerCase() == 'disabled') {
            return this.disabled(false);
        } else if (String(name).toLowerCase() == 'readonly') {
            return this.readonly(false);
        } else {
            return this.each(function() {
                jQuery.removeAttr(this, name);
            });
        }
    },

    /**
     * overwite prop jquery method to implement with attribute disabled
     */
    prop : function(name, value) {
        if (arguments.length === 2 && String(name).toLowerCase() == 'disabled') {
            var val = String(value).toLowerCase() == 'disabled' || String(value).toLowerCase() == 'true' || String(value) == '1';
            this.disabled(val);
        } else if (arguments.length === 2 && String(name).toLowerCase() == 'readonly') {
            var val = String(value).toLowerCase() == 'readonly' || String(value).toLowerCase() == 'true' || String(value) == '1';
            this.readonly(val);
        } else {
            return jQuery.access(this, jQuery.prop, name, value, arguments.length > 1);
        }
    },

    /**
     * overwite removeProp jquery method to implement with attribute disabled
     */
    removeProp : function(name) {
        if (String(name).toLowerCase() == 'disabled') {
            this.disabled(false);
        } else if (String(name).toLowerCase() == 'readonly') {
            this.readonly(false);
        } else {
            name = jQuery.propFix[name] || name;
            return this.each(function() {
                /*
                 * try/catch handles cases where IE balks (such as removing a
                 * property on window)
                 */
                try {
                    this[name] = undefined;
                    delete this[name];
                } catch (e) {
                }
            });
        }
    },

    /**
     * element: Will return radio, text, checkbox, select, textarea, etc (also
     * DIV, SPAN, all element types) list: Gets the first element's type
     */
    getType : function() {
        if (typeof this[0] != 'undefined') {
            return this[0].tagName == "INPUT" ? this[0].type.toLowerCase() : this[0].tagName.toLowerCase();
        } else {
            return '';
        }
    },

    
    /**
     * Create select box fake
     * 
     * @param data
     * @param iconId
     * @param blankFirst
     *            true or false
     */
    selectFake : function(data, iconId, blankFirst) {
        
        /*create event keydown with keyCode=40 [row down]*/
        var myE = $.Event("keydown", {keyCode: 40});

        var showFlag = false;
        var btnClick = false;
        var myEle = $(this[0]);
        var myEvent = null;
        myEle.attr('autocomplete', 'off');
        myEle.removeAttr('onfocus');
        
        /*fire event key down*/
        myEle.on('keydown', function(event) {
            if (event.keyCode == 27) {
                showFlag = false;
            } else {
                myEvent = event;
            }
        });
        
        /*init auto complete*/
        var autoCom = myEle.autocomplete({
            suggest : {},
            minLength : 0,
            source : function(req, add) {
                add(blankFirst ? $.merge([ '' ], data) : data);
            },
            search : function(event, ui) {
                var aCleanData = blankFirst ? $.merge([ '' ], data) : data;
                if (myEvent == null) {
                    /* change search array*/
                    myEle.autocomplete('option', 'source', aCleanData);
                } else { /*filter on keydown*/
                    /* get current input value*/
                    var sValue = $(event.target).val();
                    /* init new search array*/
                    var aSearch = [];
                    if (sValue != '') {
                        /* for each element in the main array ...*/
                        $(aCleanData).each(function(iIndex, sElement) {
                            /* ... if element starts with input value ...*/
                            if (sElement.substr(0, sValue.length) == sValue) {
                                /* ... add element*/
                                aSearch.push(sElement);
                            }
                        });
                    }
                    /* change search array*/
                    myEle.autocomplete('option', 'source', aSearch);
                    if (aSearch.length == 0) {
                        showFlag = false;
                    }
                }
            },
            open : function(event, ui) {
                $('.ui-menu').each(function() {
                    if ($(this).css('display') == 'block') {
                        $(this).width($(this).width() + 18);
                        var index = 0;

                        $('.ui-menu-item', $(this)).each(function(k, o) {
                            index = k;
                            if ($(this).text() == myEle.val()) {
                                $(this).css({
                                    'border': '1px solid #999999'
                                });
                                $('a', this).css({
                                    'background' : '#3399FF',
                                    'color' : '#ffffff'
                                });
                                return false;
                            } else {
                                index = -1;
                            }
                        });
                        for (var i = 0; i <= index; i++) {
                            $(this).trigger(myE);
                        }
                        showFlag = true;
                    }
                });
                return false;
            },
            focus : function(event, ui) {
                return false;
            },
            select : function() {
                showFlag = false;
                myEle.focus();
            }
        }).data("ui-autocomplete");
        
        /*fix data before render*/
        autoCom._renderItem = function(ul, item) {
            return $("<li></li>")
                    .data("item.autocomplete", item)
                    .append("<a>" + (item.label == '' ? '<br />' : item.label) + "</a>")
                    .appendTo(ul);
        };
        
        /*fire event icon click*/
        $(iconId).on('click', function(event) {
            myEvent = null;
            if (myEle.is(':disabled') || myEle.is('[readonly]')) {
                return;
            }
            btnClick = true;
            setTimeout(function() {
                btnClick = false;
            }, 300);
            if (!showFlag) {
                showFlag = true;
                myEle.focus();
                myEle.autocomplete('search', '');
                ;
            } else {
                showFlag = false;
                myEle.autocomplete('close');
            }
        });
        /*fire event document click*/
        $(document).on('click', function() {
            if (!btnClick) {
                showFlag = false;
                myEle.autocomplete('close');
            }
        });
        $(document).on('keydown', function(event) {
            if (event.keyCode == 27) {
                showFlag = false;
                myEle.autocomplete('close');
            }
        });
        var menu = myEle.autocomplete("widget");
        var res = null;
        var count = 0;
        res = setInterval(function() {
            if (menu.html() != '') {
                showFlag = false;
                myEle.autocomplete('close');
                clearInterval(res);
            }
            if (count > 20) {
                clearInterval(res);
            }
            count++;
        }, 100);
        
        return myEle;
    }
});

jQuery._selectChange = function() {
    if (typeof $(this).prev().children == 'function') {
        $(this).prev().children().text($('option:selected', $(this)).text());
    }
};

/**
 * Define a $.loadScript() method that allows fetching a cached script
 */
jQuery.loadScript = function(url, options) {
    /* Allow user to set any option except for dataType, cache, and url */
    options = $.extend({
        method : 'GET',
        dataType : "script",
        cache : true,
        url : url
    }, options || {});
    /* Use $.ajax() since it is more flexible than $.getScript */
    /* Return the jqXHR object so we can chain callbacks */
    return jQuery.ajax(options);
};

/**
 * orverwrite method [$.ui.slider.prototype.blur]
 */
var uiMenuBlur = $.ui.slider.prototype.blur;
$.widget("ui.menu", $.extend({}, $.ui.menu.prototype, {
    blur : function( event, fromFocus ) {
        if ( !fromFocus ) {
            clearTimeout( this.timer );
        }

        if ( !this.active ) {
            return;
        }

        this.active.children( "a" ).removeClass( "ui-state-focus" );
        if (event == undefined && fromFocus == undefined) {
            this.active = null;
        }

        this._trigger( "blur", event, { item: this.active } );
    }
}));