package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connexion.ConnexionDB;
import modele.Chauffeur;


public class ChauffeurDAO {
	public static int saveChauffeur(Chauffeur Ch) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="INSERT INTO chauffeur(immatriculation,nom,prenom,telephone,immatVehicule) values(?,?,?,?,?)";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Ch.getImmatri());
			Stat.setString(2,Ch.getNom());
			Stat.setString(3,Ch.getPrenom());
			Stat.setLong(4,Ch.getTel());
			Stat.setString(5,Ch.getVéhiculeCond());
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){
		}
		return valeur;
	}
	
	public static int updateChauffeur(Chauffeur Ch) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="UPDATE chauffeur set immatriculation=? ,nom=? ,prenom=? ,telephone=? ,immatVehicule=?where immatriculation=?";
			Stat=con.prepareStatement(sql);
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Ch.getImmatri());
			Stat.setString(2,Ch.getNom());
			Stat.setString(3,Ch.getPrenom());
			Stat.setLong(4,Ch.getTel());
			Stat.setString(5,Ch.getVéhiculeCond());
			Stat.setString(6,Ch.getImmatri());
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){
		}
		return valeur;
	}
	
	public static int deleteChauffeur (String immatri) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="select* from chauffeur where immatriculation=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,immatri);
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){	
		}
			return valeur;		
		}
	
	public static Chauffeur rechercherChauffeur (String immatri) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		Chauffeur Ch= new Chauffeur();
		ResultSet rs=null;
		try {
			String sql="select* from chauffeur where immatriculation=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,immatri);
			rs=Stat.executeQuery();
			if(rs.next()){
				Ch.setImmatri(rs.getString(1));
				Ch.setNom(rs.getString(2));
				Ch.setPrenom(rs.getString(3));
				Ch.setTel(rs.getInt(4));
				Ch.setVéhiculeCond(rs.getString(5));
			}
			con.close();
			}
		catch(SQLException e){
			}
			return Ch;		
		}
}
