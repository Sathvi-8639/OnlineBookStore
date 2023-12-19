package test;
import java.sql.*;
public class PurchaseDAO {
	public int k=0;
	public int Purchase(int rqty, String bcode) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update BookDetails57 set qty=qty-? where code=?");
			ps.setInt(1,rqty);
			ps.setString(2, bcode);
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
