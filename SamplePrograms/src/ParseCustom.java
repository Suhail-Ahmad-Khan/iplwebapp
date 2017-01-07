import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LineSegment;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class ParseCustom {

	/*
	 * public static final String SRC =
	 * "/home/bridgeit/Downloads/pdf-sample.pdf";
	 */

	class FontRenderFilter extends RenderFilter {
		public boolean allowText(TextRenderInfo renderInfo) {

			LineSegment baseline = renderInfo.getBaseline();
			float x = baseline.getStartPoint().get(0);
			float y = baseline.getStartPoint().get(1);
			float w = baseline.getLength();
			String text = renderInfo.getText();
			System.out.println(x + "   " + y + "   " + w);
			System.out.println(text);
			String font = renderInfo.getFont().getPostscriptFontName();
			return font.endsWith("Bold") || font.endsWith("Oblique");
		}
	}

	public static void main(String[] args) throws IOException, DocumentException {
		String filename = "/home/bridgeit/Downloads/pdf-sample.pdf";
		String newFileName = "/home/bridgeit/Downloads/hello-new.txt";
		extractText(filename, newFileName);
		System.out.println("Done");
	}

	/*
	 * public void parse(String filename) throws IOException { PdfReader reader
	 * = new PdfReader(filename); Rectangle rect = new Rectangle(36, 50, 559,
	 * 806); RenderFilter regionFilter = new RegionTextRenderFilter(rect);
	 * FontRenderFilter fontFilter = new FontRenderFilter();
	 * 
	 * TextExtractionStrategy strategy = new FilteredTextRenderListener(new
	 * LocationTextExtractionStrategy(), regionFilter, fontFilter);
	 * 
	 * System.out.println(PdfTextExtractor.getTextFromPage(reader, 1,
	 * strategy)); reader.close(); }
	 */

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
