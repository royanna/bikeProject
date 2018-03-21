package com.ofo;
//确认交易
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class confirm
 */
@WebServlet("/confirm")
public class confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirm() {
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
			db.conn.setAutoCommit(false);   
			String sql="select mycarnum from ofo where username=?";
		    db.ps=db.conn.prepareStatement(sql);
		    Cookie[] allCookies = request.getCookies();
	    	Cookie temp = allCookies[0];
	    	String val = temp.getValue();
		    db.ps.setString(1,val);   
		    db.result=db.ps.executeQuery();
		    db.result.next();
		    String n=db.result.getString("mycarnum");
		    System.out.println(request.getParameter("txt1"));  
		    String s1=new String(request.getParameter("txt1").getBytes("ISO-8859-1"),"utf-8");
		    String s2=new String(request.getParameter("txt2").getBytes("ISO-8859-1"),"utf-8");
		    String s3=new String(request.getParameter("txt3").getBytes("ISO-8859-1"),"utf-8");
		    String s4=new String(request.getParameter("txt4").getBytes("ISO-8859-1"),"utf-8");
		    String u=s1+s2+s3+s4;
		    
		   // String u=new String(request.getParameter("corr").getBytes("ISO-8859-1"),"utf-8");
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		    String u2=df.format(new Date());
		    if(n!=null){
		    	if(n.equals(u)){      //本人车主
		    		System.out.println("chezhu");
			        String sql3="update ofo set mycarsheng=' ',mycarshi=' ',mycarqu=' ',mycaradd=' ',mycarnum=' ',myphone=' ' where username=?";
			        db.ps=db.conn.prepareStatement(sql3); 
			        db.ps.setString(1, val);	
			        db.result=db.ps.executeQuery(); 
			   	}
		    	else{           //本人非车主
		    		System.out.println("feichezhu"); 
			   		String sql4="select journey,time from ofo where username=?";
				    db.ps=db.conn.prepareStatement(sql4);
				    db.ps.setString(1, val); 
				    db.result=db.ps.executeQuery();
				    db.result.next();
				   	String ujourney=db.result.getString("journey");
				   	String utime=db.result.getString("time");
				   	
				   	String sql3="update ofo set journey=?,time=? where username=?";
			   		db.ps=db.conn.prepareStatement(sql3); 
			    	if(ujourney!=null){
			    		String q1=ujourney+" "+u;
			    		String q2=utime+" "+u2;
			    		db.ps.setString(1, q1);	
				    	db.ps.setString(2,q2);  
			    	}
			    	else{
			    		db.ps.setString(1,u);	
				    	db.ps.setString(2,u2);  
			    	}
			    	db.ps.setString(3,val);	
			   		db.result=db.ps.executeQuery();       
		        }
		   	}
		    else{
		    	System.out.println("feichezhu"); 
		   		String sql4="select journey,time from ofo where username=?";
			    db.ps=db.conn.prepareStatement(sql4);
			    db.ps.setString(1, val); 
			    db.result=db.ps.executeQuery();
			    db.result.next();
			   	String ujourney=db.result.getString("journey");
			   	String utime=db.result.getString("time");
			   	
			   	String sql3="update ofo set journey=?,time=? where username=?";
		   		db.ps=db.conn.prepareStatement(sql3); 
		    	if(ujourney!=null){
		    		String q1=ujourney+" "+u;
		    		String q2=utime+" "+u2;
		    		db.ps.setString(1, q1);	
			    	db.ps.setString(2,q2);  
		    	}
		    	else{
		    		db.ps.setString(1,u);	
			    	db.ps.setString(2,u2);  
		    	}
		    	db.ps.setString(3,val);	
		   		db.result=db.ps.executeQuery();      
		    }
		    db.conn.commit(); 
	        db.ps.close();
	        db.conn.close();
 		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			request.getRequestDispatcher("jsp/index2.jsp").forward(request, response);
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
