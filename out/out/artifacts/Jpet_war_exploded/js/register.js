function checkUsername(username){
    if(username===null || username==='' ||username.length===0){
        return '用户名不能为空';
    }
    if(username.length<=1){
        return '用户名长度必须大于五';
    }
    return '';
}
$(function (){
    $('#usernamelogin').on('blur',function (){
        var username =$(this).val();
        var validateMsg =checkUsername(username);
        if(validateMsg===''){
            $('#feedback').text('');
            $.ajax({
                type:'GET',
                url:''
            })
        }
        else{
            $('#feedback').text(validateMsg);
        }
    });
});