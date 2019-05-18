//登录
function loginSubmit() {
    var username = $("input[name=username]").val();
    var password = $("input[name=password]").val();
    if(!username){
        alert("请输入用户名");
        return false;
    }
    if(!password){
        alert("请输入密码");
        return false;
    }

    $.ajax({
        url:"/user/login",
        type:"post",
        data:{
            username:username,
            password:password
        },
        async:false,
        success:function (data) {
            alert(data);
            return true;
        },
        error:function () {
            alert("报错了");
            return false;
        }
    })
}