<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
    <link href="${pageContext.request.contextPath}/CSS/enroll2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="Container">
    <div class="heading">
        <p class="write" style="position: absolute;left: 50px;top:25px;">Welcome to Locaticus</p>
    </div>
    <div class="body">
        <div class="body-img">
           <img src="${pageContext.request.contextPath}/Image/Location.jpg" width="240px" height="240px" style="position: absolute; left:25px;top: 60px;">
        </div>
        <div class="body-tex">
            <form method="get" action="../DbBean">
                <div style="position: absolute;left: 50px;top: 315px;">
                <input type="text" id="tx1" name="tx1" value="  请输入电话号码" class="tex1"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
                </div>

            <div style="position: absolute;left: 50px;top: 350px;">
                <input type="text" id="tx2" name="tx2" value=" 请输入密码" class="tex1"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
            </div>
            <div style="position: absolute;left: 50px;top: 385px;">
                <input type="text" id="tx3" name="tx3" value=" 确认密码" class="tex1"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
            </div>
            <div style="position: absolute;left: 50px;top: 455px;">
                <input style="overflow:visible;padding:0;position:absolute;filter:alpha(Opacity=50);
                opacity:0.5"type="submit" value=" &nbsp;&nbsp;提交" class="btn">
            </div>
            </form>
        </div>
    </div>
    <div class="footing"></div>
</div>
<%
        if(request.getAttribute("fl")!=null){
        	if(request.getAttribute("fl")=="1"){
        		out.println("<script>");
        		out.println("alert('确认密码错误，请重新输入！');");
        		out.println("</script>");
        	}
        }
        %>
</body>
</html>