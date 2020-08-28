package com.ensah.reservation.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="reservation")
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "compagnie",nullable = false)
	private String compagnie;
	@Column(name = "depart",nullable = false)
	private String depart;
	@Column(name = "prix",nullable = false)
	private int  prix;
	@Column(name = "place",nullable = false)
	private String place;
	@Column(name = "villeDepart",nullable = false)
	private String villeDepart;
	@Column(name = "villeArrivee",nullable = false)
	private String villeArrivee;
	@Column(name = "date",nullable = false)
	private String date;
	@Column(name = "nom",nullable = false)
	private String nom;
	@Column(name = "email",nullable = false)
	private String email;
	@Column(name = "mobile",nullable = false)
	private String mobile;
	
	public Reservation() {
	}
	public Reservation(
			String compagnie, 
			String depart,
			int prix, 
			String place,
			String villeDepart,
			String villeArrivee, 
			String date, 
			String nom, 
			String email, 
			String mobile) {
		super();
		this.compagnie = compagnie;
		this.depart = depart;
		this.prix = prix;
		this.place = place;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.date = date;
		this.nom = nom;
		this.email = email;
		this.mobile = mobile;
	}
	
	public Long getId() {
		return id;
	}

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", compagnie=" + compagnie + ", depart=" + depart + ", prix=" + prix
				+ ", place=" + place + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + ", date="
				+ date + ", nom=" + nom + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
}