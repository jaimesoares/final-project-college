/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class FontFactoryExample {

    /**
     * The resulting PDF file.
     */
    public static final String RESULT
            = "J:\\Documentos\\Faculdade\\Cupom " + VerificarData.converteParaSql(VerificarData.retornoDeDataAtual()) + ".pdf";

    /**
     * Creates a PDF document.
     *
     * @param filename the path to the new PDF document
     * @throws DocumentException
     * @throws IOException
     * @throws DocumentException
     * @throws IOException
     */
    public void createPdf(String filename) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4:
        Font font = FontFactory.getFont("Times-Roman");
        document.add(new Paragraph("Times-Roman", font));
        Font fontbold = FontFactory.getFont("Times-Roman", 12, Font.BOLD);
        document.add(new Paragraph("Times-Roman, Bold", fontbold));
        document.add(Chunk.NEWLINE);
        FontFactory.register("c:/windows/fonts/garabd.ttf", "my_bold_font");
        Font myBoldFont = FontFactory.getFont("my_bold_font");
        BaseFont bf = myBoldFont.getBaseFont();
        document.add(new Paragraph(bf.getPostscriptFontName(), myBoldFont));
        String[][] name = bf.getFullFontName();
        for (int i = 0; i < name.length; i++) {
            document.add(new Paragraph(name[i][3] + " (" + name[i][0]
                    + "; " + name[i][1] + "; " + name[i][2] + ")"));
        }
        Font myBoldFont2 = FontFactory.getFont("Garamond vet");
        document.add(new Paragraph("Garamond Vet", myBoldFont2));
        document.add(Chunk.NEWLINE);
        document.add(new Paragraph("Registered fonts:"));
        FontFactory.registerDirectory("resources/fonts");
        for (String f : FontFactory.getRegisteredFonts()) {
            document.add(new Paragraph(f, FontFactory.getFont(f, "", BaseFont.EMBEDDED)));
        }
        document.add(Chunk.NEWLINE);
//        Font cmr10 = FontFactory.getFont("cmr10");
//        cmr10.getBaseFont().setPostscriptFontName("Computer Modern Regular");
        Font computerModern = FontFactory.getFont("Computer Modern Regular", "", BaseFont.EMBEDDED);
        document.add(new Paragraph("Computer Modern", computerModern));
        document.add(Chunk.NEWLINE);
        FontFactory.registerDirectories();
        for (String f : FontFactory.getRegisteredFamilies()) {
            document.add(new Paragraph(f));
        }
        document.add(Chunk.NEWLINE);
        Font garamond = FontFactory.getFont("garamond", BaseFont.WINANSI, BaseFont.EMBEDDED);
        document.add(new Paragraph("Garamond", garamond));
        Font garamondItalic
                = FontFactory.getFont("Garamond", BaseFont.WINANSI, BaseFont.EMBEDDED, 12, Font.ITALIC);
        document.add(new Paragraph("Garamond-Italic", garamondItalic));
        // step 5
        document.close();
    }

    /**
     * Main method.
     *
     * @param args no arguments needed
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, DocumentException {
        new FontFactoryExample().createPdf(RESULT);
    }
}
