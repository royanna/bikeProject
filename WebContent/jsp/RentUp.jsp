<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出租</title>
    <link href="${pageContext.request.contextPath}/CSS/RentUp.css" rel="stylesheet" type="text/css">
    <style>
        .wimg{
            background: url(../Image/ground4.jpg) no-repeat;
            width:300px;
            height:600px;
            padding:5px;
        }
        .private{
            background: #29292c;
            width:265px;
            height:160px;
            padding:5px;
            border-radius:5px;
            filter:alpha(Opacity=60);
            -moz-opacity:0.6;
            opacity: 0.6
        }
        .tex1{
        width:55px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="wimg"></div>
    <div class="private" style="position: absolute;left:20px;top:50px;"></div>
    <div class="heading">
        <p class="write"style="position: absolute; left: 125px;top: 10px;">出租车辆</p>
    </div>
    <div class="body">
        <form method="get" action="${pageContext.request.contextPath}/registcar">
            <div style="position: absolute;left: 30px;top: 90px;">
            <input type="text" id="sheng" name="sheng" value=" " class="tex1"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">省
            </div>

        <div style="position: absolute;left: 120px;top: 90px;">
            <input type="text" id="shi" name="shi" value=" " class="tex1"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">市
        </div>
        <div style="position: absolute;left: 210px;top: 90px;">
            <input type="text" id="qu" name="qu" value=" " class="tex1" 
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">区
        </div>
        <div style="position: absolute;left: 30px;top: 150px;">
            <input type="text" id="add" name="add" value=" 具体地址" class="tex2"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
        </div>
        <div style="position: absolute;left: 30px;top: 250px;">
            <input type="text" id="numb" name="numb" value=" 车辆车牌号码" class="tex2"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
        </div>
        <div style="position: absolute;left: 30px;top: 300px;">
            <input type="text" id="phon" name="phon" value=" 您的电话号码" class="tex2"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
        </div>
        <div style="position: absolute; left: 30px; top:370px;">
            <input type="submit" class="sub" id="sub" value="提交">
        </div>
        </form>
    <div class="footing"></div>
</div>
</body>
</html>