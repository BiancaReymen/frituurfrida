package be.vdab.frituurfrida.valueobjects;

public class Gemeente {

	private String naam;
	private int postCode;
	
	
	public Gemeente(String naam, int postCode) {
		this.naam = naam;
		this.postCode = postCode;
	}
	public Gemeente() {
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	
	
	
}
