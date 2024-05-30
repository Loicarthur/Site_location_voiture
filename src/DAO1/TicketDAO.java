package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connexion.ConnexionDB;
import modele.Client;


public class TicketDAO {

	public static int saveClient(Client Cl) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="INSERT INTO enregistrementclient(num_ticket,nom,prenom,cni,telephone,destination,prix_ticket,nbre_places,nbre_bagage,dateenregistrement) values(?,?,?,?,?,?,?,?,?,?)";
			Stat=con.prepareStatement(sql);
			Stat.setInt(1,Cl.getNum_ticket());
			Stat.setString(2,Cl.getNom());
			Stat.setString(3,Cl.getPrenom());
			Stat.setString(4,Cl.getCni());
			Stat.setLong(5,Cl.getTel());
			Stat.setString(6,Cl.getDestination());
			Stat.setLong(7,Cl.getPrix_ticket());
			Stat.setInt(8,Cl.getNbrePlace());
			Stat.setInt(9,Cl.getNbreBagage());
			Stat.setString(10,Cl.getDateEn());
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){
		}
		return valeur;
	}
	
	public static int updateClient(Client Cl) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="Update enregistrementclient set num_ticket=?, nom=?, prenom=? ,cni=? ,telephone=? ,destination=? ,prix_ticket=? ,nbre_places=? ,nbre_bagage=? ,dateenregistrement=? where num_ticket=?";
			Stat=con.prepareStatement(sql);
			Stat.setInt(1,Cl.getNum_ticket());
			Stat.setString(2,Cl.getNom());
			Stat.setString(3,Cl.getPrenom());
			Stat.setString(4,Cl.getCni());
			Stat.setLong(5,Cl.getTel());
			Stat.setString(6,Cl.getDestination());
			Stat.setLong(7,Cl.getPrix_ticket());
			Stat.setInt(8,Cl.getNbrePlace());
			Stat.setInt(9,Cl.getNbreBagage());
			Stat.setString(10,Cl.getDateEn());
			Stat.setInt(11,Cl.getNum_ticket());
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){
		}
		return valeur;
	}
	
	public static int deleteClient (int num_ticket) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="delete from enregistrementclient where num_ticket=?";
			Stat=con.prepareStatement(sql);
			Stat.setInt(1,num_ticket);
			valeur=Stat.executeUpdate();
			con.close();
		}
		catch(SQLException e){	
		}
			return valeur;		
		}
	
	public static Client rechercherClient (int num_ticket) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		Client Cl= new Client();
		ResultSet rs=null;
		try {
			String sql="select* from enregistrementclient where num_ticket=?";
			Stat=con.prepareStatement(sql);
			Stat.setInt(1,num_ticket);
			rs=Stat.executeQuery();
			if(rs.next()){
				Cl.setNum_ticket(rs.getInt(1));
				Cl.setNom(rs.getString(2));
				Cl.setPrenom(rs.getString(3));
				Cl.setCni(rs.getString(4));
				Cl.setTel(rs.getInt(5));
				Cl.setDestination(rs.getString(6));
				Cl.setPrix_ticket(rs.getInt(7));
				Cl.setNbrePlace(rs.getInt(8));
				Cl.setNbreBagage(rs.getInt(9));
				Cl.setDateEn(rs.getString(10));
			}
			con.close();
			}
		catch(SQLException e){
			}
			return Cl;		
		}
	
}
