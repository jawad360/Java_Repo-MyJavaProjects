package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public final static String Extra_message="com.example.myfirstapp;";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	public void sendMessage(View view)
	{
		Intent intent = new Intent(this,DisplayMessageActivity1.class);
		
		EditText editText =(EditText)findViewById(R.id.editMessage);
		
		String message = editText.getText().toString();
		
		intent.putExtra(Extra_message, message);
		
		startActivity(intent);
		
		
		
	} 

}
