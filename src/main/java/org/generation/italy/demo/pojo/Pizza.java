package org.generation.italy.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	
	public Pizza() { }
	public Pizza(String nome, String descrizione, double prezzo) {
		
		
		setNome(nome);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
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
