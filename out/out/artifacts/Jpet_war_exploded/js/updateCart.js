$(function (){
    $('.quantity').on('blur', function (){
        var url = "updateCart";
        $.ajax({
            type: "GET",
            url: url,
            timeout: 2000,
            data: $('#cartForm').serialize(),
            dataType:'json',
            success: function (obj){
                console.log(obj.toString());
                var subtotalPrice=0;
                $('.quantity').each(function(i,el){
                    $(el).text('$'+obj[i].quantity);
                });
                $('.totalPrice').each(function(i,el){
                    $(this).text('$'+obj[i].totalPrice);
                    subtotalPrice += parseFloat(obj[i].totalPrice);
                });
                $('#subtotal').text('$'+subtotalPrice);
            }
        });
    });
});

// $(function (){
//     $("button").on('click',function (){
//         var dec = $(this);
//         var flag = dec.attr("id");
//         console.log(flag);
//         if(flag === "sub")
//             sub(dec,flag);
//         if(flag === "add")
//             add(dec,flag);
//     });
// });
// function sub(dec,flag){
//     var quantity = dec.parent("span").next("span").find("input").eq(0);
//     var total = quantity.parent("span").parent("div").parent("td").next("td").next("td");
//     var subtotal = $("#subtotal");
//     var id = total.parent("tr").find("td").eq(0).text();
//     $.ajax({
//         type:"GET",
//         url:"updateQuantity?quantity="+quantity.val()+"&itemId="+id+"&flag="+flag,
//         dataType:"text",
//         success:function (data){
//             let result1 = data.split("/");
//             if(result1[0] === "d")
//             {
//                 total.parent("tr").remove();
//                 subtotal.text("$"+result1[1]);
//             }
//             else {
//                 quantity.val(result1[0]);
//                 total.text("$" + result1[1]);
//                 subtotal.text("$" + result1[2]);
//             }
//         }
//     });
// }
// function add(dec,flag){
//     let quantity = dec.parent("span").prev("span").find("input").eq(0);
//     let total = quantity.parent("span").parent("div").parent("td").next("td").next("td");
//     let subtotal = $("#subtotal");
//     let id = total.parent("tr").find("td").eq(0).text();
//     $.ajax({
//         type:"GET",
//         url:"updateQuantity?quantity="+quantity.val()+"&itemId="+id+"&flag="+flag,
//         dataType:"text",
//         success:function (data){
//             let result1 = data.split("/");
//             if(result1[0] === "d")
//             {
//                 total.parent("tr").remove();
//                 subtotal.text("$"+result1[1]);
//             }
//             else {
//                 quantity.val(result1[0]);
//                 total.text("$" + result1[1]);
//                 subtotal.text("$" + result1[2]);
//             }
//         }
//     });
// }

