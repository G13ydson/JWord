/**
 * 
 */
package com.gleydson.jword.controller;



import com.gleydson.jword.JogarActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * @author gleydson
 *
 */
public class JogarController implements OnClickListener {
	private Activity activity;
	
	public JogarController(Activity activity) {
		super();
		this.activity = activity;
	}

	public void onClick(View v) {
		Intent i = new Intent(activity.getBaseContext(), JogarActivity.class);
		activity.startActivity(i);
	}
}
