package com.oatos.datatest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText editText = (EditText) findViewById(R.id.edit_text);
		Button btnFile = (Button) findViewById(R.id.btn_file);
		Button btnPreActivity = (Button) findViewById(R.id.btn_pre_activity);
		Button btnPreContext = (Button) findViewById(R.id.btn_pre_context);
		Button btnPreManager = (Button) findViewById(R.id.btn_pre_manager);
		
		btnFile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data = editText.getText().toString();
				if (!"".equalsIgnoreCase(data)) {
					FileOutputStream out = null;
					BufferedWriter writer = null;
					try {
						out = openFileOutput("file", Context.MODE_PRIVATE);
						writer = new BufferedWriter(new OutputStreamWriter(out));
						writer.write(data);
					} catch (Exception ex) {
						Log.d("MainActivity", "", ex);
					} finally {
						try {
							if (out != null) {
								out.close();
							}
							if (writer != null) {
								writer.close();
							}
						} catch (Exception e) {
						}
	
					}
					
				}
			}
		});
		btnPreActivity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data = editText.getText().toString();
				if (!"".equalsIgnoreCase(data)) {
					SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
					editor.putString("key1", data);
					editor.commit();
				}
			}
		});
		btnPreContext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data = editText.getText().toString();
				if (!"".equalsIgnoreCase(data)) {
					SharedPreferences.Editor editor = getSharedPreferences("share", MODE_PRIVATE).edit();
					editor.putString("key2", data);
					editor.commit();
				}
			}
		});
		btnPreManager.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data = editText.getText().toString();
				if (!"".equalsIgnoreCase(data)) {
					SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
					editor.putString("key3", data);
					editor.commit();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
