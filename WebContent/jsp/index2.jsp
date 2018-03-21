<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=DD279b2a90afdf0ae7a3796787a0742e"></script>
<title>导航</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/homepage.css" type="text/css">
</head>
<body>
<div class ="container">
    <div class ="wrapper">
        <div class="heading">
            <div class="heading_title">
                <form style="position: absolute;left: 10px;top: 5px;">
                    <div class="tex">
                        <input type="text" width="240px" height="20px" id="key1"
                               name="key" value=" 输入查找地址......" class="tex1"
                               onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                               onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
                    </div>
                </form>
                <img src="${pageContext.request.contextPath}/Image/Search.png" onClick="query()" height="20px" width="20px" style="position: absolute;left: 315px;top: 15px;">
            </div>
        </div>
        <div id="allmap"></div>
    </div>
    <div class="footing">
        <div class="footing_1">
            <a href="${pageContext.request.contextPath}/html/more.html"><img src="${pageContext.request.contextPath}/Image/Here.png" height="30px" width="30px" style="position: absolute;left: 269px;top:558px;"></a>
            <a href="${pageContext.request.contextPath}/html/moneypack.html"><img src="${pageContext.request.contextPath}/Image/mine.png" height="50px" width="50px" style="position: absolute;left: 7px;top: 545px;"></a>
            <a href="${pageContext.request.contextPath}/html/rent.html"><img src="${pageContext.request.contextPath}/Image/bicycle1.png" height="27px" width="27px" style="position: absolute;left: 150px;top: 560px;"></a>
            <div class="Mine">
                <p style="position: absolute;left: 270px;top: 585px;">更多</p>
            </div>
            <div class="Here">
                <p style="position: absolute;left: 149px;top: 585px;">单车</p>
            </div>
            <div class="Search">
                <p style="position: absolute;left: 20px;top: 585px;">我的</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" >
var map = new BMap.Map("allmap");
var point = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(point,12);

function myFun(result){
    var cityName = result.name;
    map.setCenter(cityName);
    alert("当前定位城市:"+cityName);
}
var myCity = new BMap.LocalCity();
myCity.get(myFun);


function query() {
    var sname_=document.getElementById("key1").value;
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);

    var myGeo = new BMap.Geocoder();

    myGeo.getPoint(sname_, function(point){
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }else{
            
        }
    }, "");
}
function getTwo() {
    var p=document.getElementById("key1").value;
    window.location.href = "coordinate.html?name=" + p;
}
</script>