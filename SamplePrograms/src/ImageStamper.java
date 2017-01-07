import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ImageStamper {

	public static void main(String[] args) {

		try {
			PdfReader pdfReader = new PdfReader("/home/bridgeit/Downloads/ProgrammingProjects.pdf");

			PdfStamper pdfStamper = new PdfStamper(pdfReader,
					new FileOutputStream("/home/bridgeit/Downloads/ProgrammingProjects-Stamped.pdf"));

			Image image = Image.getInstance("/home/bridgeit/Downloads/wallpapers/ferrari.jpg");
			image.scaleToFit(100, 100);

			for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {

				if (i == 5 || i == 8) {

					PdfContentByte content = pdfStamper.getOverContent(i);
					image.setAbsolutePosition(400f, 400f);
					content.addImage(image);
					PdfContentByte content1 = pdfStamper.getOverContent(i);
					image.setAbsolutePosition(100f, 100f);
					content1.addImage(image);
				} else
					continue;
			}

			pdfStamper.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}

}
