package test;
import java.sql.*;
public class RegisterCustomerDAO {
	public int k=0;
	public int insert(RegisterBean rb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into customer57 values(?,?,?,?,?,?,?)");
			ps.setString(1, rb.getUname());
			ps.setString(2, rb.getPword());
			ps.setString(3, rb.getFname());
			ps.setString(4, rb.getLname());
			ps.setString(5, rb.getAddr());
			ps.setString(6, rb.getMid());
			ps.setLong(7, rb.getPhno());
			k=ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
