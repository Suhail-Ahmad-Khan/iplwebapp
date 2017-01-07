import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class ParsePDF {

	public static void main(String[] args) throws IOException {

		String filename = "/home/bridgeit/Downloads/pdf-sample.pdf";
		String newFileName = "/home/bridgeit/Downloads/hello-new.txt";
		extractText(filename, newFileName);
		System.out.println("Data is extracted!");
	}

	public static void extractText(String filename, String newFileName) throws IOException {
		PdfReader reader = new PdfReader(filename);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		PrintWriter out = new PrintWriter(new FileOutputStream(newFileName));
		TextExtractionStrategy strategy;
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			out.println(strategy.getResultantText());
		}
		out.flush();
		out.close();
	}

}
