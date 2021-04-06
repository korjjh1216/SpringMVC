import java.sql.*;

class JdbcT{
    JdbcT(){
        //1. 오라클 드라이버 로딩
        try{
        Class.forName("Oracle.jdbc.driver.OracleDriver");
        System.out.println("1. 오라클 드라이버 로딩 성공");
        }  catch (ClassNotFoundException cf) {
            System.out.println("1. 오라클 드라이버 로딩 실패");
        }
        //2. 커넥션 생성
        try {
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
            DriverManager.getconnection(url,"scott","tiger");
            System.out.println("1. 오라클과 커넥션 생성 성공");
        } catch (SQLException se) {
            System.out.println("1. 오라클과 커넥션 생성 실패");
        }
        //3. Statement 생성
        try {
            String sql = "select * from DEPT";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql) ;
            System.out.println("statement 생성/실행 성공");
        } catch (Exception e) {
            System.out.println("statement 생성/실행 실패");
        }
        //4. Statement 실행
        try {
            while(rs.next()){
                no = rs.getInt(1);
                dname = rs.getString(2);
                loc = rs.getString(3);
                System.out.println(no + "\t" + dname +"\t"+loc);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        //5. ResultSet 추출
        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if
        } catch (Exception e) {
            //TODO: handle exception
        }

        System.out.println("Hello world");
    
    }
    public static void main(String[] args) {
        new JdbcT();
    }
}