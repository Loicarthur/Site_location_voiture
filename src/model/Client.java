package model;

public class Client extends Personne{
	public Client(String mail, String nom, int tel, String password) {
		super(mail, nom, tel, password);
		// TODO Auto-generated constructor stub
	}
	public Client() {
		// TODO Auto-generated constructor stub
		this.point = 0;
	}
	private int point;
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	

}
