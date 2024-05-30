package model;

public abstract class Personne {
	
	protected String mail;
	protected String nom;
	protected int tel;
	protected String password;
	
	public Personne(String mail, String nom, int tel, String password) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.tel = tel;
		this.password = password;
	}

	public Personne() {
		this.mail = null;
		this.nom = null;
		this.tel = 0;
		this.password = null;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}
