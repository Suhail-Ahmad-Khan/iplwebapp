import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ContentByteUtils;
import com.itextpdf.text.pdf.parser.LineSegment;
import com.itextpdf.text.pdf.parser.PdfContentStreamProcessor;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class ParsingHelloWorld {

	public static void main(String[] args) throws IOException {

		String filename = "/home/bridgeit/Downloads/pdf-sample.pdf";
		String newFileName = "/home/bridgeit/Downloads/hello-new.txt";
		extractText(filename, newFileName);
		System.out.println("Data is extracted!");		

	}

	public static void extractText(String filename, String newFileName) throws IOException {
		PrintWriter out = new PrintWriter(new FileOutputStream(newFileName));
		PdfReader reader = new PdfReader(filename);
		RenderListener listener = new MyTextRenderListener(out);
		PdfContentStreamProcessor processor = new PdfContentStreamProcessor(listener);
		PdfDictionary pageDic = reader.getPageN(1);
		PdfDictionary resourcesDic = pageDic.getAsDict(PdfName.RESOURCES);
		processor.processContent(ContentByteUtils.getContentBytesForPage(reader, 1), resourcesDic);
		out.flush();
		out.close();
	}
	
	public static void renderText(TextRenderInfo renderInfo)
	{
		LineSegment baseline = renderInfo.getBaseline();
		float x = baseline.getStartPoint().get(0);
		float y = baseline.getStartPoint().get(1);
		float w = baseline.getLength();
		String text = renderInfo.getText();
		System.out.println(x + "   " + y + "   "  + w);
		System.out.println(text);
		
	}

}
