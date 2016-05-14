/**
 * JS load in final
 */
$(document).ready(function() {
    var errorId = (typeof ERROR_ID == 'undefined') ? '' : ERROR_ID;
    var errorMsg = (typeof ERROR_MSG == 'undefined') ? '' : ERROR_MSG;
    var infoMsg = (typeof INFO_MSG == 'undefined') ? '' : INFO_MSG;

    setTimeout(function() {
        /* focus element */
        var ele = elementFocus(errorId, true);
        
        /*Check and show message */
        showMessage(errorMsg, infoMsg);
        focusTab(ele);
        focusPage(ele);
        try {
            ele.focus();
        } catch(e) {}
    }, 300);

    /*check init Datepicker*/
    if ($('#commonDatepicker').length > 0) {
        
        /* get Input date */
        var getInputDate = function(_date, val, opt) {
            var strDate = _date.getFullYear() + '/' + (_date.getMonth() + 1) + (opt == 'month' ? '' : ('/' + _date.getDate()));
            if (val != '') {
                try {
                    val = val.replace(/\//gi, '').trim();
                    var y = (val.length >= 4) ? val.substring(0, 4) : '';
                    y = (isNaN(y) || y == '') ? (_date.getFullYear()) : y;
                    var m = (val.length >= 6) ? val.substring(4, 6) : '';
                    m = (isNaN(m) || m == '') ? (_date.getMonth() + 1) : m;
                    m = (m > 12) ? 12 : m;
                    m = (String(m).length < 2) ? '0' + m : m;
                    var d = (val.length >= 8) ? val.substring(6, 8) : '';
                    d = (isNaN(d) || d == '') ? (_date.getDate()) : d;
                    d = (String(d).length < 2) ? '0' + d : d;
                    strDate = y + '/' + m + (opt == 'month' ? '' : ('/' + d));
                } catch (e) {
                    strDate = _date.getFullYear() + '/' + (_date.getMonth() + 1) + (opt == 'month' ? '' : ('/' + _date.getDate()));
                }
            }
            return strDate;
        };
        var _date = new Date();
        var strDate = getInputDate(_date);
        $('#commonDatepicker').DatePicker({
            format : 'Y/m/d',
            date : strDate,
            current : strDate,
            starts : 1,
            position : 'right'
        });
        var strDate = getInputDate(_date, '', 'month');
        $('#commonMonthpicker').DatePicker({
            view : 'months',
            format : 'Y/m',
            date : strDate,
            current : strDate,
            starts : 1,
            position : 'right'
        });
    
        $(document).on('keydown', function(event, o) {
            if (event.keyCode == 9) {
                $('#commonDatepicker').DatePickerHide();
                $('#commonMonthpicker').DatePickerHide();
            }
        });
    
        /* Setup datePicker */
        var initDatePicker = function() {
            $('input.datepicker').each(function(k, o) {
                var input = null;
                if ($(o).prop("tagName") == 'INPUT' && $(o).attr("type").toLowerCase() == 'text') {
                    input = $(o);
                } else if ($(o).prev().prop("tagName") == 'INPUT' && $(o).prev().attr("type").toLowerCase() == 'text') {
                    input = $(o).parent().prev();
                } else {
                    input = $('input[type=text]', $(o).parent().prev());
                }
                var strDate = getInputDate(_date, input.val());
                $(o).click(function() {
                    $('.datepickerContainer table table').attr('class', 'datepickerViewDays');
                    $('#commonDatepicker').DatePickerShow({
                        item : $(o),
                        date : strDate,
                        current : strDate,
                        onBeforeShow : function() {
                            $('#commonDatepicker').DatePickerSetDate(getInputDate(_date, input.val()), true);
                        },
                        onChange : function(formated, dates) {
                            input.val(formated).trigger('change');
                            $('#commonDatepicker').DatePickerHide();
                        }
                    });
                });
            });
        };
        /* Setup monthPicker */
        var initMonthPicker = function() {
            $('input.monthpicker').each(function(k, o) {
                var input = null;
                if ($(o).prop("tagName") == 'INPUT' && $(o).attr("type").toLowerCase() == 'text') {
                    input = $(o);
                } else if ($(o).prev().prop("tagName") == 'INPUT' && $(o).prev().attr("type").toLowerCase() == 'text') {
                    input = $(o).parent().prev();
                } else {
                    input = $('input[type=text]', $(o).parent().prev());
                }
                var strDate = getInputDate(_date, input.val(), 'month');
                $(o).click(function() {
                    $('.datepickerContainer table table').attr('class', 'datepickerViewMonths');
                    $('#commonMonthpicker').DatePickerShow({
                        item : $(o),
                        date : strDate,
                        current : strDate,
                        onBeforeShow : function() {
                            $('#commonMonthpicker').DatePickerSetDate(getInputDate(_date, input.val(), 'month'), true);
                        },
                        onChange : function(formated, dates) {
                            input.val(formated).trigger('change');
                            $('#commonMonthpicker').DatePickerHide();
                        }
                    });
                });
            });
        };
      
        /*Init datePicker, monthPicker for element*/
        initDatePicker.call(this);
        initMonthPicker.call(this);
        $('.datepickerContainer').each(function() {
            $(this).parent().closest('div').draggable({ containment: "body" });
        });
    }
});