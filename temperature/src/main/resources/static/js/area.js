$(function () {
    getProvince();  //页面打开后，省级下拉列表自动绑定
})
    //获取省份
function getProvince() {
    let Afather;
    let $listprovince = $("#prvlist");
    $.ajax({
        type:"post",
        url:'/china',
        datatype:"json",
        success:function (data) {
            for(let str in data){
                Afather += '<option id=" ' + str + '" value="' + data[str] + '">';
            }
            $listprovince.append(Afather);
        },
        error:function (error){
        }
    });
}
function changeProvince() {
    let city;
    let prv_val = $("#province").val();
    if ("江苏" != prv_val)
        return;
    setCity(10119);
}

function setCity(val) {
    let Acity;
    let $listcity = $("#citylist");
    $.ajax({
        type: "post",
        url: '/city',
        data: {"code": val},
        datatype: "json",
        success: function (data) {
            for (let str in data) {
                // if (str == val) {
                Acity += '<option id=" ' + str + '" value="' + data[str] + '">';
                // }
            }
            $listcity.append(Acity);
        },
        error: function (e) {
            console.log("setCity error")
        }
    });
}

   function changeCity(){
       let city_val=$("#city").val();
       if ("苏州" != city_val)
           return;
       setArea(1011904);
    }

function setArea(Aval) {
    var Aarea;
    var $listarea = $("#arealist");
    $.ajax({
        type: "post",
        url: '/station',
        data: {"code": Aval},
        datatype: "json",
        success: function (data) {
            for (let str in data) {
                // if (str == val) {
                Aarea += '<option id=" ' + str + '" value="' + data[str] + '">';
                // }
            }
            $listarea.append(Aarea);
        },
        error: function (e) {
            console.log("setArea error")
        }
    });
}

