<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<%!
	Connection con;
	Statement stmt;
	String sql = "select * from ADDRESS order by SEQ desc";
    public void jspInit(){ //첫번째 요청에의해 메모리에 올라갈 때 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //oracle 
			//Class.forName("com.mysql.jdbc.Driver"); //mysql 
			System.out.println("(1) driver loading");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA"; //oracle
			//String url = "jdbc:mysql://localhost:3306/schemaName"; //mysql
			con = DriverManager.getConnection(url, "scott", "tiger"); //oracle 
			//con = DriverManager.getConnection(url, "user","pwd"); //mysql
			System.out.println("(2) con: " + con);

			stmt = con.createStatement();
			System.out.println("(3) stmt: " +stmt);
		}catch(ClassNotFoundException cf){
			System.out.println("(1) cf:" + cf);
		}catch(SQLException se){
			System.out.println("(2) se" + se);
			System.out.println("(3) se" + se);
		}
    } 
	public void jspDestroy(){//메모리에 올라갈 때( 페이지가 갱신, 서버에 정책 )
		try{
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			System.out.println("(5) 연결 객체를 닫기 성공");
		}catch(SQLException se){}
    } 
%>


<meta charset="utf-8">
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px;
	}
	a { text-decoration:none }
</style>
<center>
	<h1>
		Address List 
	</h1>
	<a href="../">인덱스</a>
	&nbsp;&nbsp;&nbsp;
	<a href="input.jsp">입력폼</a>
	<table border='1' cellpadding="7" cellspacing="2" width="50%">
	    <tr>
		    <th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<%   
        ResultSet rs = null;
        try{
		   rs = stmt.executeQuery(sql);
		   while(rs.next()){
				long seq = rs.getLong(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
%> 
                <tr>
					<td align='center'><%=seq%></td>
					<td><%=name%></td>
					<td><%=addr%></td>
					<td><%=rdate%></td>
					<td align='center'><a href='del.jsp?seq=<%=seq%>'>삭제</a></td>
				</tr>
				<%
			}
		 }catch(SQLException se){
			 System.out.println("se: " + se);
		 }finally{
			 try{
				 if(rs != null) rs.close();
			 }catch(SQLException se){}
		 }
 %>	
	</table>
</center>