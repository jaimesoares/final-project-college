/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

class StreamGobbler extends Thread {

    InputStream is;
    String type;

    StreamGobbler(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(type + ">" + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

public class Backup {

    public static String gerarBackup() {

        String path = System.getProperty("user.dir") + "\\BancoDeDados";

        try {
            System.out.println(System.getProperty("os.name"));

            String[] cmd = new String[3];

            String mysql = "mysqldump";
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
             cmd[2] = mysql + " -u root -proot pizzaria -r \"" + path + "\\backup.sql\" " ;
            
           // cmd[2] = mysql + " -u root -proot pizzaria -r \"" + path + "\\backup.sql\"";
//                cmd[2] = mysql+" -u root -proot test cliente funcionario > \"C:\\Users\\Jaime\\Desktop\\Nova pasta\\testbackup.sql\"";

//            String mysql ="mysql";
//                cmd[0] = "cmd.exe" ;
//                cmd[1] = "/C" ;
//                cmd[2] = mysql+" -u root -proot test < \"C:\\Users\\Jaime\\Desktop\\Nova pasta\\testbackup.sql\"";
            //cmd[2] = mysql + " -u root -proot pizzaria < \"" + path + "\\backup.sql\"";
            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + cmd[0] + " " + cmd[1]
                    + " " + cmd[2]);
            Process proc = rt.exec(cmd);
            // any error message?
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");

            // any output?
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");

            // kick them off
            errorGobbler.start();
            outputGobbler.start();

            // any error???
            int exitVal = proc.waitFor();
            System.out.println("ExitValue: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
            return "Erro ao gerar Backup";
        }
        return "Backup gerado com sucesso em " + path;
    }

    public static void main(String args[]) {

        Backup.gerarBackup();
        
//        String exit;
//        while(true){
//            try {
//                String showInputDialog = JOptionPane.showInputDialog("test");
//                String execCommand = Backup.execCommand(showInputDialog);
//                JOptionPane.showMessageDialog(null, execCommand);
//            } catch (IOException ex) {
//                Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        

//        try {
//            System.out.println(System.getProperty("os.name"));
//
//            String[] cmd = new String[3];
//
//            String path = System.getProperty("user.dir") + "\\BancoDeDados";
//
//            String mysql = "mysqldump";
//            cmd[0] = "cmd.exe";
//            cmd[1] = "/C";
//            cmd[2] = mysql + " -u root -proot pizzaria > \"" + path + "\\backup.sql\"";
////                cmd[2] = mysql+" -u root -proot test cliente funcionario > \"C:\\Users\\Jaime\\Desktop\\Nova pasta\\testbackup.sql\"";
//
////            String mysql ="mysql";
////                cmd[0] = "cmd.exe" ;
////                cmd[1] = "/C" ;
////                cmd[2] = mysql+" -u root -proot test < \"C:\\Users\\Jaime\\Desktop\\Nova pasta\\testbackup.sql\"";
//           //cmd[2] = mysql + " -u root -proot pizzaria < \"" + path + "\\backup.sql\"";
//
//            Runtime rt = Runtime.getRuntime();
//            System.out.println("Execing " + cmd[0] + " " + cmd[1]
//                    + " " + cmd[2]);
//            Process proc = rt.exec(cmd);
//            // any error message?
//            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
//
//            // any output?
//            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");
//
//            // kick them off
//            errorGobbler.start();
//            outputGobbler.start();
//
//            // any error???
//            int exitVal = proc.waitFor();
//            System.out.println("ExitValue: " + exitVal);
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
    }
    
    
    
    public synchronized static String execCommand(final String commandLine) throws IOException {  
  
    boolean success = false;  
    String result;  
  
    Process p;  
    BufferedReader input;  
    StringBuffer cmdOut = new StringBuffer();  
    String lineOut = null;  
    int numberOfOutline = 0;  
  
    try {  
  
        p = Runtime.getRuntime().exec(commandLine);  
  
        input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
  
        while ((lineOut = input.readLine()) != null) {  
            if (numberOfOutline > 0) {  
                cmdOut.append("\n");  
            }  
            cmdOut.append(lineOut);  
            numberOfOutline++;  
        }  
  
        result = cmdOut.toString();  
  
        success = true;  
  
        input.close();  
          
    } catch (IOException e) {  
        result = String.format("Falha ao executar comando %s. Erro: %s", commandLine, e.toString());  
    }  
  
    // Se não executou com sucesso, lança a falha  
    if (!success) {  
        throw new IOException(result);  
    }  
  
    return result;  
  
}  
    
}
