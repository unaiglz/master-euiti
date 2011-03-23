package interfazeak;

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
	
	public static void main(String[] args) {
        try {
        	String dataOrdua=args[0];
        	String terapeutaID=args[1];
        	String bezeroID=args[2];
        	String terapiaMotaID=args[2];
        	OutputStream file = new FileOutputStream(new File("Agiria.pdf"));

            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("Gaur " + new Date().toString() + " " + bezeroID + " NANak duen bezeroak " +
            		dataOrdua + " " + terapiaMotaID  + " terpiagatik " + terapeutaID + " NANa duen terapeutarekin egin zuen" +
            				" terapia ordainduko du"));
            document.add(new Paragraph("Terapiagatik ordaindu beharko du ............."));
            document.add(new Paragraph("Idazkari Sinadura" + "                  " + "Bezero Sinadura"));	

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }}