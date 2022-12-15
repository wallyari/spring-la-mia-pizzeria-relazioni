package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.serv.PizzaService;
import org.generation.italy.demo.serv.PromozioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/promotion")
public class PromotionController {
	
	@Autowired
	private PromozioneService promoService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(Model model){
		
 		List<Promozione> promozioni = promoService.findAllWPizza();
 		model.addAttribute("promozioni", promozioni);
 		return "promotion-index";
		
	}
	
	@GetMapping("/create")
	public String getPromotionCreate(Model model) {
		
		Promozione promozione = new Promozione();
		List<Pizza> pizzas = pizzaService.findAll();
 		model.addAttribute("promozione", promozione);
 		model.addAttribute("pizzas", pizzas);

 		return "promotion-create";
		
	}
	
	@PostMapping("/create")
 	public String storePromotion(@Valid Promozione promozione) {
 		List<Pizza> promotionPizzas = promozione.getPizzas();
 		for (Pizza pizza : promotionPizzas) {
 			pizza.setPromozione(promozione);
 		}
 		promoService.save(promozione);

 		return "redirect:/promotion";
 	}

}
