package com.endoapi.simplesendsms;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SimpleSMSActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button sendBtn = (Button)findViewById(R.id.sendSmsBtn);
		sendBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				EditText addrTxt =
					(EditText)SimpleSMSActivity.this.findViewById(R.id.addrEditText);
				EditText msgTxt =
					(EditText)SimpleSMSActivity.this.findViewById(R.id.msgEditText);
				try {
					sendSmsMessage(
							addrTxt.getText().toString(),msgTxt.getText().toString());
					Toast.makeText(SimpleSMSActivity.this, "SMS Sent",
							Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Toast.makeText(SimpleSMSActivity.this, "Failed to send SMS",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
			}});
	}


	private void sendSmsMessage(String address,String message)throws Exception
	{
		SmsManager smsMgr = SmsManager.getDefault();
		smsMgr.sendTextMessage(address, null, message, null, null);
	}


}
