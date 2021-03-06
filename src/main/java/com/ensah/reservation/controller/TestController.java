package com.ensah.reservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensah.reservation.dao.EmployeRepository;
import com.ensah.reservation.dao.ReservationRepository;
import com.ensah.reservation.dao.UserRepository;
import com.ensah.reservation.dao.VolRepository;
import com.ensah.reservation.entity.Employe;
import com.ensah.reservation.entity.Reservation;
import com.ensah.reservation.entity.User;
import com.ensah.reservation.entity.Vol;
import com.ensah.reservation.request.VolRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {
	 @Autowired
	 EmployeRepository repository;
	  @Autowired
	  ReservationRepository repository1;
		@Autowired
		UserRepository userRepository;
		@Autowired
		VolRepository volRepository;
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	

	  @GetMapping("/employes/{id}")
	  public ResponseEntity<Employe> getEmployeById(@PathVariable(value = "id") Long userId)
	      throws ResourceNotFoundException {
	    Employe employe =
	        repository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employe not found on :: " + userId));
	    return ResponseEntity.ok().body(employe);
	  }

	  @GetMapping("/employes/login/{login}")
	  public ResponseEntity<Employe> getEmployeByEmail(@PathVariable(value = "login") String login)
	      throws ResourceNotFoundException {
		    System.out.println("Get employe login...");

	    Employe employe =
	        repository
	            .findByEmail(login);
	    return ResponseEntity.ok().body(employe);
	  }
	  @GetMapping("/employes")
	  public List<User> getAllEmployes() {
	    System.out.println("Get all users...");
	 
	    List<User> users = new ArrayList<>();
	    userRepository.findAll().forEach(users::add);
	    return users;
	  }
	  @GetMapping("/reservations")
	  public List<Reservation> getAllReservation() {
	    System.out.println("Get reservations...");
	 
	    List<Reservation> reservations = new ArrayList<>();
	    repository1.findAll().forEach(reservations::add);
	    return reservations;
	  }
	  @PostMapping("/vols")
	  public List<Vol> getAllVol(@RequestBody VolRequest volRequest) {
	    System.out.println("Get vols...");
	 
	    List<Vol> vols = new ArrayList<>();
	    volRepository.findVols(volRequest.getVille_depart(),volRequest.getVille_arrivee()).forEach(vols::add);
	    return vols;
	  }
	 
	  @PostMapping(value = "/employes/create")
	  public Employe postEmploye(@RequestBody Employe employe) {
	  System.out.println("employe create");
	   Employe _employe = repository.save(new Employe(employe.getNom(),employe.getPrenom(),employe.getEmail(),employe.getFonction(),employe.getDateNaissance(),employe.getImageUrl(),employe.getPassword()));
	    return _employe;
	  }
	  @PostMapping(value = "/reservations/create")
	  public Reservation postRervation(@RequestBody Reservation res) {
	  System.out.println("reservation created .....");
	   Reservation _reservation = repository1.save(new Reservation(
			   "RAM","ddk",
			  122,"D4","Casa",
			   "Dakar","14/02/0855",
			   "camara mory",
			   "mmcamara30@gmail.com",
			   "0644500805"));
	    return _reservation;
	  }
	 
	  @DeleteMapping("/employes/{id}")
	  public ResponseEntity<String> deleteEmploye(@PathVariable("id") long id) {
	    System.out.println("Delete Employe with ID = " + id + "...");
	 
	    userRepository.deleteById(id);
	 
	    return new ResponseEntity<>("Employe has been deleted!", HttpStatus.OK);
	  }
	  
	  @PutMapping("/employes/{id}")
	  public ResponseEntity<Employe> updateCustomer(@PathVariable("id") long id, @RequestBody Employe employe) {
	    System.out.println("Update Customer with ID = " + id + "...");
	 
	    Optional<Employe> employeData = repository.findById(id);
	 
	    if (employeData.isPresent()) {
	      Employe _employe = employeData.get();
	      _employe .setNom(employe.getNom());
	      _employe .setPrenom(employe.getPrenom());
	      _employe .setEmail(employe.getEmail());
	      _employe .setFonction(employe.getFonction());
	      _employe.setDateNaissance(employe.getDateNaissance());
	      _employe.setImageUrl(employe.getImageUrl());
	      _employe .setPassword(employe.getPassword());
	      return new ResponseEntity<>(repository.save(_employe ), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
