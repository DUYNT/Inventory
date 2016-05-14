/**
 * JS for index
 */

/**
 * Open window main
 * 
 * @param url
 * @returns {Boolean}
 */
function openMainWin(url) {
    var win = {};
    var winName = WINDOW_MAIN + '_' + (new Date()).getTime();
    
    if (!IS_TABLET) {
        url = (url != '') ? (url + '?' + PARAM_WINDOW_NAME + '=' + winName) : '';
        win = window.open(url, winName, 'titlebar=0,toolbar=0,status=0,menubar=0,scrollbars=0,resizable=0,directories=0,location=0,width=' + W_WIDTH + ',height=' + W_HEIGHT + ',left='+ W_LEFT +',top='+ W_TOP +'');
        win.name = winName;
        /*window.opener = win;*/
        /*window.open('', '_top');*/
        win.focus();
        /*if (window.name.indexOf(WINDOW_MAIN) == -1) {
            window.close();
        }*/
    } else {
        window.name = winName;
        win = window;
    }
    return win;
}
