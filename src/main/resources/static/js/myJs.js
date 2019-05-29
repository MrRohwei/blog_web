//登录
function loginSubmit() {
    var username = $("input[name=username]").val();
    var password = $("input[name=password]").val();
    var verifyCode = $("input[name=verifyCode]").val();
    if (!username) {
        alert("请输入用户名");
        // $("input[name=username]").css("border","2px solid red");//用户名为空提示css
        return false;
    }
    if (!password) {
        alert("请输入密码");
        return false;
    }
    if(!verifyCode){
        alert("请输入验证码");
        return false;
    }
    var data = {
        username: username,
        password: password,
        verifyCode:verifyCode
    };
    // var data = postAjax("/user/loginSubmit",data);
    // alert(data);
    // var password = hex_md5(password);
    $.ajax({
        url: "/user/loginSubmit",
        type: "post",
        data: data,
        // async: false,
        // dataType: "application/json",
        success: function (data) {
            if(!data){
                alert("系统错误");
                return false;
            }else{
                var obj = JSON.parse(data);
                var code = obj.code;
                var msg = obj.msg;
                $("#imgVerify").click();
                if(code == 200){
                    // alert("登录成功");
                    location.href = "index";
                    // return true;
                }else{
                    alert(msg);
                }
            }
        },
        error: function () {
            alert("报错了");
            return false;
        }
    });
}

/**
 * 更换验证码
 * @param obj
 */
function changeVerifyCode(obj) {
    obj.src = "getVerifyCode?" + Math.random();
}
