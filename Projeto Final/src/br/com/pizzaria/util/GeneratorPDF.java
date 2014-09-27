/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.List;

public class GeneratorPDF {

    public static String gerarPDF(List<String> conteudo) {
        String path = "C:\\Users\\Jaime\\Desktop";
// criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(path + "\\Cupom " + VerificarData.converteParaSql(VerificarData.retornoDeDataAtual()) + ".pdf"));
            document.open();

            for (String string : conteudo) {
                // adicionando um parágrafo no documento
                document.add(new Paragraph(string));
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
