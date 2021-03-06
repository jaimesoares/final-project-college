/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratorPDF {

    public static String gerarPDF(List<String> conteudo) {
        String caminho = "";
        Date data = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH-mm-ss");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        // String path = "C:\\Users\\Jaime\\Desktop";
        String path = System.getProperty("user.dir") + "\\Cupom";
        Font fontNormal = FontFactory.getFont(FontFactory.COURIER, 10, Font.NORMAL, BaseColor.BLACK);
// criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(path + "\\Cupom_" + formatoData.format(data) + "_" + formatoHora.format(data) + ".pdf"));
            caminho = path + "\\Cupom_" + formatoData.format(data) + "_" + formatoHora.format(data) + ".pdf";

            document.open();

            for (String string : conteudo) {
                // adicionando um parágrafo no documento
                document.add(new Paragraph(string, fontNormal));
            }

        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
            return "Erro ao gerar cupom";
        }
        document.close();

        abrirPdf(caminho);
        return "Cupom gerado com sucesso em " + path;

    }

    public static void abrirPdf(String caminho) {
        try {
            java.awt.Desktop.getDesktop().open(new File(caminho));
        } catch (IOException ex) {
            Logger.getLogger(GeneratorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        List<String> novo = new ArrayList<>();
        novo.add("------------------------------------------------------------");
        novo.add("--------------CUPOM NÃO FISCAL----------------");
        novo.add("Prod--------Qtd---------Valor Unt.------Valor Total");
        GeneratorPDF.gerarPDF(novo);
    }
}
