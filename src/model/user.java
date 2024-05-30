package model;

public class user extends Personne {

	private String photo;
	private String type;

	public user(String mail, String nom, int tel, String password, String photo, String type) {
		super(mail, nom, tel, password);
		this.photo = photo;
		this.type = type;
	}

	public user() {
		super();
		this.photo = null;
		this.type=null;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
