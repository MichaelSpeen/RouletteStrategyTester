package cz.speen.roulettetester;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tv = (TextView) findViewById(R.id.textView1);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        Typeface face = Typeface.createFromAsset(getAssets(),
                    "fonts/Mermaid1001.ttf");
        tv.setTypeface(face);
        tv2.setTypeface(face);
        
    }
    
    public void onClick(View view) {
        Intent intent = new Intent(this, SimulationSettings.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = "Jde to!";//editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.fade_in);  
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		System.out.println("klik");
		onClick(v);
		return true;
	}
}