package com.example.coffeeorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    RadioButton rbTea;
    RadioButton rbCoffee;
    TextView chooseDrink;
    Spinner spTea;
    Spinner spCoffee;
    CheckBox milk;
    CheckBox sugar;
    CheckBox lemon;

    String name;
    String password;
    TextView hello;
    String drink;
    StringBuilder stringBuilders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        hello = findViewById(R.id.tvChooseDrink);
        rbTea = findViewById(R.id.rbTea);
        rbCoffee = findViewById(R.id.rbCoffee);
        chooseDrink = findViewById(R.id.tvChooseAdd);
        spTea=findViewById(R.id.spTea);
        spCoffee=findViewById(R.id.spCoffee);
        String additions = String.format(getString(R.string.add), getString(R.string.tea));
        chooseDrink.setText(additions);
        milk = findViewById(R.id.cbMilk);
        lemon = findViewById(R.id.cbLemon);
        sugar = findViewById(R.id.cbSugar);
        stringBuilders = new StringBuilder();
        drink = getString(R.string.tea);



        Intent intent = getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("pass")) {
            name = intent.getStringExtra("name");
            password = intent.getStringExtra("pass");
        } else {
            name = getString(R.string.default_name);
            password = getString(R.string.default_pass);
        }

        String hello1 = (String.format(getString(R.string.hello), name));
        hello.setText(hello1);
    }



    public void changeDrink(View view) {
        RadioButton button = (RadioButton) view;
        int id = button.getId();
        if (id == R.id.rbTea) {
            drink = getString(R.string.tea);
            spTea.setVisibility(View.VISIBLE);
            spCoffee.setVisibility(View.INVISIBLE);
            lemon.setVisibility(View.VISIBLE);

        } else if (id == R.id.rbCoffee) {
            drink = getString(R.string.coffee);
            spTea.setVisibility(View.INVISIBLE);
            spCoffee.setVisibility(View.VISIBLE);
            lemon.setVisibility(View.INVISIBLE);
        }
        String additions = String.format(getString(R.string.add), drink);
        chooseDrink.setText(additions);

    }
    public void orderSum(View view) {
        stringBuilders.setLength(0);

        if (milk.isChecked()){
            stringBuilders.append(getString(R.string.milk)).append(" ");
        }
        if (sugar.isChecked()){
            stringBuilders.append(getString(R.string.sugar)).append(" ");
        }
        if (lemon.isChecked() && drink.equals(getString(R.string.tea))){
            stringBuilders.append(getString(R.string.lemon)).append(" ");
        }

        String order ;

        String optionOfDrink;
        if (drink.equals(getString(R.string.tea))){
            optionOfDrink = spTea.getSelectedItem().toString();
        }
        else {
            optionOfDrink = spCoffee.getSelectedItem().toString();
        }
        order = String.format(getString(R.string.order),name,password,drink,optionOfDrink);

        String adds;
        if (stringBuilders.length()>0){
            adds = getString(R.string.ads)+stringBuilders.toString();
        }
        else {
            adds="";
        }

        String fullOrder = order + adds;

        Intent intent = new Intent(this,OrderActivity.class);
        intent.putExtra("fullOrder",fullOrder);
        startActivity(intent);
    }


}
