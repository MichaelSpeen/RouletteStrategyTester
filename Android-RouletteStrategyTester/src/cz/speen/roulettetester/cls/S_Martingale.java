package cz.speen.roulettetester.cls;

import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.util.Log;

import cz.speen.roulettetester.Simulation;

public class S_Martingale extends Strategy {
	

	public String nazev = "Martingale";
	public ArrayList<String> potrebne_nastaveni_rulety = new ArrayList<String>();

	public S_Martingale() {
		// TODO - yplnit podﬁebné nastavení
		/*
		 * min sazka
		 * max sazka
		 * 
		 */
	}
	

	public List<String> hrat(List<String> l, int cislo, Simulation sim) {
		/*
		 * list[0] = sázka
		 * list[1] = barva
		 */
		
		if(l.size() < 1){
			//zaãátek - vsadíme první sázku - minimální na ãervenou
			RouletteService rs = new RouletteService();
			l.add(rs.getVybranaRuleta().min_sazka+"");
			if(getBarva(cislo).equals("cervena")) l.add("cerna"); else l.add("cervena");
			sim.penizky -= rs.getVybranaRuleta().min_sazka;
			sim.stav_hrani = "Bet "+rs.getVybranaRuleta().min_sazka;
		}else{

			Log.i("zacatek", l.get(0));
			
			String barva = getBarva(cislo);
			if(barva.equals(l.get(1))){
				//vyhrál! :)			-- nastavit opaãnou barvu a nastavit minimální sázku
				RouletteService rs = new RouletteService();
				sim.stav_hrani = "Won "+Double.parseDouble(l.get(0))*2+"\nBet "+rs.getVybranaRuleta().min_sazka;
				sim.penizky += Double.parseDouble(l.get(0))*2;
				if(l.get(1).equals("cervena")) l.set(1,"cerna"); else l.set(1,"cervena");
				l.set(0, rs.getVybranaRuleta().min_sazka+"");
			}else{
				//prohrál >:(			-- zdvojnásobit sázku a barvu nechat
				sim.stav_hrani = "Bet "+Double.parseDouble(l.get(0))*2;
				Double sazka = Double.parseDouble(l.get(0));
				sazka = sazka*2;
				l.set(0, sazka+"");
				sim.penizky -= sazka;
			}
		}

		Log.i("konec", l.get(0));
		
		return l;
	}
	
	public String getBarva(int cislo){
		int[] cervenaCisla = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		Arrays.sort(cervenaCisla);
		if(cislo == 0){
			return "nula";
		} else if(Arrays.binarySearch(cervenaCisla, cislo) > -1){
			return "cervena";
		} else {
			return "cerna";
		}
	}

}
