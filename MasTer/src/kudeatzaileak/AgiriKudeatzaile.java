package kudeatzaileak;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import datuBaseKonexioa.DBKudeatzaile;

//String dataOrdua, String terapeutaID, String bezeroID, String terapiaMotaID

public class AgiriKudeatzaile {
	private static AgiriKudeatzaile instantzia = new AgiriKudeatzaile();
	private static int agiriZbk;

	private AgiriKudeatzaile() {
		lortuAgiriZbkBalioa();
	}

	private void lortuAgiriZbkBalioa() {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT * FROM AgiriZbk";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			agiriZbk = rs.getInt("Zenbakia");
		} catch (SQLException e) {
			agiriZbk = 1;
			gordeAgiriZbk();
			e.printStackTrace();
		}

	}

	public static AgiriKudeatzaile getInstantzia() {
		return instantzia;
	}

	public void SortuPdf(String data, String terapeuta, String bezeroa,
			String terapiaMota) {
		try {

			OutputStream file = new FileOutputStream(new File("Agiriak/"
					+ agiriZbk + "AGIRI.pdf"));
			agiriZbk++;

			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			Paragraph master = new Paragraph("Master Klinika",
					FontFactory.getFont(FontFactory.HELVETICA));
			Chapter titulua = new Chapter(master, 1);
			titulua.setNumberDepth(0);
			document.add(titulua);
			document.add(new Paragraph("Bezeroa: \t"
					+ BezeroKudeatzaile.getInstantzia().lortuIzena(bezeroa)));
			document.add(new Paragraph("Data: \t" + new Date().toString()));
			document.add(new Paragraph("Terapeuta: \t"
					+ ErabiltzaileKudeatzaile.getInstantzia().lortuIzena(
							terapeuta)));
			document.add(new Paragraph("Bezeroak " + terapiaMota
					+ " terapia jaso zuen " + data + "-en"));
			document.add(new Paragraph(
					"Terapiagatik ordaindu beharko du .............XXXX.XX"));
			document.add(new Paragraph("Master Sinadura & Idazkaria"
					+ "\t \t \t \t \t" + "Bezero Sinadura"));

			document.close();
			file.close();

			gordeAgiriZbk();
		} catch (Exception e) {

			e.printStackTrace();
		}
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K5 = "UPDATE Hitzordua SET Kobratuta=1 WHERE dataOrdua='" + data + "' AND bezeroID = '" + bezeroa + "'";
		dbk.execSQL(K5);
	}

	private void gordeAgiriZbk() {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "UPDATE AgiriZbk SET zenbakia='" + agiriZbk
				+ "' WHERE gakoa= 1 ";
		dbk.execSQL(K1);
		
	}

}