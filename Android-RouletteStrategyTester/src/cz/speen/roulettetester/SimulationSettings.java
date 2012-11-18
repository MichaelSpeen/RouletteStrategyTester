package cz.speen.roulettetester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import cz.speen.roulettetester.cls.RouletteService;

public class SimulationSettings extends Activity {
    
    RouletteService rs = new RouletteService();

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.simulation_settings);
	    
	    
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
	    
	    TextView vybrana_ruleta = (TextView) findViewById(R.id.roulettename);
	    vybrana_ruleta.setText(rs.getVybranaRuleta().nazev);
	    
	    TextView vybrana_strategie = (TextView) findViewById(R.id.strategyname);
	    //vybrana_strategie.setText(rs.getVybranaRuleta().nazev);
	    
	}
	

    public void vybratRuletu(View view) {
        Intent intent = new Intent(this, RouletteChooser.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = "Jde to!";//editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }

    
    public void zacitHrat(View view) {
        Intent intent = new Intent(this, Simulation.class);
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_in);  
    }
    
    
    
    
    

}
