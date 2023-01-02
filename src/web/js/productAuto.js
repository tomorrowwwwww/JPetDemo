$(function (){
    $('#keyword').on('keyup',function (){
        var keyword=$(this).val();
        //console.log(keyword);
        if (keyword!==''&&keyword!==null&&keyword.length!==0){
            $.ajax({
                type:'Get',
                url:'http://localhost:8080/Jpet/searchproduct?keyword='+keyword,
                success:function (data) {
                    console.log(data);
                    var productListHTML = '';
                    for (var i = 0; i < data.length; i++) {
                        productListHTML += '<li class=\"productAutoItem\" data-productId="';
                        productListHTML += data[i].productId;
                        productListHTML += '">';
                        productListHTML += data[i].name;
                        productListHTML += '</li>';
                    }
                    $('#productAutoList').html(productListHTML);
                    $('#searchlist').show();
                },
                error:function (errorMsg) {
                    console.log(errorMsg);

                }

            });
        }
        else{
            $('#searchlist').hide();
        }
    });
    //无效代码
    // $('.productAutoItem').on('click',function () {
    //    console.log('aaaaaaaaaa');
    // })事件冒泡原理

    $(document).on('click','.productAutoItem',function () {
        var productId=$(this).data('productid');
        console.log(productId);
        $('#searchlist').hide();
        $('#keyword').val('');
        window.location.href='http://localhost:8080/Jpet/productForm?productId='+productId;
    })
   // mouseleave,mouseout区别
    $('#searchlist').on('mouseleave',function () {
        $(this).hide();
        $('#keyword').val('');
    })
});