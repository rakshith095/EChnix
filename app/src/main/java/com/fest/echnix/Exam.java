package com.fest.echnix;

import java.util.Date;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class Exam extends Activity{

	EditText name,numb,sem,branch,coll;
	ImageButton send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.exam);

		name = (EditText)findViewById(R.id.examName);
		numb = (EditText)findViewById(R.id.examNumber);
		sem = (EditText)findViewById(R.id.examSemester);
		branch = (EditText)findViewById(R.id.examBranch);
		coll = (EditText)findViewById(R.id.examColl);
		send = (ImageButton) findViewById(R.id.examReg);

		TabHost th = (TabHost) findViewById(R.id.tabhostExam);
		th.setup();
		TabSpec ts = th.newTabSpec("tagExam1");
		ts.setContent(R.id.examTab1);
		ts.setIndicator("About");
		th.addTab(ts);
		ts = th.newTabSpec("tagExam2");
		ts.setContent(R.id.examTab2);
		ts.setIndicator("Registration");
		th.addTab(ts);

		send.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String message = "Exam"+"\n"+
								"Name:"+ name.getText().toString()+"\n"+
								 "Ph no:"+numb.getText().toString()+"\n"+
								 "Sem:"+sem.getText().toString()+"\n"+
								 "Branch:"+branch.getText().toString()+"\n"+
								 "Coll:"+coll.getText().toString()+"\n";
				Date d = new Date();
				
				if(name.getText().toString().contentEquals("")||
						 numb.getText().toString().contentEquals("") ||
						 sem.getText().toString().contentEquals("") ||
						 branch.getText().toString().contentEquals("")||
						 coll.getText().toString().contentEquals("")){
					Toast.makeText(getApplicationContext(), "Please fill in all the details", Toast.LENGTH_LONG).show();
				}else if(!(d.before(new Date(113,4,10)))){
					Toast.makeText(getBaseContext(), "Registration closed",Toast.LENGTH_LONG).show();
					finish();
				}else{
					final ProgressDialog pd = new ProgressDialog(Exam.this);
					pd.setTitle("Registering");
					pd.setMessage("Please Wait...!!");
					pd.show();
					String sent ="SMS_SENT";
			        PendingIntent sentPI = PendingIntent.getBroadcast(Exam.this, 0,new Intent(sent), 0);
			        registerReceiver(new BroadcastReceiver(){
			        	@Override
			        	public void onReceive(Context arg0, Intent arg1) {
			        		if(getResultCode() == Activity.RESULT_OK){
			        			Toast.makeText(getBaseContext(), "Successfully Registered",Toast.LENGTH_SHORT).show();
			        			pd.dismiss();
			        			finish();
			        			}else{
			        				Toast.makeText(getBaseContext(), "Registration Failed",Toast.LENGTH_SHORT).show();
			        				}
			        		}}, new IntentFilter(sent));
			     
				        SmsManager.getDefault().sendTextMessage("YOUR_PHONE_NUMBER", null, message, sentPI, null);
				        SmsManager.getDefault().sendTextMessage("YOUR_PHONE_NUMBER", null, message, sentPI, null);			        	
				}		
			}
		});

	}

}
