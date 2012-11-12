package cz.speen.roulettetester;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import cz.speen.roulettetester.cls.RouletteService;

public class RouletteChooser extends Activity {
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.roulette_chooser);
	    
	    RouletteService rs = new RouletteService();
	    /*String[] values = new String[] {rs.rulety.get(0).nazev};
	    if(rs.rulety.size() > 1){
	    	for(int i=1; i<rs.rulety.size(); i++){
	    		values[i] = rs.rulety.get(i).nazev;
	    	}
	    }*/
	    List<String> values = new ArrayList<String>();
	    for(int i=0; i<rs.rulety.size(); i++){
    		values.add(rs.rulety.get(i).nazev);
    	}
	    ListView listView = (ListView) findViewById(R.id.mylist);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	    		  android.R.layout.simple_list_item_1, android.R.id.text1, values);
	    listView.setAdapter(adapter); 

	    
	    
	    listView.setOnItemClickListener(new OnItemClickListener() {
	    	  @Override
	    	  public void onItemClick(AdapterView<?> parent, View view,
	    	    int position, long id) {
	    	    Toast.makeText(getApplicationContext(),
	    	      "Click ListItem Number " + position, Toast.LENGTH_LONG)
	    	      .show();
	    	  }
	    	}); 

	    
	}
	
	

}
