package cz.speen.roulettetester.cls;

import java.util.ArrayList;
import java.util.List;

public class StrategyService {
	
	public static ArrayList<Strategy> seznam_strategii = new ArrayList<Strategy>();
	public static int vybrana_strategie;
	
	public StrategyService() {
		nstavitSeznamStrategii();
		nastavitVybranouStrategii();
	}
	
	public static List<String> getSeznamStrategiiString(){
		List<String> values = new ArrayList<String>();
	    for(int i=0; i<seznam_strategii.size(); i++){
    		values.add(seznam_strategii.get(i).nazev);
    	}
		return values;
	}
	
	public static Strategy getVybranaStrategie() {
		return seznam_strategii.get(vybrana_strategie);
	}

	private void nastavitVybranouStrategii() {
		vybrana_strategie = 0;
	}

	private void nstavitSeznamStrategii() {
		seznam_strategii.add(new S_Martingale());
	}

}
