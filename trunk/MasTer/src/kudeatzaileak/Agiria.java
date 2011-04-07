package kudeatzaileak;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//String dataOrdua, String terapeutaID, String bezeroID, String terapiaMotaID

public class Agiria {
	public Agiria(String data, String terapeuta, String bezeroa,
			String terapiaMota) {
		String dataOrdua = data;
		String terapeutaID = terapeuta;
		String bezeroID = bezeroa;
		String terapiaMotaID = terapiaMota;
		SortuPdf(dataOrdua, terapeutaID, bezeroID, terapiaMotaID);
	}

	public static void SortuPdf(String data, String terapeuta, String bezeroa,
			String terapiaMota) {
		try {

			OutputStream file = new FileOutputStream(new File("Agiria.pdf"));

			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("Gaur, " + new Date().toString() + " "
					+ bezeroa + " \n NANak duen bezeroak " + data + " "
					+ terapiaMota + " terapiagatik " + terapeuta
					+ " NANa duen terapeutarekin egin zuen"
					+ " terapia ordainduko du"));
			document.add(new Paragraph(
					"Terapiagatik ordaindu beharko du ............."));
			document.add(new Paragraph("Idazkari Sinadura"
					+ "                  " + "Bezero Sinadura"));

			document.close();
			file.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}