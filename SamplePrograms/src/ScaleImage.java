import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ScaleImage {

	public static void main(String[] args) throws IOException, DocumentException {

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("/home/bridgeit/Downloads/sample1.pdf"));
		document.open();
		document.add(new Paragraph("Sample 1: This is simple image demo."));
		Image img1 = Image.getInstance("/home/bridgeit/Downloads/wallpapers/bleach.jpg");
		img1.scaleAbsolute(100, 100);
		document.add(img1);
		Image img2 = Image.getInstance("/home/bridgeit/Downloads/wallpapers/bleach.jpg");
		img2.scaleToFit(200, 200);
		document.add(img2);
		document.close();
		System.out.println("Done");

	}

}
