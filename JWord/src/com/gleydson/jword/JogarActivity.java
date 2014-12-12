package com.gleydson.jword;

import com.gleydson.jword.visualizacao.VisualizacaoDoJogo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

public class JogarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new VisualizacaoDoJogo(this)); 
	}
}
