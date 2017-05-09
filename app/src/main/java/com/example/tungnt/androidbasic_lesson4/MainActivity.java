package com.example.tungnt.androidbasic_lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etScreen;
    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnDot;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnReset;
    private Button btnDelete;
    private Button btnCalculate;
    private double a,b;
    private int count;
    private char operation;
    private boolean iscomplete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        setEventWidget();
    }

    private void getWidget(){
        etScreen = (EditText) findViewById(R.id.etScreen);
        btnNum0 = (Button) findViewById(R.id.btnNum0);
        btnNum1 = (Button) findViewById(R.id.btnNum1);
        btnNum2 = (Button) findViewById(R.id.btnNum2);
        btnNum3 = (Button) findViewById(R.id.btnNum3);
        btnNum4 = (Button) findViewById(R.id.btnNum4);
        btnNum5 = (Button) findViewById(R.id.btnNum5);
        btnNum6 = (Button) findViewById(R.id.btnNum6);
        btnNum7 = (Button) findViewById(R.id.btnNum7);
        btnNum8 = (Button) findViewById(R.id.btnNum8);
        btnNum9 = (Button) findViewById(R.id.btnNum9);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
    }

    private void setEventWidget(){
        View.OnClickListener btnNumOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressBtnNum(v);
            }
        };
        View.OnClickListener btnOperationOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressBtnOperation(v);
            }
        };
        btnNum0.setOnClickListener(btnNumOnClickListener);
        btnNum1.setOnClickListener(btnNumOnClickListener);
        btnNum2.setOnClickListener(btnNumOnClickListener);
        btnNum3.setOnClickListener(btnNumOnClickListener);
        btnNum4.setOnClickListener(btnNumOnClickListener);
        btnNum5.setOnClickListener(btnNumOnClickListener);
        btnNum6.setOnClickListener(btnNumOnClickListener);
        btnNum7.setOnClickListener(btnNumOnClickListener);
        btnNum8.setOnClickListener(btnNumOnClickListener);
        btnNum9.setOnClickListener(btnNumOnClickListener);
        btnAdd.setOnClickListener(btnOperationOnClickListener);
        btnSub.setOnClickListener(btnOperationOnClickListener);
        btnMulti.setOnClickListener(btnOperationOnClickListener);
        btnDiv.setOnClickListener(btnOperationOnClickListener);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(getScreenString()) || count == 0) etScreen.setText("0.");
                else etScreen.setText(getScreenString() + ".");
                iscomplete = false;
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressBtnCalculate();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etScreen.setText("0");
                iscomplete = false;
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etScreen.setText("");
                a = 0;
                b = 0;
                count = 0;
                iscomplete = false;
            }
        });
    }

    private void pressBtnNum(View v){
        if (iscomplete) {
            etScreen.setText("");
            iscomplete = false;
        }
        String num = ((Button)v).getText().toString();
        String screen = etScreen.getText().toString();
        if("0".equals(screen)) etScreen.setText(num + "");
        else etScreen.setText(screen + num);
    }

    private void pressBtnOperation(View v){
        if ("".equals(getScreenString())) Toast.makeText(getApplicationContext(),"input incorrect !",Toast.LENGTH_LONG).show();
        else if (count <= 1) {
            a = getNumber();
            etScreen.setText("0");
            operation = ((Button)v).getText().toString().charAt(0);
            count = 2;
            iscomplete = false;
        }
        else pressBtnCalculate();
    }

    private void pressBtnCalculate(){
        if(!"".equals(getScreenString()) && count == 2) {
            b = getNumber();
            switch (operation) {
                case '+':
                    etScreen.setText(a + b + "");
                    break;
                case '-':
                    etScreen.setText(a - b + "");
                    break;
                case 'x':
                    etScreen.setText(a * b + "");
                    break;
                case '/':
                    etScreen.setText(a / b + "");
                    break;
            }
        }
        else {
            etScreen.setText("");
            Toast.makeText(getApplicationContext(),"input incorrect !",Toast.LENGTH_LONG).show();
        }
        a = 0;
        b = 0;
        count = 0;
        iscomplete = true;
    }

    private String getScreenString(){
        return etScreen.getText().toString().trim();
    }

    private double getNumber(){
        return Double.parseDouble(getScreenString());
    }





}
