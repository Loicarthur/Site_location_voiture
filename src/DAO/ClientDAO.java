package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.ConnexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;

public class ClientDAO {
	
	public static int save(Client et) throws SQLException {
		Connection com=ConnexionDB.connect();
		PreparedStatement stat = null;
		int valeur=0;
		try {
			String sql = "INSERT INTO client (mail, nom, telephone) "
					+ "VALUES (?,?,?)";
			stat = com.prepareStatement(sql);
			stat.setString(1, et.getMail());
			stat.setString(2, et.getNom());
			stat.setInt(3, et.getTel());
			valeur = stat.executeUpdate();
			com.close();
	    }
	    catch(SQLException e) {
	    }
		return valeur;
	}
	
	public static ObservableList<Client> rechercher(String cle) throws SQLException {
		Connection com=ConnexionDB.connect();
		ObservableList<Client> item = FXCollections.observableArrayList();
		PreparedStatement stat = null;
		try {
			String sql = "select * from client where (mail or nom) = ?";
			stat = com.prepareStatement(sql);
			ResultSet rs = null;
			rs = stat.executeQuery();
			while(rs.next()) {
				Client u = new Client();
				u.setMail(rs.getString(1));
				u.setNom(rs.getString(2));
				u.setTel(rs.getInt(3));
				u.setPoint(rs.getInt(4));
				item.add(u);
			}
	    }
	    catch(SQLException e) {
	    }
		return item;
	}
	
	public static int delete(Client et) throws SQLException {
		Connection com=ConnexionDB.connect();
		PreparedStatement stat = null;
		int valeur=0;
		try {
			String sql = "delete * from client where mail = ?";
			stat = com.prepareStatement(sql);
			stat.setString(1, et.getMail());
			valeur = stat.executeUpdate();
			com.close();
	    }
	    catch(SQLException e) {
	    }
		return valeur;
	}
	
	

}
