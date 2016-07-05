package com.tqdu.employee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView name,dob,address,gender;
    LinearLayout btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.text_view_name);
        dob = (TextView) findViewById(R.id.text_view_dob);
        address = (TextView) findViewById(R.id.text_view_address);
        gender = (TextView) findViewById(R.id.text_view_sex);

        Bundle extras = getIntent().getExtras();
        name.setText(extras.getString("name"));
        dob.setText(extras.getString("dob"));
        address.setText(extras.getString("address"));
        gender.setText(extras.getString("gender"));

        btnBack = (LinearLayout) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
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

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
