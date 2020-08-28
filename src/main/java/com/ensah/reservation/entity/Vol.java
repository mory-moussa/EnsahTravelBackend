package com.ensah.reservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "vols", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "nVol")
		})
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String nVol; 
	
	@NotBlank
	@Size(max = 20)
	private String ville_depart; 
	
	@NotBlank
	@Size(max = 20)
	private String ville_arrivee; 
	
	@NotBlank
	@Size(max = 20)
	private String compagnie; 
	
	@NotBlank
	@Size(max = 20)
	private String heure_depart; 
	
	@NotBlank
	@Size(max = 20)
	private float  prix; 
	
	@NotBlank
	@Size(max = 20)
	private int place; 
	
	
	public Vol() {
		// TODO Auto-generated constructor stub
	}


	public Vol(@NotBlank @Size(max = 20) String nVol, @NotBlank @Size(max = 20) String ville_depart,
			@NotBlank @Size(max = 20) String ville_arrivee, @NotBlank @Size(max = 20) String compagnie,
			@NotBlank @Size(max = 20) String heure_depart, @NotBlank @Size(max = 20) float prix,
			@NotBlank @Size(max = 20) int place) {
		super();
		this.nVol = nVol;
		this.ville_depart = ville_depart;
		this.ville_arrivee = ville_arrivee;
		this.compagnie = compagnie;
		this.heure_depart = heure_depart;
		this.prix = prix;
		this.place = place;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getnVol() {
		return nVol;
	}


	public void setnVol(String nVol) {
		this.nVol = nVol;
	}


	public String getVille_depart() {
		return ville_depart;
	}


	public void setVille_depart(String ville_depart) {
		this.ville_depart = ville_depart;
	}


	public String getVille_arrivee() {
		return ville_arrivee;
	}


	public void setVille_arrivee(String ville_arrivee) {
		this.ville_arrivee = ville_arrivee;
	}


	public String getCompagnie() {
		return compagnie;
	}


	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}


	public String getHeure_depart() {
		return heure_depart;
	}


	public void setHeure_depart(String heure_depart) {
		this.heure_depart = heure_depart;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public int getPlace() {
		return place;
	}


	public void setPlace(int place) {
		this.place = place;
	}
	
	

}
