package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TransactionDAO {
	int id = 0;
	int acc_no = 0;
	int balance = 0;
	int limit = 0;
	@SuppressWarnings("rawtypes")
	public List doTransaction () throws SQLException {
		ResultSet rs = null;
		List<Integer> list = new ArrayList<>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdetails", "root", "");
		if(con != null) {
			System.out.println("succesfully created...");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from usertransactions");
			rs.last();
			acc_no = rs.getInt("ACC.NO");
			id = rs.getInt("id");
			balance = rs.getInt("balance");
				if(balance > 1000) {
					System.out.println("i am getter method..i got " + Transactions.getBalance());
					int updated_balance = balance - Transactions.getBalance();
					int updated_id = id + 1;
					System.out.println("updated balnce=" + updated_balance);
					PreparedStatement pt = con.prepareStatement("insert into usertransactions values(?,?,?)");
					pt.setInt(1, updated_id);
					pt.setInt(2, acc_no);
					pt.setInt(3, updated_balance);
					pt.executeUpdate();
					rs.afterLast();
					while(limit <= 4){
						if(rs.previous()) { 
							list.add(Integer.parseInt(rs.getString(3)));
							limit++;
						}
				    }
				}
			con.close();
		}
			else {
				System.out.println("not created.....");
			   }
		}
		catch(Exception e) {
			System.out.println("error" + e.getMessage());
		}
		return list;
	}
}
		
		
	
