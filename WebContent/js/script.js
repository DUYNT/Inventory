
if (typeof $.fn.sweetPages == 'undefined') {
    $(document).ready(function() {
        /* The following code is executed once the DOM is loaded */
    
        /* Calling the jQuery plugin and splitting the*/
        /* #holder UL into pages of 3 LIs each:*/
        $('#holder').sweetPages({
            perPage : 1
        });
    
        /* The default behaviour of the plugin is to insert the */
        /* page links in the ul, but we need them in the main container:*/
    
        var controls = $('.swControls').detach();
        controls.appendTo('#main');
    
    });
};

jQuery.fn.extend({

    /* Creating the sweetPages jQuery plugin:*/
    sweetPages : function(opts) {
        
        $(ul).closest('div#main').parent().closest('div').css('display', 'block');

        /* If no options were passed, create an empty opts object*/
        if (!opts)
            opts = {};

        var resultsPerPage = opts.perPage || 3;

        /* The plugin works best for unordered lists, althugh ols would do just*/
        /* as well:*/
        var ul = this;
        var li = ul.find('li');
        var pageWidth = parseInt($(ul).closest('div#main').css('width'));
        pageWidth = isNaN(pageWidth) ? $(ul).closest('div#main').width() : pageWidth;

        li.each(function() {
            /* Calculating the height of each li element, and storing it with*/
            /* the data method:*/
            var el = $(this);
            el.data('height', el.outerHeight(true));
        });

        /* Calculating the total number of pages:*/
        var pagesNumber = Math.ceil(li.length / resultsPerPage);

        /* If the pages are less than two, do nothing:*/
        if (pagesNumber < 2)
            return this;

        /* Creating the controls div:*/
        var swControls = $('<div class="swControls">');

        for (var i = 0; i < pagesNumber; i++) {
            /* Slice a portion of the lis, and wrap it in a swPage div:*/
            li.slice(i * resultsPerPage, (i + 1) * resultsPerPage).wrapAll('<div class="swPage" page="' + (i + 1) + '" />');

            /* Adding a link to the swControls div:*/
            swControls.append('<a href="" class="swPage' + (i + 1) + ' swShowPage">' + (i + 1) + '</a>');
        }

        ul.append(swControls);

        var maxHeight = 0;
        var totalWidth = 0;

        var swPage = ul.find('.swPage');
        swPage.each(function() {

            /* Looping through all the newly created pages:*/
            var elem = $(this);

            elem.css('float', 'left').width(pageWidth);

            var tmpHeight = 0;
            elem.find('li').each(function() {
                tmpHeight += $(this).data('height');
            });

            if (tmpHeight > maxHeight)
                maxHeight = tmpHeight;

            totalWidth += elem.outerWidth();
        });

        swPage.wrapAll('<div class="swSlider" />');

        /* Setting the height of the ul to the height of the tallest page:*/
        ul.height(maxHeight);

        var swSlider = ul.find('.swSlider');
        swSlider.append('<div class="clear" />').width(totalWidth);

        var hyperLinks = ul.find('a.swShowPage');

        hyperLinks.click(function(e) {

            /* If one of the control links is clicked, slide the swSlider div*/
            /* (which contains all the pages) and mark it as active:*/

            $(this).addClass('active').siblings().removeClass('active');

            swSlider.stop().animate({
                'margin-left' : -(parseInt($(this).text()) - 1) * pageWidth
            }, 'slow');
            e.preventDefault();
        });

        /* Mark the first link as active the first time this code runs:*/
        hyperLinks.eq(0).addClass('active');

        /* Center the control div:*/
        swControls.css({
            'left' : '50%',
            'margin-left' : -swControls.width() / 2
        });
        
        $(ul).closest('div#main').parent().closest('div').css('display', 'none');

        return this;

    }
});
