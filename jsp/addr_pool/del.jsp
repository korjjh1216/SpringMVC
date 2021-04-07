<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<jsp:useBean id="pool" class="cho.db.ConnectionPoolBean" scope="application"/>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "delete from ADDRESS where SEQ=?";
String seqStr = request.getParameter("seq");
long seq = Long.parseLong(seqStr);
	try{
		con = pool.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1,seq);
        pstmt.executeUpdate(); //DML (insert, update, delete)
	}catch(SQLException se){
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) pool.returnConnection(con);
		}catch(SQLException se){}
	}
%>
<script>
    alert("삭제 성공 with Pool");
	location.href="list.jsp";
</script>