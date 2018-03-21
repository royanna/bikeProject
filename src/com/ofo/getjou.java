package com.ofo;
//读取行程
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getjou
 */
@WebServlet("/getjou")
public class getjou extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uj=null;
    private String ut=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getjou() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void getjoun(String pusername,DbBean db)throws Exception{
		String sql="select journey,time from ofo where username=?";
	    db.ps=db.conn.prepareStatement(sql);
	    db.ps.setString(1, pusername);
	    db.result=db.ps.executeQuery();
	    while(db.result.next()){
	    	String aa=db.result.getString("journey");
	    	this.uj=aa;
	    	String bb=db.result.getString("time");
	    	this.ut=bb;
	    }
	    db.ps.close();
	    db.result.close();
	    db.conn.close();
	}
	public String getUj(){
		return this.uj;
	}
	public String getUt(){
		return this.ut;
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
			
			Cookie[] allCookies = request.getCookies();
	    	Cookie temp = allCookies[0];
	    	String val = temp.getValue();
	    	
			getjoun(val,db); 	 
			if(this.uj!=null){
			    request.setAttribute("uj", getUj());
				request.setAttribute("ut", getUt());
			}
			request.getRequestDispatcher("jsp/hisstep.jsp").forward(request, response);
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
