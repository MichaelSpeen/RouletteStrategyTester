package cz.speen.roulettetester.adps;

import java.util.ArrayList;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimulationLogAdapter extends BaseAdapter{
	
	ArrayList<SimulationLog> sl = new ArrayList<SimulationLog>();
	Context mContext;
	
	public SimulationLogAdapter(ArrayList<SimulationLog> sl, Context c) {
		sl.add(new SimulationLog("cervena", "12", "pozn"));
		sl.add(new SimulationLog("cervena", "12", "pozn"));
		sl.add(new SimulationLog("cervena", "12", "pozn"));
		sl.add(new SimulationLog("cervena", "12", "pozn"));
		sl.add(new SimulationLog("cervena", "12", "pozn"));
		this.sl = sl;
	}

	@Override
	public int getCount() {
		return sl.size();
	}

	@Override
	public SimulationLog getItem(int position) {
		return sl.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*
		  Button btn;  
		  if (convertView == null) {  
		   // if it's not recycled, initialize some attributes  
		   btn = new Button(mContext);  
		   btn.setLayoutParams(new GridView.LayoutParams(100, 55));  
		   btn.setPadding(8, 8, 8, 8);  
		   }  
		  else {  
		   btn = (Button) convertView;  
		  }  
		    
		  btn.setText(getItem(position).a);  
		  // filenames is an array of strings  
		  btn.setTextColor(Color.WHITE);  
		  //btn.setBackgroundResource(R.drawable.button);  
		  btn.setId(position);  
		  
		  return btn;
		*/
		
		SimulationLogView ll;
		if (convertView == null) {  
			// if it's not recycled, initialize some attributes  
			ll = new SimulationLogView(mContext, null);
			//ll.setLayoutParams(new GridView.LayoutParams(100, 55));  
			//ll.setPadding(8, 8, 8, 8);  
		} else {  
			ll = (SimulationLogView) convertView;  
		}    

		ll.ta.setText(getItem(position).a);
		ll.tb.setText(getItem(position).b);
		ll.tc.setText(getItem(position).c);
		
		return ll;
		
	} 
	

}
