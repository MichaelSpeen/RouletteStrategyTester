package cz.speen.roulettetester.cls;

import java.util.ArrayList;

import android.R.array;

public class RouletteService {

	public static int vybrana_ruleta;
	public static ArrayList<Roulette> rulety = new ArrayList<Roulette>();
	
	public RouletteService() {
		vybrana_ruleta = setVybranaRuletaId();
		rulety = setRulety();
	}
	
	public static Roulette getVybranaRuleta(){
		return rulety.get(vybrana_ruleta);
	}
	

	private int setVybranaRuletaId() {
		return 0;
	}
	
	public void changeVybranaRuleta(int id_rulety){
		vybrana_ruleta = id_rulety;
	}

	private ArrayList<Roulette> setRulety() {
		ArrayList<Roulette> rulety_pom = new ArrayList<Roulette>();
		rulety_pom.add(new Roulette("Default Roulette", 1, 0.1, 50, 1100));
		rulety_pom.add(new Roulette("Róìov‡ ruleta", 1, 0.1, 50, 1100));
		rulety_pom.add(new Roulette("Kon’ ruleta", 1, 0.1, 50, 1100));
		return rulety_pom;
	}
	
	
}
