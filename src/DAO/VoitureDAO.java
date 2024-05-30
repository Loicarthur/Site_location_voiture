package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.ConnexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vehicule;
import model.VoitureAchete;
import model.VoitureLouer;

public class VoitureDAO {

	public static int saveVehicule(Vehicule Vh) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		int valeur = 0;
		try {
			String sql = "INSERT INTO voiture(id,marque,model,prix,detail,categorie) values(?,?,?,?,?,?)";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, Vh.getId());
			Stat.setString(2, Vh.getMarque());
			Stat.setString(3, Vh.getModel());
			Stat.setDouble(4, Vh.getPrix());
			Stat.setString(5, Vh.getDetails());
			Stat.setString(6, Vh.getCategorie());
			valeur = Stat.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}
		return valeur;
	}

	public static int acheterVehicule(VoitureAchete Vh) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		int valeur = 0;
		try {
			String sql = "INSERT INTO voitureacheter(id,dateAchat,reglement,numero,mail,voiture) values(?,?,?,?,?,?)";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, Vh.getId());
			Stat.setDate(2, Vh.getDateAchat());
			Stat.setString(3, Vh.getReglement());
			Stat.setInt(4, Vh.getNumero());
			Stat.setString(5, Vh.getMail());
			Stat.setString(6, Vh.getVoiture());
			valeur = Stat.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}
		return valeur;
	}

	public static int louerVehicule(VoitureLouer Vh) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		int valeur = 0;
		try {
			String sql = "INSERT INTO voiturelouer(id,dateDebut,dateFin,reglement,numero,mail,voiture) values(?,?,?,?,?,?,?)";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, Vh.getId());
			Stat.setDate(2, Vh.getDateDebut());
			Stat.setDate(3, Vh.getDateFin());
			Stat.setString(4, Vh.getReglement());
			Stat.setInt(5, Vh.getNumero());
			Stat.setString(6, Vh.getMail());
			Stat.setString(7, Vh.getVoiture());
			valeur = Stat.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}
		return valeur;
	}

	public static int delete1(VoitureLouer Vh) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		int valeur = 0;
		try {
			String sql = "delete * from voiturelouer where id = ?";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, Vh.getId());
			con.close();
		} catch (SQLException e) {
		}
		return valeur;
	}

	public static int delete2(VoitureAchete Vh) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		int valeur = 0;
		try {
			String sql = "delete * from voitureacheter where id = ?";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, Vh.getId());
			con.close();
		} catch (SQLException e) {
		}
		return valeur;
	}

	public static int delete3(Vehicule Vh) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		int valeur = 0;
		try {
			String sql = "delete * from voiture where id = ?";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, Vh.getId());
			con.close();
		} catch (SQLException e) {
		}
		return valeur;
	}

	public ObservableList<Vehicule> rechercher(String cle) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		ObservableList<Vehicule> item = FXCollections.observableArrayList();
		ResultSet rs = null;
		try {
			String sql = "select* from voiture where id=? or marque = ? or model = ?";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, cle);
			Stat.setString(2, cle);
			Stat.setString(3, cle);
			rs = Stat.executeQuery();
			if (rs.next()) {
				while (rs.next()) {
					Vehicule vh = new Vehicule();
					vh.setId(rs.getString(1));
					vh.setMarque(rs.getString(2));
					vh.setModel(rs.getString(3));
					vh.setPrix(rs.getInt(4));
					vh.setDetails(rs.getString(5));
					vh.setCategorie(rs.getString(6));
					vh.setPhoto(rs.getString(7));
					item.add(vh);
				}
			}
			con.close();
		} catch (SQLException e) {
		}
		return item;
	}

	public ObservableList<VoitureAchete> rechercherAchat(String cle) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		PreparedStatement Stat2 = null;
		ObservableList<VoitureAchete> item = FXCollections.observableArrayList();
		ResultSet rs = null;
		try {
			String sql = "select* from voitureacheter where id=? or marque = ? or model = ?";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, cle);
			Stat.setString(2, cle);
			Stat.setString(3, cle);
			rs = Stat.executeQuery();
			while (rs.next()) {
				VoitureAchete vh = new VoitureAchete();
				vh.setId(rs.getString(1));
				vh.setDateAchat(rs.getDate(2));
				vh.setReglement(rs.getString(3));
				vh.setNumero(rs.getInt(4));
				vh.setMail(rs.getString(5));
				vh.setVoiture(rs.getString(6));
				String sql2 = "select * from voiture where id = ?";
				Stat2 = con.prepareStatement(sql2);
				ResultSet rs1 = null;
				Stat2.setString(1, vh.getVoiture());
				rs1 = Stat2.executeQuery();
				if (rs1.next()) {
					vh.setMarque(rs1.getString(2));
					vh.setModel(rs1.getString(3));
					vh.setPrix(rs1.getInt(4));
					vh.setDetails(rs1.getString(5));
					vh.setCategorie(rs1.getString(6));
					vh.setPhoto(rs1.getString(7));
				}
			}
			con.close();
		} catch (SQLException e) {
		}
		return item;
	}
	
	public ObservableList<VoitureLouer> rechercherLocation(String cle) throws SQLException {
		Connection con = ConnexionDB.connect();
		PreparedStatement Stat = null;
		PreparedStatement Stat2 = null;
		ObservableList<VoitureLouer> item = FXCollections.observableArrayList();
		ResultSet rs = null;
		try {
			String sql = "select* from voiturelouer where id=? or marque = ? or model = ?";
			Stat = con.prepareStatement(sql);
			Stat.setString(1, cle);
			Stat.setString(2, cle);
			Stat.setString(3, cle);
			rs = Stat.executeQuery();
			while (rs.next()) {
				VoitureLouer vh = new VoitureLouer();
				vh.setId(rs.getString(1));
				vh.setDateDebut(rs.getDate(2));
				vh.setDateFin(rs.getDate(3));
				vh.setReglement(rs.getString(4));
				vh.setNumero(rs.getInt(5));
				vh.setMail(rs.getString(6));
				vh.setVoiture(rs.getString(7));
				String sql2 = "select * from voiture where id = ?";
				Stat2 = con.prepareStatement(sql2);
				ResultSet rs1 = null;
				Stat2.setString(1, vh.getVoiture());
				rs1 = Stat2.executeQuery();
				if (rs1.next()) {
					vh.setMarque(rs1.getString(2));
					vh.setModel(rs1.getString(3));
					vh.setPrix(rs1.getInt(4));
					vh.setDetails(rs1.getString(5));
					vh.setCategorie(rs1.getString(6));
					vh.setPhoto(rs1.getString(7));
				}
			}
			con.close();
		} catch (SQLException e) {
		}
		return item;
	}
}
