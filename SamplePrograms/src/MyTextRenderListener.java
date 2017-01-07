import java.io.PrintWriter;

import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class MyTextRenderListener implements RenderListener {

	protected PrintWriter out;

	public MyTextRenderListener(PrintWriter out) {
		this.out = out;
	}

	public void beginTextBlock() {
		out.print("<");
	}

	public void endTextBlock() {
		out.println(">");
	}

	public void renderText(TextRenderInfo renderInfo) {
		out.print("<");
		out.print(renderInfo.getText());
		out.print(">");
	}

	@Override
	public void renderImage(ImageRenderInfo arg0) {
		// TODO Auto-generated method stub

	}

}
