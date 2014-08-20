/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pizzaria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author katia
 */
public class ConectaBanco {
    public static Connection getConexão(){
        try{
            
            Connection con;
            
            String serverName = "localhost";
            String mydatabase = "projeto";
            String userName = "root";
            String password = "";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String url = "jdbc:mysql://"+serverName+"/"+mydatabase;
            con = DriverManager.getConnection(url, userName, password);
            return con;       
        }catch(ClassNotFoundException e){
           System.out.println("Driver não encontrado");
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao banco");
        }
        return null;
    }
    
}
