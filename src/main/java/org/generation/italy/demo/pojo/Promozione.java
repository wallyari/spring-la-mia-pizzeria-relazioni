package org.generation.italy.demo.pojo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Promozione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@NotNull(message = "la data di inizio non può essere null")
	private LocalDate dataInizio;
	
	@Column
	@NotNull(message = "la data di fine non può essere null")
	private LocalDate dataFine;
	
	@Column(unique = true)
	@NotNull(message = "il titolo non può essere vuoto")
	private String titolo;
	
	@OneToMany(mappedBy = "promozione", cascade = CascadeType.REMOVE)
 	private List<Pizza> pizzas;
	
	public Promozione ( ) { }
	public Promozione (LocalDate dataInizio, LocalDate dataFine, String titolo) {
		
		setDataInizio(dataInizio);
		setDataFine(dataFine);
		setTitolo(titolo);		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public List<Pizza> getPizzas() {
 		return pizzas;
 	}
 	public void setPizzas(List<Pizza> pizzas) {
 		this.pizzas = pizzas;
 	}
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		 return "(" + getId() + ")" + " " + getTitolo() + " - " + getDataInizio() + " " + getDataFine();
	}
	
	

}
