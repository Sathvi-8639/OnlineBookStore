package test;
import java.sql.*;
public class CustomerLoginDAO {
	public RegisterBean rb=null;
	public RegisterBean login(String uname,String pword) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from customer57 where uname=? and pword=?");
			ps.setString(1, uname);
			ps.setString(2, pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				rb=new RegisterBean();
				rb.setUname(rs.getString(1));
				rb.setPword(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setAddr(rs.getString(5));
				rb.setMid(rs.getString(6));
				rb.setPhno(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return rb;
	}
}
