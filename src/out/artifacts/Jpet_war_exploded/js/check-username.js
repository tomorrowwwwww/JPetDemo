var elUsername = document.getElementById('usernamelogin'),
    elMsg=document.getElementById('feedback');

var xhr='';
function checkUsername(username){
    if(username===null || username==='' ||username.length===0){
        elMsg.textContent= 'USERNAME CANNOT BE EMPTY';
        return;
    }
    if(username.length<=1){
        elMsg.textContent= 'USERNAME LENGTH TOO SHORT';
        return;
    }
    elMsg.textContent='';
    sendRequest(username);
}

function sendRequest(username){
    xhr =new XMLHttpRequest();
    xhr.onreadystatechange=process;
    xhr.open('GET','/SignOnFormServlet?username='+username);
    xhr.send(null);
}
function process(){
    console("nnnnn");
    if(xhr.readyState ===4){
        if(xhr.status===200){
            var responseInfo = xhr.responseText;
            if(responseInfo==='Exist'){
                elMsg.textContent='Exist';
            }
            else{
                elMsg.textContent='用户名不存在';
            }
        }
    }
}


elUsername.addEventListener('blur',function (){
    var username=elUsername.value.trim();
    checkUsername(username);
});