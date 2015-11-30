package com.example.alish.my_git_app_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alish.com.example.alish.polo.InstiAdapter;
import com.example.alish.com.examps.Instituton;

import java.util.ArrayList;
import java.util.List;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        //爱好复选框
        CheckBox Check_1 = (CheckBox)findViewById(R.id.Interesting_1);
        CheckBox Check_2 = (CheckBox)findViewById(R.id.Interesting_2);
        CheckBox Check_3 = (CheckBox)findViewById(R.id.Interesting_3);
        CheckBox Check_4 = (CheckBox)findViewById(R.id.Interesting_4);

        CheckBox.OnClickListener checkBoxListener = new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckBox curBox = (CheckBox)v;
                String checkedText = curBox.getText().toString();
                if(curBox.isChecked()){
                    Toast.makeText(RegActivity.this,checkedText+"被选中",Toast.LENGTH_LONG)
                            .show();
                }else{
                    Toast.makeText(RegActivity.this,checkedText+"被取消",Toast.LENGTH_LONG)
                            .show();
                }
            }
        };
        Check_1.setOnClickListener(checkBoxListener);
        Check_2.setOnClickListener(checkBoxListener);
        Check_3.setOnClickListener(checkBoxListener);
        Check_4.setOnClickListener(checkBoxListener);


        //RadioGroup框
        RadioButton radioButton_1 = (RadioButton)findViewById(R.id.Radio_Man);
        RadioButton radioButton_2 = (RadioButton)findViewById(R.id.Radio_wman);

        RadioButton.OnClickListener radio_all_Listener = new  RadioButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                RadioButton curRadio = (RadioButton)v;
                String radioText = curRadio.getText().toString();
                if(curRadio.isChecked()){
                    Toast.makeText(RegActivity.this,radioText+"被选中", Toast.LENGTH_SHORT).show();
                }
            }
        };
        radioButton_1.setOnClickListener(radio_all_Listener);
        radioButton_2.setOnClickListener(radio_all_Listener);

//Spinner edu
        final Spinner mSpinner = (Spinner)findViewById(R.id.Spinner_Edu);
        final List<String> listEdu = new ArrayList<String>();
        listEdu.add("幼儿园");
        listEdu.add("一年级");
        listEdu.add("二年级");
        listEdu.add("三年级");
        listEdu.add("毕业季");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listEdu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView v1 = (TextView) view;
                v1.setTextColor(Color.WHITE);

                Toast.makeText(RegActivity.this, ((TextView) view).getText().toString() + "被选中", Toast.LENGTH_SHORT).show();
                Toast.makeText(RegActivity.this, listEdu.get(position) + "被选中", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(RegActivity.this, "mSpinner未被选中", Toast.LENGTH_SHORT).show();
            }
        });

//Spinner Ins
        final Spinner mSpinner_Ins = (Spinner)findViewById(R.id.Spinner_Edu_Ins);
        List<Instituton> listIniti = new ArrayList<Instituton>();
        listIniti.add(new Instituton("CQUT","Computer","IOT"));
        listIniti.add(new Instituton("CQUT","Computer","CS"));
        listIniti.add(new Instituton("CQUT", "Computer", "NE"));
        InstiAdapter instiAdapter = new InstiAdapter(this,listIniti);
        mSpinner_Ins.setAdapter(instiAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reg, menu);
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
}
