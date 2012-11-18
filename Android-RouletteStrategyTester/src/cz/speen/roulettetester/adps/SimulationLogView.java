package cz.speen.roulettetester.adps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimulationLogView extends LinearLayout {

	public TextView ta, tb, tc;
	
	public SimulationLogView(Context context, AttributeSet atts) {
		super(context, atts);
		this.setOrientation(HORIZONTAL);

		/*
		ta.setText(a);
		tb.setText(b);
		tc.setText(c);
		*/

		ta.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,4));
		tb.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,4));
		tc.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,12));
		
		addView(ta);
		addView(tb);
		addView(tc);
	}

}
