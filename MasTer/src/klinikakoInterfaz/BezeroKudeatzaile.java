package klinikakoInterfaz;

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
		Boolean badago=false;
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT COUNT(*) AS m FROM Bezeroa WHERE Nan='"
			+ nan + "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			if (rs.getInt("m") != 0) {
				badago=true;
			} else {
				badago=false;
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
		return badago;
	}
	public void bezeroaGehitu(String nan, String izena, String helbidea, Date jaiotzeData) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		if(bezeroaBilatu(nan)){
			new EI_Error_BezeroaExistitu();
		}else{
			String K1 = "INSERT INTO Bezeroa VALUES('" + nan + "','" + izena + "','"
			+ helbidea + "','" + jaiotzeData + "')";
			dbk.execSQL(K1);
	new EI_BezeroaGehituta(nan, izena, helbidea, jaiotzeData);
		}
	}
}
