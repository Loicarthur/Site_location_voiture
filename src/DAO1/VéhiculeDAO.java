package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connexion.ConnexionDB;
import modele.Véhicule;


public class VéhiculeDAO {

	public static int saveVéhicule(Véhicule Vh) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="INSERT INTO véhicule(num_immat,num_veh,nbre_places,type_veh,itinéraire,date,heureD,heureA,immatChauf,etat) values(?,?,?,?,?,?,?,?,?,?)";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Vh.getNumImma());
			Stat.setInt(2,Vh.getNum_véh());
			Stat.setInt(3,Vh.getNbrePlace());
			Stat.setString(4,Vh.getTypeV());
			Stat.setString(5,Vh.getItin());
			Stat.setString(6,Vh.getDate());
			Stat.setString(7,Vh.getHeureD());
			Stat.setString(8,Vh.getHeureA());
			Stat.setString(9,Vh.getImmatChauf());
			Stat.setString(10,Vh.getEtat());
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){
		}
		return valeur;
	}
	
	public static int updateVéhicule(Véhicule Vh) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="UPDATE véhicule set num_immat=?, num_veh=?, nbre_places=?, type_veh=?, itinéraire=?, date=?, heureD=?, heureA=?, immatChauf=?, etat=? where num_immat=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Vh.getNumImma());
			Stat.setInt(2,Vh.getNum_véh());
			Stat.setInt(3,Vh.getNbrePlace());
			Stat.setString(4,Vh.getTypeV());
			Stat.setString(5,Vh.getItin());
			Stat.setString(6,Vh.getDate());
			Stat.setString(7,Vh.getHeureD());
			Stat.setString(8,Vh.getHeureA());
			Stat.setString(9,Vh.getImmatChauf());
			Stat.setString(10,Vh.getEtat());
			Stat.setString(11,Vh.getNumImma());
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){
		}
		return valeur;
	}
	
	public static int deleteVéhicule (int num_veh) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="select* from véhicule where num_veh=?";
			Stat=con.prepareStatement(sql);
			Stat.setInt(1,num_veh);
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){	
		}
			return valeur;		
		}
	
	public static Véhicule rechercherVéhicule (String numImma) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		Véhicule Vh= new Véhicule();
		ResultSet rs=null;
		try {
			String sql="select* from véhicule where num_immat=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,numImma);
			rs=Stat.executeQuery();
			if(rs.next()){
				Vh.setNumImma(rs.getString(1));
				Vh.setNum_véh(rs.getInt(2));
				Vh.setNbrePlace(rs.getInt(3));
				Vh.setTypeV(rs.getString(4));
				Vh.setItin(rs.getString(5));
				Vh.setDate(rs.getString(6));
				Vh.setHeureD(rs.getString(7));
				Vh.setHeureA(rs.getString(8));
				Vh.setImmatChauf(rs.getString(9));
				Vh.setEtat(rs.getString(10));
			}
			con.close();
			}
		catch(SQLException e){
			}
			return Vh;		
		}
	
}
