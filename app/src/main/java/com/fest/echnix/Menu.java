package com.fest.echnix;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String classes[] = {"Research","Mock-IT","0's & 1's","Kaun Banega Hazarpati","Exam","Mr & Ms EChnix","Master Chef","Loot"};
	@SuppressWarnings("rawtypes")
	Class myClass ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.row_layout, R.id.label, classes));	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
		switch(position){
		case 1:
			myClass = Class.forName("com.fest.echnix.Mockit");
			break;
		case 2:
			myClass = Class.forName("com.fest.echnix.Zno");
			break;
		case 3:
			myClass = Class.forName("com.fest.echnix.KBH");
			break;
		case 5:
			myClass = Class.forName("com.fest.echnix.Ftv");
			break;
		case 6:
			myClass = Class.forName("com.fest.echnix.Mc");
			break;
		default:
			myClass = Class.forName("com.fest.echnix."+classes[position]);
			break;
		}	
		Intent myIntent = new Intent(Menu.this , myClass);
		startActivity(myIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
