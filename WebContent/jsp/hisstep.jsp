<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/detailroute.css">
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=DD279b2a90afdf0ae7a3796787a0742e"></script>
    <title>导航结果</title>
    <style>
        .comimg{
            background: url("${pageContext.request.contextPath}/Image/footche.jpg") no-repeat;
            width:300px;
            height:600px;
            padding:10px;
        }
        .comto{
            background: #252524;
            width:270px;
            height:540px;
            padding:10px;
            color: white;
            border-radius:5px;
            filter:alpha(opacity=50);
            -moz-opacity:0.5;
            opacity:0.5;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="comimg">
    <br/><br/>
    <p style="position:relative;left: 20px;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;行程&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间</p><br/>
        	<% 
            if(request.getAttribute("uj")!=null){
            	String uj=(String)request.getAttribute("uj");
            	String ut=(String)request.getAttribute("ut");
            	char str[]=new char[100];            
            	int i=0,j=0,k=0;
            	out.println("<p style='color:white;'>");
            	while(j!=ut.length()){
            		str[k]=uj.charAt(i);
            		out.println(str[k]);
            		i++;k++;
            		if(uj.charAt(i)==' ' || i==(uj.length()-1)){
            			str[k]=uj.charAt(i);
            			out.println(str[k]);
                		i++;k++;
            			while(ut.charAt(j)!=' ' && j!=(ut.length()-1)){
            				str[k]=ut.charAt(j);
            				out.println(str[k]);
                    		j++;k++;
                    		if(j==(ut.length()-1)){
                    			out.println("</p>");
                    			out.println("<p style='color:white;'>");
                    		}
            			}
            			str[k]=ut.charAt(j);
            			out.println(str[k]);
                		j++;k++; 
            		}
            	}
            }
        		
        	%>
        
        <div class="comto" style="position: absolute; left: 20px; top: 40px;"></div>
    </div>
    <div class="wrapper">
        <div class="heading">
            <div class="heading_1">
                <a href="planroute.html" style="position: absolute;left: 10px;top:8px">返回</a>
            </div>
            <div class="heading_2">
                <img src="${pageContext.request.contextPath}/Image/bicycle1.png" width="25px" height="25px" style="position: absolute;left: 145px;top:7px">
            </div>
            <a href="#" style="position: absolute;left: 250px;top:8px">路线</a>
        </div>
        <div id="lala"></div>
        <div id="baby"></div>
    </div>
</div>
</body>
</html>