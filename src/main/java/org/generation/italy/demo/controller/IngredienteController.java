package org.generation.italy.demo.controller;

import java.util.List;
import org.generation.italy.demo.pojo.Ingrediente;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.IngredienteService;
import org.generation.italy.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

 @Controller
 @RequestMapping("/ingrediente")
 public class IngredienteController {

 	@Autowired
 	private IngredienteService ingredienteService;

 	@Autowired
 	private PizzaService pizzaService;

 	@GetMapping
 	public String index(Model model) {

 		List<Ingrediente> ingredienti = ingredienteService.findAll();
 		model.addAttribute("ingredienti", ingredienti);
 		return "ingrediente-index";
 	}

 	@GetMapping("/create")
 	public String getIngredienteCreate(Model model) {

 		Ingrediente ingrediente = new Ingrediente();
 		List<Pizza> pizzas = pizzaService.findAll();
 		model.addAttribute("ingrediente", ingrediente);
 		model.addAttribute("pizzas", pizzas);
 		
 		return "ingrediente-create";
 	}
 	@PostMapping("/create")
 	public String storeIngrediente(@Valid Ingrediente ingrediente) {
		
 		for (Pizza pizza : ingrediente.getPizzas())
			pizza.getIngredienti().add(ingrediente);
		ingredienteService.save(ingrediente);
		
		return "redirect:/ingrediente";
		
	}
 	@GetMapping("/update/{id}")
 	public String editIngrediente(@PathVariable("id") int id, Model model) {

 		Ingrediente ingrediente = ingredienteService.findById(id);
 		model.addAttribute("ingrediente", ingrediente);

 		List<Pizza> pizzas = pizzaService.findAll();
 		model.addAttribute("pizzas", pizzas);
 		
 		return "ingrediente-update";
 	}

 	//@PostMapping("/update/{id}")
 	@PostMapping("/update/{id}")
 	public String updateIngrediente(
 			@PathVariable("id") int id,
 			@Valid Ingrediente ingrediente) {

 		Ingrediente oldIng = ingredienteService.findById(id);

 		//pizza user	
 		for(Pizza p: oldIng.getPizzas()) 
 			p.getIngredienti().remove(ingrediente);
 		
 		for(Pizza p: ingrediente.getPizzas()) 
 	 			p.getIngredienti().add(ingrediente);
	
 		ingredienteService.save(ingrediente);
 		return "redirect:/ingrediente" ;
 	}
 	
 	
 	@GetMapping("/delete/{id}")
 	public String deleteIngrediente(@PathVariable("id") int id) {
 		

 		ingredienteService.delete(id);
 		return "redirect:/ingrediente";
 	}

 }
