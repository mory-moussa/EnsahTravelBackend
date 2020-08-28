package com.ensah.reservation.request;

import javax.validation.constraints.NotBlank;

public class VolRequest {
	@NotBlank
	private String ville_depart;

	@NotBlank
	private String ville_arrivee;

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
	
	
}
