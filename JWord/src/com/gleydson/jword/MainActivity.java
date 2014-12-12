package com.gleydson.jword;

import com.gleydson.jword.controller.JogarController;
import com.gleydson.jword.controller.SairController;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
	Button bt_jogar;
	Button bt_sair;
	/** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_jogar = (Button) findViewById(R.id.bt_jogar);
        bt_sair = (Button) findViewById(R.id.bt_sair);
        bt_jogar.setOnClickListener(new JogarController(MainActivity.this));  
        bt_sair.setOnClickListener(new SairController());
    } 
    
    
    
}