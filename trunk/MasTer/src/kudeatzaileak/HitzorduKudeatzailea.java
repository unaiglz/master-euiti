package kudeatzaileak;

import interfazeak.EI_Bezeroa_Gehitu;
import interfazeak.EI_TerapeutaLibreak;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import datuBaseKonexioa.DBKudeatzaile;

public class HitzorduKudeatzailea {
	
	private static HitzorduKudeatzailea instantzia = new HitzorduKudeatzailea();
	
	private HitzorduKudeatzailea(){
		
	}
	
	public static HitzorduKudeatzailea getInstantzia(){
		return instantzia;
	}
	
	
	/**
	 * Bezeroaren nan zenbakia, data eta ordu bat pasako zaio eta metodoak
	 * teraoeuten zerrenda bat erakutsiko du bezeroak terapeuta aukeratu dezan
	 * @param nanZenbakia
	 * @param data
	 * @param ordua
	 * @param terapiaMota
	 */
	
	//data eta ordua datu basean parametro bakarra bezala dago jarrita
	//honengatik metodoan aldaketak egin beharko dira inkonpabilitate hau konpontzeko
	//gainera, String bezala jarrita daude
	
	public void HitzorduaEskatu(String nanZenbakia, String data, String ordua,
			String terapiaMota) {
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
		//Bezeroa datu-basean sartuta dagoen begiratzen da eta horrela ez bada
		//bezeroa datu-basean sartzeko interfazea zabaltzen da
		
		String k1 = "SELECT Nan FROM Bezeroa WHERE Nan=" + nanZenbakia;
		ResultSet emaitza1 = dbk.execSQL(k1);		
		try {
			if(emaitza1.getRow() == 0){
				EI_Bezeroa_Gehitu eiBezeroaGehitu = new EI_Bezeroa_Gehitu();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//data eta ordua parametro berean sartzeko, baina konbertsio bat egin behar da
		String dataOrdua = data + ordua;
		
		String k2 = "SELECT Erabiltzaile.Nan,Erabiltzailea.Izena FROM " +
				"Erabiltzailea, Formakuntza, TerapiaMota WHERE " +
				"Erabiltzailea.nan=Formakuntza.ErabiltzaileaID AND " +
				"TerapiaMota.ID=Formakuntza.TerapiaMotaID AND " +
				"TerapiaMota.Izena=" + terapiaMota +
				"AND (Erabiltzaile.ID NOT IN SELECT terapeutaID FROM Hitzordua "
				+ "WHERE dataOrdua=" + dataOrdua + ")";
		
		ResultSet emaitza2 = dbk.getInstantzia().execSQL(k2);
		try {
			//Terapeuta bakoitzeko nan zenbakia eta bere izena hartuko dugu
			//eta vector batean sartuko dugu
			
			String nan;
			String izena;
			Vector<String> terapeutak = new Vector<String>();
			
			for (int i = 0; i < emaitza2.getRow(); i++) {
				emaitza2.next();
				nan = emaitza2.getString("Nan");
				izena = emaitza2.getString("Izena");
				terapeutak.add(nan);
				terapeutak.add(izena);	
			}
			EI_TerapeutaLibreak eiTerapeutak = new EI_TerapeutaLibreak(terapeutak);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
