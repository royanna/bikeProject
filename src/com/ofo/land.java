package com.ofo;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
//登陆
/**
 * Servlet implementation class land
 */
@WebServlet("/land")
public class land extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public land() {
        super();
        // TODO Auto-generated constructor stub
    }
    public boolean browse(DbBean db,String s1,String s2) throws Exception{
		String sql="select * from ofo";
	    db.stmt=db.conn.createStatement();
	    db.result=db.stmt.executeQuery(sql);
	    while(db.result.next()){
	    	String uname=db.result.getString("username");
	    	String upassword=db.result.getString("password");
	    	if(String.valueOf(uname).equals(s1) && String.valueOf(upassword).equals(s2)){
	    		db.stmt.close();
	    		db.result.close();
	    	    db.conn.close();
	    		return true;
	    	}
	    }
	    db.stmt.close();
	    db.result.close();
	    db.conn.close();
	    return false;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		DbBean db=new DbBean();
		db.lianjie();
		try{
			db.isConnectedOK();
			if(browse(db,request.getParameter("key1"), request.getParameter("key2"))==true)
			{
				request.setAttribute("usm", request.getParameter("key1")); 
				Cookie myCookie = new Cookie("usm", request.getParameter("key1"));
				myCookie.setMaxAge(24*60*60);
				response.addCookie(myCookie);
				request.getRequestDispatcher("jsp/index2.jsp").forward(request,response);
			}else{
				request.setAttribute("flag","0");
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
 			}
		}catch(Exception e){
			e.printStackTrace(); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
/* <%
                     int f=0;     //第一次登陆
                     if(request.getAttribute("flag")!=null){
                    	 if(request.getAttribute("flag")=="1"){    //账号密码错误
                    		 f=1;
                    	 }
                     }
                     if(f==0){
                    	 out.println("<input type='text' id='key1' name='key1' value='账号' class='tex1' onFocus='demo()' style='color:#999999;'>");
                    	 out.println("<br/>");
                         out.println("<input type='text' id='key2' name='key2' value='密码' class='tex2' onFocus='demo2()' style='color:#999999;'> ");
                         out.println("<br/>");
                     }
                     if(f==1){
                    	 out.println("<input type='text' id='key1' name='key1' value='账号或密码错误' class='tex1' onFocus='demo()' style='color:#999999'>");
                    	 out.println("<br/>");
                         out.println("<input type='text' id='key2' name='key2' value='账号或密码错误' class='tex2' onFocus='demo2()' style='color:#999999'>");
                         out.println("<br/>");
                     }
                     %>*/