package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Il nome non può essere vuoto")
	@Column (unique = true)
	private String nome;
	
	@Column
	@Lob
	private String descrizione;
	
	@NotNull(message = "Il prezzo non può essere vuoto")
 	@Min(value=1)
	@Column
	private double prezzo;

	@ManyToOne
 	@JoinColumn(name="promozione_id", nullable=true)
 	private Promozione promozione;
	
	@ManyToMany
	private List<Ingrediente> ingredienti;
	
	public Pizza() { }
	public Pizza(String nome, String descrizione, double prezzo, Promozione promozione) {
		
		
		setNome(nome);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
		setPromozione(promozione);
	}
	
	public Pizza(String nome, String descrizione, int prezzo, Promozione promozione, List<Ingrediente> ingredienti) {
 		setNome(nome);
 		setDescrizione(descrizione);
 		setPrezzo(prezzo);
 		setPromozione(promozione);
 		setIngredienti(ingredienti);

 	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Promozione getPromozione() {
		return promozione;
	}


	public void setPromozione(Promozione promozione) {
		this.promozione = promozione;
	}
	
	public List<Ingrediente> getIngredienti() {
 		return ingredienti;
 	}
 	public void setIngredienti(List<Ingrediente> ingredienti) {
 		this.ingredienti = ingredienti;
 	}
 	
 	public void addIngredienti(Ingrediente ingrediente) {

 		boolean finded = false;
 		for (Ingrediente i: getIngredienti()) 
 			if (i.getId() == ingrediente.getId())
 				finded = true;

 		if (!finded) 
 			getIngredienti().add(ingrediente);
 	}

 	public void removeIngredienti(Ingrediente ingrediente) {
 		getIngredienti().remove(ingrediente);
 	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + " - "+ getNome()+ " - "+getDescrizione()+ " - "+getPrezzo();
	}

}
