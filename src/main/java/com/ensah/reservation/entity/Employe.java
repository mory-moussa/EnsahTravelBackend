package com.ensah.reservation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name="employe")
@EntityListeners(AuditingEntityListener.class)
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nom",nullable = false)
	private String nom;
	@Column(name = "prenom",nullable = false)
	private String prenom;
	@Column(name = "email",nullable = false)
	private String email;
	@Column(name = "imageUrl",nullable = false)
	private String imageUrl;
	@Column(name = "fonction",nullable = false)
	private String fonction;
	@Column(name = "password",nullable = false)
	private String password;
	@Column(name ="dateNaissance" ,nullable=false)
	private Date dateNaissance;
	 public Employe() {}
	public Employe(String nom, String prenom, String email,String fonction,Date date,String imageUrl,String password) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = date;
		this.imageUrl = imageUrl;
		this.password = password;
		this.fonction = fonction;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", imageUrl="
				+ imageUrl + ", fonction=" + fonction + ", password=" + password + ", dateNaissance=" + dateNaissance
				+ "]";
	}
	
	
}
