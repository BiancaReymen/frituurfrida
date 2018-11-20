package be.vdab.frituurfrida.entities;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class GastenboekEntry {

	private long id;
	@NotBlank
	private String naam;
	@NotNull @DateTimeFormat(style = "S-")
	private LocalDateTime datumtijd = LocalDateTime.now();
	@NotBlank
	private String bericht;
	
	
	
	public GastenboekEntry() {
		super();
	}

	public GastenboekEntry(long id, @NotBlank String naam, @NotNull LocalDateTime datumtijd, @NotBlank String bericht) {
		super();
		this.id = id;
		this.naam = naam;
		this.datumtijd = datumtijd;
		this.bericht = bericht;
	}

	public GastenboekEntry(@NotBlank String naam, @NotNull LocalDateTime datumtijd, @NotBlank String bericht) {
		super();
		this.naam = naam;
		this.datumtijd = datumtijd;
		this.bericht = bericht;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public LocalDateTime getDatumtijd() {
		return datumtijd;
	}

	public String getBericht() {
		return bericht;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setBericht(String bericht) {
		this.bericht = bericht;
	}

		
}
