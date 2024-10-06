package com.cibertec.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String database = "db_examen";
	private static String host = "localhost";
	private static String port = "3306";
	
	private static String url = "jdbc:mysql://" + host + ":" + port + "/" 
	                             + database + "?characterEncoding=latin1";
	private static String user = "cibertec";
	private static String password = "Admin123.";
	
	public Connection conectarMySql() {
		Connection conexion = null;
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, password);
			System.out.println("Se conectó a la base de datos.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error conectar Base de Datos: " + e.getMessage());
		}
		return conexion;
	}
}
