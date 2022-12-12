package org.generation.italy.demo.controller;




import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.DrinkService;
import org.generation.italy.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DrinkService drinkService;
	
	
	@GetMapping("/search")
	public String getAllByName(Model model,
			@RequestParam(name = "q", required=false)String query) {
			
		//List<Pizza> pizzas = null;
		//List<Drink> drinks = null;
			
		//	if(query == null || query.isEmpty()){
		//		pizzas = pizzaService.findAll();
		//		drinks = drinkService.findAll();			
		//	} else {				
		//		pizzas = pizzaService.findByNome(query);
		//		drinks = drinkService.findByNome(query);
		//	}				
		//	model.addAttribute("pizzas", pizzas);
		//	model.addAttribute("drinks", drinks);
		
		List<Pizza> drinks = query == null ? pizzaService.findAll() : pizzaService.findByNome(query);
		List<Drink> pizzas = query == null ? drinkService.findAll() :  drinkService.findByNome(query);
		model.addAttribute("pizzas", pizzas);
 		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);
					
			return "product-search";
		}

}
