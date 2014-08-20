package br.com.pizzaria.util;

public class VerificadoresECorretores {

    public static String converteParaSql(String data) {

        return data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
    }

    public static String converteParaJAVA(String data) {

        return data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
    }
}
