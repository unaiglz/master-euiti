package kudeatzaileak;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.naming.spi.DirStateFactory.Result;

import datuBaseKonexioa.DBKudeatzaile;

public class BezeroKudeatzaile {

	private static BezeroKudeatzaile instantzia= new BezeroKudeatzaile();

	private BezeroKudeatzaile(){
		
	}
	
	public static BezeroKudeatzaile getInstantzia(){
		return instantzia;
	}
	public boolean bezeroaBilatu(String nan){
		Boolean badago=true;
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT COUNT(*) AS m FROM Bezeroa WHERE Nan='"
			+ nan + "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			//probak
			if (rs.getInt("m") != 0) {
				badago=true;
				System.out.println("badago");
			} else {
				badago=false;
				System.out.println("ez dago");
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
		return badago;
	}
	public void bezeroaGehitu(String nan, String izena, String jaiotzeData, String helbidea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
			String K1 = "INSERT INTO Bezeroa VALUES('" + nan + "','"
			+ izena + "','" + jaiotzeData + "','" + helbidea + "')";
			dbk.execSQL(K1);
	}
}
