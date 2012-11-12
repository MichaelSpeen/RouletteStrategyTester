package cz.speen.roulettetester;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import cz.speen.roulettetester.cls.Roulette;
import cz.speen.roulettetester.cls.RouletteService;
import cz.speen.roulettetester.cls.Strategy;
import cz.speen.roulettetester.cls.StrategyService;

public class Simulation extends Activity implements Runnable {

	private TextView tv_log, tv_nazev_strategie, tv_cas, tv_penizky;
	private TableLayout tabulka_log;
	private ScrollView scroll_view;
	private boolean pauza = false;
	private boolean hrajese = false;
	
	private Strategy strategie;
	private Roulette ruleta;
	private Thread myThread;
	
	public static double penizky = 0;
	public static String stav_hrani = " ";
	
	int counter = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.simulation);
        
        RouletteService rs=new RouletteService();
        ruleta = rs.getVybranaRuleta();
        StrategyService ss=new StrategyService();
        strategie = ss.getVybranaStrategie();
        
        //tv_log = (TextView) findViewById(R.id.log);
        tv_cas = (TextView) findViewById(R.id.cas);
        tv_penizky = (TextView) findViewById(R.id.penizky);
        tv_nazev_strategie = (TextView) findViewById(R.id.nazevStrategie);
        tabulka_log = (TableLayout) findViewById(R.id.tabulkaLog);
        scroll_view = (ScrollView) findViewById(R.id.scrollView1);
        
        tv_nazev_strategie.setText(strategie.nazev);
        tv_cas.setText("00:00:00");
        tv_penizky.setText(""+penizky);
	}

	@Override
	public void run() {
		//ziskam cislo
		//otestuju pauzu
		//otestuju konec - stop
		//budu hrat
		//obnov textviewy

        StrategyService ss=new StrategyService();
		List<String> l = new ArrayList<String>();
        
		while (hrajese){

			try {
				//padne číslo
				int nove_cislo = getCislo(ruleta.pocet_nul);
				
				//zahraje se
				l = ss.getVybranaStrategie().hrat(l,nove_cislo,this);
				
				//obnov a doplň texty 
				Message msg = new Message();
				msg.obj = getBarva(nove_cislo)+";"+nove_cislo+";"+"";
				mHandler.sendMessage(msg);
				Log.i("Simulation/run()", nove_cislo+"");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getCislo(int pocet_nul){
		int cislo = 99;
		if(pocet_nul < 1){
			//ruleta bez nuly <1,36>
			cislo = 1+ ((int) (Math.random() * 35));
		} else
			if(pocet_nul == 1){
				//ruleta s jednou nulou <0,36>
				cislo = (int) (Math.random() * 36);
			} else
				if(pocet_nul >= 2){
					//ruleta se dvěma nulama <0,36>  (37 je ta druha nula)
					cislo = (int) (Math.random() * 37);
					if(cislo == 37) cislo = 0;
				}
		return cislo;
	}
	
	private void pridatStav(String barva, String cislo, String poznamka){
        TableRow row = new TableRow(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5, 0, 0, 5);
        
        TextView t = new TextView(this); 
        t.setText(barva);
        t.setShadowLayer(1, 1, 1, 0x773e7f42);
        if(barva.equals("cervena")){
        	t.setText("■");
            t.setTextColor(0xff880000);
            //t.setShadowLayer(1, -1, -1, 0xff013502);
        }else
            if(barva.equals("cerna")){
            	t.setText("■");
                t.setTextColor(0xff000000);
            }else
                if(barva.equals("nula")){
                	t.setText("■");
                    t.setTextColor(0xff013502);
                }
        TextView t1 = new TextView(this); 
        t1.setText(cislo);
        t1.setTextColor(Color.WHITE);
        TextView t2 = new TextView(this); 
        t2.setText(poznamka);
        t2.setTextColor(0xff013502);
        t2.setShadowLayer(1, 1, 1, 0x773e7f42);
        //t2.setTextColor(Color.g);
        
        //t2.setLayoutParams(lp);
        row.addView(t);
        row.addView(t1);
        row.addView(t2);
           
        // add the TableRow to the TableLayout
        tabulka_log.addView(row,new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
 
	}
	
	public void startThread(View view){
		hrajese = true;
		myThread = new Thread(this);
		myThread.start();
		counter = 0;
		}

	public void stopThread(View view){
		if(myThread != null){
			hrajese = false;
			boolean retry = true;
			while(retry){
			 try {
			  myThread.join();
			  retry = false;
			 } catch (InterruptedException e) {
			  e.printStackTrace();
			 }
			}
		}
	}
	
	
	
	Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	
        	//obnov penízky
        	int i = (int) (penizky*100);
	        tv_penizky.setText(""+((double) i/100));
	        
	        //obnov čas
	        	// TODO
        	
        	
        	//doplň tabulku
            String text = (String)msg.obj;
            StringTokenizer st = new StringTokenizer(text, ";");
            
            String barva ="";
            String cislo ="";
            String poznamka = "";
            if(st.hasMoreTokens())
            	barva = st.nextToken();
            if(st.hasMoreTokens())
            	cislo = st.nextToken();
            if(st.hasMoreTokens())
            	poznamka = st.nextToken();

			pridatStav(barva, " "+cislo+" ", poznamka);
			pridatStav(" ", " ", stav_hrani);
			stav_hrani = " ";
			scroll_view.fullScroll(ScrollView.FOCUS_DOWN);
        }
        
	};
	

	
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
