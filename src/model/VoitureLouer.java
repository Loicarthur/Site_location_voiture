package model;

import java.sql.Date;

public class VoitureLouer extends Vehicule{
	
	

	public VoitureLouer() {
		super();
		this.dateDebut = null;
		this.dateFin = null;
		this.reglement = null;
		this.numero = 0;
		this.mail = null;
		this.voiture = null;
	}
	
	public VoitureLouer(String marque, String id, String model, double prix, String details, String categorie,
			String photo, Date dateDebut, Date dateFin, String reglement, int numero, String mail, String voiture) {
		super(marque, id, model, prix, details, categorie, photo);
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.reglement = reglement;
		this.numero = numero;
		this.mail = mail;
		this.voiture = voiture;
	}

	private Date dateDebut;
	private Date dateFin;
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

	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
