package com.example.terry.sharedpreferencewriter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void writeSharedPreference(View view){

        EditText txtValue = (EditText) findViewById(R.id.txtValue);
        String value = txtValue.getText().toString();


        // get Shared Preference
        SharedPreferences sharedPreference
                = this.getSharedPreferences("MYPREFRENCE", Context.MODE_MULTI_PROCESS | Context.MODE_WORLD_READABLE);

        //get Editor
        SharedPreferences.Editor editor = sharedPreference.edit();

        // set Key values
        editor.putString("MYKEY",value);
        editor.putString("KEY2", "VALUE2");

        // commit the values
        editor.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
