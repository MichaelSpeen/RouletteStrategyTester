package cz.speen.roulettetester.adps;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cz.speen.roulettetester.R;

public class SimulationLogAdapter extends BaseAdapter{
	
	ArrayList<SimulationLog> sl = new ArrayList<SimulationLog>();
	Context mContext;
	private static LayoutInflater inflater = null;
	
	public SimulationLogAdapter(ArrayList<SimulationLog> sl, Context c) {
		this.sl = sl;
		inflater  = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		View vi = convertView;

		SimulationLog sl = getItem(position);

		if (convertView == null)
			vi = inflater.inflate(R.layout.logview, null);
		((TextView) vi.findViewById(R.id.a)).setText(sl.barva);
		((TextView) vi.findViewById(R.id.b)).setText(sl.cislo);
		((TextView) vi.findViewById(R.id.c)).setText(sl.poznamka);
			
		return vi;
		
	} 
	

}
