package br.ufc.lps.repository.jpa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import br.ufc.lps.repository.FeatureModel;
import br.ufc.lps.util.JDBCConnection;

public class FeatureModelImp implements FeatureModel{
	
	public FeatureModelImp(){	
	}
	
	public FeatureModel getFeatureModelById(int id) {
		
		try {
			Connection con = (Connection) JDBCConnection.getConnection();
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

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
		return null;
	}

}
