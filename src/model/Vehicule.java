package model;

public class Vehicule {
	
	private String marque;
	private String id;
	private String model;
	private double prix;
	private String details;
	private String categorie;
	private String photo;
	
	public Vehicule() {
		super();
		this.marque = null;
		this.id = null;
		this.model = null;
		this.prix = 0;
		this.details = null;
		this.categorie = null;
		this.photo = null;
	}
	
	public Vehicule(String marque, String id, String model, double prix, String details, String categorie,
			String photo) {
		super();
		this.marque = marque;
		this.id = id;
		this.model = model;
		this.prix = prix;
		this.details = details;
		this.categorie = categorie;
		this.photo = photo;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

}
