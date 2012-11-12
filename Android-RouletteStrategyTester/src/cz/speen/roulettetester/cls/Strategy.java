package cz.speen.roulettetester.cls;

import java.util.ArrayList;
import java.util.List;

import cz.speen.roulettetester.Simulation;

public abstract class Strategy {

	public String nazev = "Martingale";
	public ArrayList<String> potrebne_nastaveni_rulety = new ArrayList<String>();
	public boolean pause = false;
	
	
	public List<String> hrat(List<String> l, int cislo, Simulation sim) {
		// TODO Auto-generated method stub
		return l;
	}
	
}
