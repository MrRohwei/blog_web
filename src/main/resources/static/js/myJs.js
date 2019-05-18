//登录
function loginSubmit() {
    var username = $("input[name=username]").val();
    var password = $("input[name=password]").val();
    var verifyCode = $("input[name=verifyCode]").val();
    if (!username) {
        alert("请输入用户名");
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
    var password = hex_md5(password);

    $.ajax({
        url: "/user/login",
        type: "post",
        data: {
            username: username,
            password: password,
            verifyCode:verifyCode
        },
        async: false,
        success: function (data) {
            console.log(data);
            if(!data){
                alert("系统错误");
                return false;
            }else{
                var obj = JSON.parse(data);
                var code = obj.code;
                var msg = obj.msg;
                if(code == 200){
                    alert("登录成功");
                    return true;
                }else{
                    alert(msg);
                }
            }
        },
        error: function () {
            alert("报错了");
            return false;
        }
    })
}

/**
 * 更换验证码
 * @param obj
 */
function changeVerifyCode(obj) {
    obj.src = "getVerifyCode?" + Math.random();
}