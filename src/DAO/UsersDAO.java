package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.ConnexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.user;

public class UsersDAO {
		public static int save(user et) throws SQLException {
			Connection com=ConnexionDB.connect();
			PreparedStatement stat = null;
			int valeur=0;
			try {
				String sql = "INSERT INTO users (mail, nom, type, telephone, password, photo) "
						+ "VALUES (?,?,?,?,?,?)";
				stat = com.prepareStatement(sql);
				stat.setString(1, et.getMail());
				stat.setString(2, et.getNom());
				stat.setString(3, et.getType());
				stat.setInt(4, et.getTel());
				stat.setString(5, et.getPassword());
				stat.setString(6, et.getPhoto());
				valeur = stat.executeUpdate();
		    }
		    catch(SQLException e) {
		    }
			return valeur;
		}
		
		public static ObservableList<user> rechercher(String cle) throws SQLException {
			Connection com=ConnexionDB.connect();
			ObservableList<user> item = FXCollections.observableArrayList();
			PreparedStatement stat = null;
			try {
				String sql = "select * from users where (mail or nom) = ?";
				stat = com.prepareStatement(sql);
				ResultSet rs = null;
				rs = stat.executeQuery();
				while(rs.next()) {
					user u = new user();
					u.setMail(rs.getString(1));
					u.setNom(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setPhoto(rs.getString(4));
					u.setTel(rs.getInt(5));
					u.setType(rs.getString(6));
					item.add(u);
				}
		    }
		    catch(SQLException e) {
		    }
			return item;
		}
		
		public static int delete(user et) throws SQLException {
			Connection com=ConnexionDB.connect();
			PreparedStatement stat = null;
			int valeur=0;
			try {
				String sql = "delete * from users where mail = ?";
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
