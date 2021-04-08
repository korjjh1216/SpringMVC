package cho.md.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import cho.md.domain.Address;
import lombok.extern.java.Log;

@Log
@Repository
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private HikariDataSource dataSource;
	
	@Override
	public List<Address> list() {
		List<Address> list = new ArrayList<Address>();
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from ADDRESS order by SEQ desc";
		ResultSet rs = null;
		try{
	           con = dataSource.getConnection();
	           stmt = con.createStatement();
			   rs = stmt.executeQuery(sql); //DQL 
			   while(rs.next()){
					long seq = rs.getLong(1);
					String name = rs.getString(2);
					String addr = rs.getString(3);
					Date rdate = rs.getDate(4);
					list.add(new Address(seq, name, addr, rdate));
			   }
	        }catch(SQLException se) {
	        	log.info("AddressDaoImpl list() se: " + se);
	        }finally {
	        	try{
	        		if(rs != null) rs.close();
	    			if(stmt != null) stmt.close();
	    			if(con != null) con.close();
	    		}catch(SQLException se){}
	        }
	        return list;
		}
		@Override
		public void insert(Address address) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
			try{
				con = dataSource.getConnection();
		        pstmt = con.prepareStatement(sql);
				pstmt.setString(1, address.getName());
				pstmt.setString(2, address.getAddr());
				pstmt.executeUpdate();
			}catch(SQLException se){
			}finally {
				try{
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se){}
			}
		}
		@Override
		public void delete(long seq) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "delete from ADDRESS where SEQ=?";
			try{
				con = dataSource.getConnection();
		        pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, seq);
				pstmt.executeUpdate();
			}catch(SQLException se){
			}finally {
				try{
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se){}
			}
		}
	}