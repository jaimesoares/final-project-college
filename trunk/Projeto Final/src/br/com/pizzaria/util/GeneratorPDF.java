/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneratorPDF {

    public static String gerarPDF(List<String> conteudo) {
        Date data = new Date();        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH-mm-ss");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        String path = "C:\\Users\\Jaime\\Desktop";
        Font fontNormal = FontFactory.getFont(FontFactory.COURIER, 10,Font.NORMAL, BaseColor.BLACK);
// criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(path + "\\Cupom_" + formatoData.format(data) +"_"+formatoHora.format(data)+ ".pdf"));
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
        return "Cupom gerado com sucesso em " + path;
    }

    public static void main(String[] args) {
        List<String> novo = new ArrayList<>();
        novo.add("------------------------------------------------------------");
        novo.add("--------------CUPOM NÃO FISCAL----------------");
        novo.add("Prod--------Qtd---------Valor Unt.------Valor Total");
        GeneratorPDF.gerarPDF(novo);
    }
}
