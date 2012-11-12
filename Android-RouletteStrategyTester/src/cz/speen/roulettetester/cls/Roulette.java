package cz.speen.roulettetester.cls;

public class Roulette {
	
	public String nazev;
	public int pocet_nul;
	public double min_sazka;
	public double max_sazka;
	public int delka_spinu;
	public String popis;
	
	public Roulette() {
		// TODO Auto-generated constructor stub
	}

	public Roulette(String nazev, int pocet_nul, double min_sazka, double max_sazka,
			int delka_spinu) {
		super();
		this.nazev = nazev;
		this.pocet_nul = pocet_nul;
		this.min_sazka = min_sazka;
		this.max_sazka = max_sazka;
		this.delka_spinu = delka_spinu;
	}
	
	

}
