
$(function (){
    $('#billingLi').on('click', function (){
        $(this).addClass('on');
        $('#shippingLi').removeClass('on');
        $('#billing').css("display", 'block');
        $('#shipping').css("display", 'none');
    });
    $('#shippingLi').on('click', function (){
        $(this).addClass('on');
        $('#billingLi').removeClass('on');
        $('#billing').css("display", 'none');
        $('#shipping').css("display", 'block');
    });
});