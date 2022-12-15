package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "il nome non può essere vuoto")
	@Column (unique = true)
	private String nome;
	
	@ManyToMany(mappedBy = "ingredienti", cascade = CascadeType.REMOVE)
	private List<Pizza> pizzas;
	
	public Ingrediente() { };
	
	public Ingrediente(String nome) {
 		setNome(nome);
 	}
	
	public Ingrediente(String nome,  List<Pizza> pizzas) {
		setNome(nome);
		setPizzas(pizzas);
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
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
 @Override
public String toString() {
	// TODO Auto-generated method stub
	 return "(" + getId() + ") " + getNome();
 	}
}
