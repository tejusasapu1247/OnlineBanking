package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TransactionDAO {
	int id = 0, acc_no = 0, balance = 0, limit = 0, updated_balance = 0, amount = 0;
	ResultSet rs = null, rs1 = null;
	public List<Integer> doTransaction () throws SQLException {
		List<Integer> list = new ArrayList<>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdetails", "root", "");
		if(con != null) {
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from usertransactions");
			rs.last();
			acc_no = rs.getInt("ACC.NO");
			id = rs.getInt("id");
			balance = rs.getInt("balance");
			
				if(balance > 1000) {
					amount = Transactions.getBalance();
					updated_balance = balance - amount;
					PreparedStatement pt = con.prepareStatement("insert into usertransactions values(?,?,?)");
					pt.setInt(1, id + 1);
					pt.setInt(2, acc_no);
					pt.setInt(3, updated_balance);
					pt.executeUpdate();
					rs1 = st.executeQuery("select * from usertransactions");
					rs1.last();
					while(limit <= 4){
						list.add(Integer.parseInt(rs.getString(3)));
						limit++;
						rs1.previous();
					}
				}
			con.close();
		} else {
			System.out.println("not created.....");
	        }
		} catch(Exception e) {
			System.out.println("error" + e.getMessage());
		}
		return list;
	}
}
		
		
	
