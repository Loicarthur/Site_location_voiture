package model;

import java.sql.Date;

public class VoitureAchete extends Vehicule{
	
	

	public VoitureAchete() {
		super();
		this.dateAchat = null;
		this.reglement = null;
		this.numero = 0;
		this.mail = null;
		this.voiture = null;
	}
	public VoitureAchete(String marque, String id, String model, double prix, String details, String categorie,
			String photo, Date dateAchat, String reglement, int numero, String mail, String voiture) {
		super(marque, id, model, prix, details, categorie, photo);
		this.dateAchat = dateAchat;
		this.reglement = reglement;
		this.numero = numero;
		this.mail = mail;
		this.voiture = voiture;
	}
	
	private Date dateAchat;
	private String reglement;
	private int numero;
	private String mail;
	private String voiture;
	
	
	public String getVoiture() {
		return voiture;
	}
	public void setVoiture(String voiture) {
		this.voiture = voiture;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public String getReglement() {
		return reglement;
	}
	public void setReglement(String reglement) {
		this.reglement = reglement;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
