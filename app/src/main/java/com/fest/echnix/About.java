package com.fest.echnix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class About extends Activity{

	ImageButton btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.about);
        btn = (ImageButton) findViewById(R.id.eventButton);
        btn.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				@SuppressWarnings("rawtypes")
				Class myClass = Class.forName("com.fest.echnix.Menu");;
				Intent openMenu = new Intent(About.this,myClass);
				startActivity(openMenu);
				}catch(ClassNotFoundException e){e.printStackTrace();}
			}
		});
        
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
   	    MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.popup_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.exitButton:
			finish();
			break;
		}
		return false;
	}
	
	
}
