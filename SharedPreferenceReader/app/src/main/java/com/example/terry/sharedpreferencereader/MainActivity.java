package com.example.terry.sharedpreferencereader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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

    public void readPreference(View view) throws Exception {


        // get Context of other application
        Context otherAppContext = null;
        try{
            otherAppContext =
                    createPackageContext("com.example.terry.sharedpreferencewriter",0);
        }catch(PackageManager.NameNotFoundException e){
            // log
            e.printStackTrace();
            throw e;
        }

        // getting Shared preference from other application
        SharedPreferences pref
                = otherAppContext.getSharedPreferences("MYPREFRENCE", Context.MODE_WORLD_READABLE | Context.MODE_MULTI_PROCESS);
        String value = pref.getString("MYKEY", "NOTFOUND");

        EditText txtValue = (EditText)findViewById(R.id.txtValue);
        txtValue.setText(value);

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
