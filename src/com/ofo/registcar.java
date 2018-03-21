package com.ofo;
//登陆自己的车辆信息
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registcar
 */
@WebServlet("/registcar")
public class registcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registcar() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void insett(String sheng,String shi,String qu,String add,String numb,String phon,DbBean db,String use) throws Exception{
		db.conn.setAutoCommit(false);   
		String sql2="update ofo set mycarsheng=?,mycarshi=?,mycarqu=?,mycaradd=?,mycarnum=?,myphone=? where username=?";
    	db.ps=db.conn.prepareStatement(sql2); 
    	db.ps.setString(1,new String(sheng.getBytes("ISO-8859-1"),"utf-8") );
    	db.ps.setString(2, new String(shi.getBytes("ISO-8859-1"),"utf-8"));
    	db.ps.setString(3, new String(qu.getBytes("ISO-8859-1"),"utf-8"));
    	db.ps.setString(4,new String(add.getBytes("ISO-8859-1"),"utf-8"));
    
    	db.ps.setString(5, numb);
    	db.ps.setString(6, phon);
    	db.ps.setString(7, use);
    	db.result=db.ps.executeQuery(); 
        db.conn.commit();
        db.ps.close();
        db.conn.close();
        db.result.close();
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
			//获取用户名
			Cookie[] allCookies = request.getCookies();
	    	Cookie temp = allCookies[0];
	    	String val = temp.getValue();
	    	System.out.println(val); 
	    	//插入车辆数据
	    	insett(request.getParameter("sheng"), request.getParameter("shi"), request.getParameter("qu"), request.getParameter("add"), request.getParameter("numb"),request.getParameter("phon"),db, val);
	    	//跳转下一页面
	    	request.getRequestDispatcher("jsp/index2.jsp").forward(request,response);
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
