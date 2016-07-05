package com.tqdu.employee;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName, editDOB;
    Spinner spinnerAddress;
    RadioGroup radioGroup;
    Button btnAdd;
    int _year, _month, _day;
    String name,dob,address,sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.edit_text_name);
        editDOB = (EditText) findViewById(R.id.edit_text_dob);
        spinnerAddress = (Spinner) findViewById(R.id.edit_text_address);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        btnAdd = (Button) findViewById(R.id.btn_add);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.address_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAddress.setAdapter(adapter);

        btnAdd.setOnClickListener(this);
        editDOB.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        name = editName.getText().toString();
        dob = _day+"/"+_month+"/"+_year;
        address = spinnerAddress.getSelectedItem().toString();
        sex = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("dob",dob);
        intent.putExtra("address",address);
        intent.putExtra("gender",sex);
        switch (v.getId()) {
            case R.id.edit_text_dob:
                new DatePickerDialog(this,dPickerListener,_year,_month,_day).show();
                break;
            case R.id.btn_add:
                startActivity(intent);
                break;
        }
    }

    private DatePickerDialog.OnDateSetListener dPickerListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    _year = year;
                    _month = monthOfYear;
                    _day = dayOfMonth;
                    editDOB.setText(_day+"/"+_month+"/"+_year);
                }
            };


}
