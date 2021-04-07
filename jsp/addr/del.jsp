<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<%!
	Connection con;
	PreparedStatement pstmt;
	String sql = "delete from ADDRESS where SEQ=?";
    public void jspInit(){ 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
		}catch(ClassNotFoundException cf){
		}catch(SQLException se){
		}
    } 
	public void jspDestroy(){
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
    } 
%>
<%
String seqStr = request.getParameter("seq");
long seq = Long.parseLong(seqStr);
	try{
		pstmt.setLong(1,seq);
        pstmt.executeUpdate(); //DML (insert, update, delete)
        response.sendRedirect("list.jsp");
	}catch(SQLException se){
	}
%>