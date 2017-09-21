$(document).ready( function() {
        var pos = ($(window).width() < 768) ? 'right' : 'top';
        $('[data-toggle="tooltip"]').tooltip({'placement': pos,title:'Tooltip on '+pos});
    });

$('.collapse').on('show.bs.collapse', function(){
    $(this).parent().find(".glyphicon-plus").removeClass("glyphicon-plus").addClass("glyphicon-minus");
    }).on('hide.bs.collapse', function(){
    $(this).parent().find(".glyphicon-minus").removeClass("glyphicon-minus").addClass("glyphicon-plus");
});