package org.generation.italy.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Ingrediente;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.serv.DrinkService;
import org.generation.italy.demo.serv.IngredienteService;
import org.generation.italy.demo.serv.PizzaService;
import org.generation.italy.demo.serv.PromozioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private PromozioneService promoService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Promozione promo1 = new Promozione(LocalDate.parse("2022-10-12"), LocalDate.parse("2022-11-12"), "Promo attuale");
		Promozione promo2 = new Promozione(LocalDate.parse("2023-10-01"), LocalDate.parse("2023-01-09"), "Promo futura");
 		promoService.save(promo1);
 		promoService.save(promo2);
		
		Ingrediente ing1 = new Ingrediente("pomodoro");
		Ingrediente ing2 = new Ingrediente("mozzarella");
		Ingrediente ing3 = new Ingrediente("provola");
		Ingrediente ing4 = new Ingrediente("origano");
		Ingrediente ing5 = new Ingrediente("peperoncino");

 		List<Ingrediente> ingredienti1 = new ArrayList<>();
 		ingredienti1.add(ing1);
 		ingredienti1.add(ing2);

 		List<Ingrediente> ingredienti2 = new ArrayList<>();
 		ingredienti2.add(ing3);
 		ingredienti2.add(ing4);

 		List<Ingrediente> ingredienti3 = new ArrayList<>();
 		ingredienti3.add(ing5);

 		ingredienteService.save(ing1);
 		ingredienteService.save(ing2);
 		ingredienteService.save(ing3);
 		ingredienteService.save(ing4);
 		ingredienteService.save(ing5);

		Pizza p1 = new Pizza("Margherita", "Pomodoro, mozzarella, basilico",5, promo1, ingredienti1);
		Pizza p2 = new Pizza("Marinara", "Pomodoro, olio, origano",3, promo2, ingredienti2);		
		Pizza p3 = new Pizza("Capricciosa", "Pomodoro, mozzarella, funghi",6, promo1, ingredienti3);
		Pizza p4 = new Pizza("Margherita Test", "Pomodoro, mozzarella, funghi",6, promo1, ingredienti1);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		
		
		Drink d1 = new Drink("Americano", "Campari , Vermouth , Soda ",5);
		Drink d2 = new Drink("Negroni", "Campari, Vermouth Rosso, Dry Gin",6);
		Drink d3 = new Drink("Moscow Mule", "Vodka, Ginger Beer, Succo di lime",7);
		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		
		
		List <Drink>drinks = drinkService.findAll();
		System.out.println(drinks);
		
		
		//-------- test Delete ----------
 		//promoService.deletePromozioneById(1);

 		//pizzaService.deletePizzaById(4);
		
		//System.out.println("---------------------------");
		//List <Pizza> pizzas = pizzaService.findAll();
		//for (Pizza pizza : pizzas) {
		//	System.err.println(pizza + "\n\t" + pizza.getPromozione());
		//	}


		//System.out.println("---------------------------");
		//List<Promozione> promozioni = promoService.findAllWPizza();

		//for (Promozione promozione : promozioni) {
		//	System.err.println(promozione);
		//	for (Pizza pizza : promozione.getPizzas()) {
		//		System.err.println("\t" + pizza);
 				//	}
		// }
//		System.err.println("---------------------------");
// 		List<Pizza> pizzas = pizzaService.findAllWIngredienti();
// 		for (Pizza pizza : pizzas) {
// 			System.err.println(pizza + "\n\t" + pizza.getIngredienti());
// 		}
// 		
// 		System.out.println("---------------------------");
// 
// 		List<Ingrediente> ingredienti = ingredienteService.findAllWPizza();
// 		for (Ingrediente ingrediente : ingredienti) {
// 			System.err.println(ingrediente +  "\n\t" + ingrediente.getPizzas());
// 		}
//		
		
	}

}
