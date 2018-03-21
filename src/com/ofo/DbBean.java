package com.ofo;
//注册
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import java.sql.*;
/**
 * Servlet implementation class DbBean
 */
@WebServlet("/DbBean")
public class DbBean extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	Connection conn=null;
    SQLException ex=null;
    Statement stmt=null;
    PreparedStatement ps=null;
    ResultSet result=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void lianjie() {
        //super();
        // TODO Auto-generated constructor stub
        try{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		}catch(ClassNotFoundException ex){
    			throw new RuntimeException(ex);
    		}
    }
    public void isConnectedOK() throws SQLException{
		String url="jdbc:oracle:thin:@47.93.62.40:1521:XE";
		String user="system";
    	String password="wy20001108?";
	    conn=DriverManager.getConnection(url,user,password);
 	}
	
	public void insertt(String ulic,String uti) throws Exception{
		conn.setAutoCommit(false);   
    	String sql="insert into ofo(username,password) values(?,?)";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, ulic);	
    	ps.setString(2,uti); 
        result=ps.executeQuery();
        conn.commit();
        ps.close();
        conn.close();
        result.close();
	}
	public boolean checkpw(String s1,String s2){
		System.out.println(s1+" "+s2); 
		if(s1.equals(s2)){System.out.println("lala");
			return true;
		}
		return false;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		lianjie();
		try{
			isConnectedOK();
			if(checkpw(request.getParameter("tx2"), request.getParameter("tx3"))){
				insertt(request.getParameter("tx1"),request.getParameter("tx2"));
				request.setAttribute("fl", "0"); 
				request.getRequestDispatcher("jsp/login.jsp").forward(request,response);
			}
			else{System.out.println("ngng");
				request.setAttribute("fl", "1"); 
				request.getRequestDispatcher("jsp/register.jsp").forward(request, response); 
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









