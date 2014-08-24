package br.com.pizzaria.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerificadoresECorretores {

    public static String converteParaSql(String data) {

        return data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
    }

    public static String converteParaJAVA(String data) {

        return data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
    }

    public static String retornoDeDataAtual() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();

        return formatoData.format(dataAtual);
    }
}
