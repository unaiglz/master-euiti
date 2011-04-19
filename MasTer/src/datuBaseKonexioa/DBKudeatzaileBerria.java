package datuBaseKonexioa;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBKudeatzaileBerria {

	Connection conn = null;

	private void conOpen() {
		try {
			String userName = "teletxe"; // Erabiltzaile
			String password = "softing2010"; // Pasahitza
			String url = "jdbc:mysql://localhost/masterdb"; // Non dagoen
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(url, userName,
					password);
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
		}
	}

	public Connection getConn() {
		return conn;
	}

	private void conClose() {

		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println("Database connection terminated");

	}

	private ResultSet query(Statement s, String query) {

		ResultSet rs = null;

		try {
			s.executeQuery(query);
			rs = s.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// singleton patroia
	private static DBKudeatzaileBerria instantzia = new DBKudeatzaileBerria();

	private DBKudeatzaileBerria() {
		this.conOpen();

	}

	public static DBKudeatzaileBerria getInstantzia() {
		return instantzia;
	}

	//
	public ResultSet execSQL(String query, Vector<String> parametroak) {
		int count = 0;
		Statement s = null;
		ResultSet rs = null;

		try {
			s = (Statement) conn.createStatement();
			if (query.toLowerCase().indexOf("select") == 0) {
				// select agindu bat
				PreparedStatement prep = conn.prepareStatement(query);
				Iterator<String> it = parametroak.iterator();
				int i = 1;
				while (it.hasNext()) {
					prep.setString(i, it.next());
					i++;
				}
				prep.executeQuery();
				// rs = this.query(s, query);

			} else {
				// update, delete, create agindu bat
				count = s.executeUpdate(query);
				System.out.println(count + " rows affected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// finally {
		// if (s != null)
		// try {
		// s.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }

		return rs;
	}
}
