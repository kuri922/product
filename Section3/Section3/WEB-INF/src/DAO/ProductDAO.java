package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.Product;
public class ProductDAO{
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	public Connection connect() throws NamingException, SQLException {

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/cj/jdbc/mysql");
			this.db = ds.getConnection();
		} catch (NamingException e) {
			String URL="jdbc:mysql://localhost/exercise_b";
			String USER="kuriyama";
			String PASSWORD="jqb60173";

			db = DriverManager.getConnection(URL, USER ,PASSWORD );
		}
		return db;
	}
	public List<Product> findAll(){
		List<Product> list = new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM m_product");
			rs = ps.executeQuery();
			while (rs.next()) {
				int Product_code = rs.getInt("Product_code");
				String Product_name = rs.getString("Product_name");
				int price = rs.getInt("price");
				Product product = new Product(Product_code , Product_name , price);
				list.add(product);
			}

		}catch (NamingException | SQLException e) {
			e.printStackTrace();

		}finally {
			try {
				if(db != null) {
					db.close();
				}
			}catch (SQLException ignore) {

			}
		}
		return list;
	}

}
