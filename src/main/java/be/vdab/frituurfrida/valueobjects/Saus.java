package be.vdab.frituurfrida.valueobjects;

import java.util.ArrayList;
import java.util.List; 

public class Saus {
	
	private long nummer;
	private String naam;
	private List<String> ingredienten = new ArrayList<>();
	
	public Saus() {
	}
	
	public Saus(long nummer, String naam) {
		this.nummer = nummer;
		this.naam = naam;
	}
	public Saus(long nummer, String naam, List<String> ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
		this.ingredienten.addAll(ingredienten);
	}
	public long getNummer() {
		return nummer;
	}
	public void setNummer(long nummer) {
		this.nummer = nummer;
	}
	public List<String> getIngredienten(){
		return ingredienten;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void addIngredienten(String ingredient) {
		ingredienten.add(ingredient);
	}


}
