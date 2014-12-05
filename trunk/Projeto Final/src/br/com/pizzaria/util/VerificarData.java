package br.com.pizzaria.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class VerificarData {

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

    public static boolean verificaData(String data) {

        Long dia = new Long(data.substring(0, 2));
        Long mes = new Long(data.substring(3, 5));
        Long ano = new Long(data.substring(6, 10));

        try {

            GregorianCalendar dataCalendar = new GregorianCalendar();
            dataCalendar.setLenient(false);
            dataCalendar.set(GregorianCalendar.YEAR, ano.intValue());
            dataCalendar.set(GregorianCalendar.MONTH, mes.intValue() - 1);
            dataCalendar.set(GregorianCalendar.DATE, dia.intValue());

            dataCalendar.getTime();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
    
    public static String retornaHoraAtual(){
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date horaAtual = new Date();

        return formatoHora.format(horaAtual);
    }
    
    public static Date verificaDataDate(String data) {

        Long dia = new Long(data.substring(0, 2));
        Long mes = new Long(data.substring(3, 5));
        Long ano = new Long(data.substring(6, 10));

        try {

            GregorianCalendar dataCalendar = new GregorianCalendar();
            dataCalendar.setLenient(false);
            dataCalendar.set(GregorianCalendar.YEAR, ano.intValue());
            dataCalendar.set(GregorianCalendar.MONTH, mes.intValue()-1);
            dataCalendar.set(GregorianCalendar.DATE, dia.intValue());

            return dataCalendar.getTime();
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void main(String[] args) {
        Date verificaDataDate = VerificarData.verificaDataDate("28/02/2014");
        System.out.println(verificaDataDate);
    }

}
