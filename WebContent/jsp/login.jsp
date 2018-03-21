<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/login.css">
</head>
<body>
<div class="container">
    <div class="wrapper">
        <div class="heading">
          <p style="position: absolute; left: 144px; top:10px;"></p>
        </div>
        <div class="baby">
            <div class="baby_img">
                <img src="${pageContext.request.contextPath}/Image/bik2.gif" width="260px" height="160px" style="position: absolute;border-radius:200px;left: 45px;top: 55px;">  <!-- 260 160 45 55-->
            </div>
            <br/>
            <div class="baby_1">
            <div class="baby_2">
             <form method="get" action="${pageContext.request.contextPath}/land" >
                    <div class="tex" style="position: absolute;left: 60px;top: 250px;">
                     <input type="text" id="key1" name="key1" value=" 账号" class="tex1"
                           onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                           onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
                      </br>
                        <input type="text" id="key2" name="key2" value=" 密码" class="tex2"
                               onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                               onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
                        </br>
                        </br>
                    </div>
                    <label class="put" style="position: absolute;left: 60px;top:350px;"><input name="Read" type="checkbox" value=" "/>我已经阅读并同意《用户注册服务协议》</label>                     
                        <input class="put1" type="submit"  value=" 登录" class="btn" style="width:200px;position: absolute;left: 75px;top: 440px;">               
             </form>
            </div>
        </div>
        <div class="footing"></div>
    </div>
</div><br/><br/>
<a href="${pageContext.request.contextPath}/jsp/index2.jsp" class="youk">游客登录</a>
<a href="${pageContext.request.contextPath}/jsp/register.jsp" class="zc">注册</a>
<%
if(request.getAttribute("flag")!=null){
    if(request.getAttribute("flag")=="0"){
        out.println("<script>");
        out.print("alert('账户名或密码错误！')");
        out.println("</script>"); 
    }
}
%>
</body>
</html>
