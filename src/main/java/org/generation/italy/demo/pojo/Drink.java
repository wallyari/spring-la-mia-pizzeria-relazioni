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
public class Drink {

 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private int id;


 	@NotEmpty(message = "Il campo nome non può vuoto")
 	@Column(length = 50, unique = true)
 	private String nome;

 	@Lob
 	private String descrizione;

 	@NotNull(message = "Il campo prezzo non può essere vuoto")
 	@Min(value=1)
 	private Integer prezzo;
 	
 	public Drink() {}
 	public Drink(String nome, String descrizione, Integer prezzo) {
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
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
 	
 	@Override
 	public String toString() {
 	
 		return getId()+ " - " + getNome()+ " - " + getPrezzo() + " - " + getDescrizione();
 	}
	

}
