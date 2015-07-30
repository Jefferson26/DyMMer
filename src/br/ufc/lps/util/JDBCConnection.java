package br.ufc.lps.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection con;

	public static void main(String[] argv) {
		try {
			connectionQuery();

			PreparedStatement statement = con.prepareStatement("SELECT * FROM dymmer.constraint");/*
												 * write query inside of
												 * prepared statement
												 */
			ResultSet result = statement.executeQuery();
			System.out.println("DataBase table accessed");

			while (result.next()) {
				String retrievedid = result.getString("clause");

				System.out.println(retrievedid);
			}

			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
	}

	public static void connectionQuery() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dymmer", "root", "mysql");
			System.out.println("Remote DB connection established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Remote db connection establishment error");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("False query");
		}
	}
	
	public static Connection getConnection(){
		return con;
	}
}