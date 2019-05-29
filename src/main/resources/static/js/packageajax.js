/**
 * post ajax
 * @param url
 * @param param
 */
function postAjax(url, param){
    $.ajax({
        url: url,
        type: "post",
        data: param,
        success: function (data) {
            if(!data){
                alert("系统错误");
                return false;
            }else{
                return data;
            }
        },
        error: function () {
            alert("报错了");
            return false;
        }
    });
}

/**
 * get ajax
 * @param url
 * @param param
 */
function getAjax(url, param){
    $.ajax({
        url: url,
        type: "get",
        data: param,
        success: function (data) {
            if(!data){
                alert("系统错误");
                return false;
            }else{
                alert("data = " + data);
                return data;
            }
        },
        error: function () {
            alert("报错了");
            return false;
        }
    });
}