package com.ofo;
//匹配当地车辆
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.ChangedCharSetException;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class usedanc
 */
@WebServlet("/usedanc")
public class usedanc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usedanc() {
        super();
        // TODO Auto-generated constructor stub
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
			String sql="select * from ofo";
			db.stmt=db.conn.createStatement();
			db.result=db.stmt.executeQuery(sql);
		    int i=0;
		    while(db.result.next()){
		    	String usheng=db.result.getString("mycarsheng");
		    	String ushi=db.result.getString("mycarshi");
		    	String uqu=db.result.getString("mycarqu");
		    	String uadd=db.result.getString("mycaradd");
		    	String unum=db.result.getString("mycarnum");
		    	String uphone=db.result.getString("myphone");
		    	if(usheng!=null){
		    		String sheng2=new String(request.getParameter("sheng").getBytes("ISO-8859-1"),"utf-8");
		    		String shi2=new String(request.getParameter("shi").getBytes("ISO-8859-1"),"utf-8");
		    		String qu2=new String(request.getParameter("qu").getBytes("ISO-8859-1"),"utf-8");
		    		if(String.valueOf(usheng).equals(sheng2) && String.valueOf(ushi).equals(shi2) && String.valueOf(uqu).equals(qu2)){
			    		String temp1="pro"+String.valueOf(i); 
			    		request.setAttribute(temp1,usheng+ushi+uqu+uadd+"；车牌号码："+unum+";联系方式："+uphone );
			    		request.setAttribute("num", unum);
			    		request.setAttribute("udd", uadd); 
			    	    i++;
			    	}
		    	}	
		    }
		    db.stmt.close();
    		db.result.close();
    	    db.conn.close();	    
    	    request.getRequestDispatcher("jsp/allcar.jsp").forward(request,response);
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
