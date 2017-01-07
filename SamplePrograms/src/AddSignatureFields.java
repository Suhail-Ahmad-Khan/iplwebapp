import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class AddSignatureFields {

	public static void createPDF(String filename) throws IOException, DocumentException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		document.add(new Paragraph("Hello World!"));

		PdfFormField field = PdfFormField.createSignature(writer);
		field.setWidget(new Rectangle(72, 732, 144, 780), PdfAnnotation.HIGHLIGHT_INVERT);
		field.setFieldName("mySig");
		field.setFlags(PdfAnnotation.FLAGS_PRINT);
		field.setPage();
		field.setMKBorderColor(BaseColor.BLACK);
		field.setMKBackgroundColor(BaseColor.WHITE);
		PdfAppearance tp = PdfAppearance.createAppearance(writer, 72, 48);
		tp.rectangle(0.5f, 0.5f, 71.5f, 47.5f);
		tp.stroke();
		field.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, tp);
		writer.addAnnotation(field);

		document.close();
	}

	public static void createSignature(String filename, String newFileName, String imagePath)
			throws IOException, DocumentException {

		/*
		 * PdfReader reader = new PdfReader(filename); FileOutputStream os = new
		 * FileOutputStream(newFileName); PdfStamper stamper =
		 * PdfStamper.createSignature(reader, os, '\0'); PdfSignatureAppearance
		 * appearance = stamper.getSignatureAppearance();
		 * appearance.setSignatureGraphic(Image.getInstance(imagePath));
		 * appearance.setVisibleSignature(new Rectangle(72, 732, 144, 780), 1,
		 * "first");
		 * appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.
		 * GRAPHIC); stamper.close();
		 */

		/*KeyStore ks = KeyStore.getInstance("pkcs12");
		String keystore_password = "mySignature";
		ks.load(new FileInputStream(filename), keystore_password.toCharArray());
		String alias = (String) ks.aliases().nextElement();

		String key_password = "open";
		PrivateKey pk = (PrivateKey) ks.getKey(alias, key_password.toCharArray());

		Certificate[] chain = ks.getCertificateChain(alias);
		PdfReader reader = new PdfReader(filename);
		PdfStamper stamper = PdfStamper.createSignature(reader, new FileOutputStream(newFileName), '\0');
		PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
		appearance.setVisibleSignature("mySig");
		appearance.setReason("It's personal.");
		appearance.setLocation("Foobar");
		appearance.setCrypto(pk, chain, null, PdfSignatureAppearance.WINCER_SIGNED);
		if (certified)
			appearance.setCertificationLevel(PdfSignatureAppearance.CERTIFIED_NO_CHANGES_ALLOWED);
		if (graphic) {
			appearance.setAcro6Layers(true);
			appearance.setSignatureGraphic(Image.getInstance(imagePath));
			appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
		}
		stamper.close();*/

	}

	public static void main(String[] args) throws IOException, DocumentException {

		String filename = "/home/bridgeit/Downloads/hello.pdf";
		String newFileName = "/home/bridgeit/Downloads/hello-new.pdf";
		String imagePath = "/home/bridgeit/Downloads/wallpapers/ferrari.jpg";
		createPDF(filename);
		System.out.println("File is Created");
		createSignature(filename, newFileName, imagePath);
		System.out.println("Image is added");

	}
}
