package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	
	@GetMapping("/")
	public String index(Model model) {
	
	List<Pizza> pizzas = pizzaService.findAll();
	model.addAttribute("pizzas", pizzas);
	
	return "index";
	}

	@GetMapping("/pizza/{id}")
	public String getPizza(@PathVariable("id") int id, Model model) {
		
		Optional <Pizza> optPizza = pizzaService.getPizzaById(id);
		if(optPizza.isEmpty()) {
			System.err.println("Pizza non presente con id: " + id);
		}
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		return "pizza";
		
	}
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		
		return "pizza-create";
	}
	
	@PostMapping ("/pizza/create")

 	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
 			
 			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());			
 			return "redirect:/drink/create";
 		}

 		try {			
 			pizzaService.save(pizza);
 		
 		} catch (Exception e) {
 			
 			final String msg = e.getMessage(); 			
 			System.err.println(msg);			
 			redirectAttributes.addFlashAttribute("catchError", msg);			
 			return "redirect:/pizza/create";
 		}
		
		return "redirect:/";
	}

	
	@GetMapping ("/pizza/update/{id}")
	public String getEditPizza(@PathVariable("id") int id, Model model) {
		
		Optional <Pizza> optPizza = pizzaService.getPizzaById(id);
		if(optPizza.isEmpty()) {
			System.err.println("Pizza non presente con id: " + id);
		}
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		return "pizza-update";
	}
	
	@PostMapping("/pizza/store")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza,  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
 			
 			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());			
 			return "redirect:/drink/create";
 		}

 		try {			
 			pizzaService.save(pizza);
 		
 		} catch (Exception e) {
 			
 			final String msg = e.getMessage(); 			
 			System.err.println(msg);			
 			redirectAttributes.addFlashAttribute("catchError", msg);			
 			return "redirect:/pizza/create";
 		}
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		Pizza pizza = optPizza.get();
		
		pizzaService.deletePizzaById(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/search")
	public String getSearchPizzaByName(Model model,
			@RequestParam(name = "q", required=false)String query) {
				
			List<Pizza> pizzas = query == null
			? pizzaService.findAll()
			: pizzaService.findByNome(query);
			
			model.addAttribute("pizzas", pizzas);
			model.addAttribute("query", query);
			return "pizza-search";
		}

}
