package com.example.android.coffeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  normalCoffee(View view) {
        Intent normal_coffee = new Intent(this, normal.class);
        startActivity(normal_coffee);
    }

    public void  noSugarCoffee(View view) {
        Intent no_Sugar_coffee = new Intent(this, nosugar.class);
        startActivity(no_Sugar_coffee);
    }

    public void  whippedCoffee(View view) {
        Intent whipped_coffee = new Intent(this, whippedCoffee.class);
        startActivity(whipped_coffee);
    }

    public void  chocolateCoffee(View view) {
        Intent chocolate_coffee = new Intent(this, chocolateCoffee.class);
        startActivity(chocolate_coffee);
    }

}

