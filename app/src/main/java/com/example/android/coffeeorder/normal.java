package com.example.android.coffeeorder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class normal extends AppCompatActivity {
    int quantity = 1;
    int quantitysugar = 1;
    int quantitymilk = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        if(quantity > 100) {
            quantity = 100;
            Toast.makeText(this, "You can't have more than 100cups", Toast.LENGTH_SHORT).show();
            return;
        }
        display(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void incrementsugar(View view) {

        quantitysugar = quantitysugar + 1;
        if(quantitysugar > 100) {
            quantitysugar = 100;
            Toast.makeText(this, "You can't have more than 100 Sugars", Toast.LENGTH_SHORT).show();
            return;
        }
        displaysugar(quantitysugar);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void incrementmilk(View view) {

        quantitymilk = quantitymilk + 1;
        if(quantitymilk > 100) {
            quantitymilk = 100;
            Toast.makeText(this, "You can't have more than 100 Milk", Toast.LENGTH_SHORT).show();
            return;
        }
        displaymilk(quantitymilk);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {

        quantity = quantity - 1;
        if(quantity < 1) {
            quantity = 1;
            Context context = getApplicationContext();
            CharSequence text = "Sorry you can't choose below 1Cup";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrementsugar(View view) {

        quantitysugar = quantitysugar - 1;
        if(quantitysugar < 1) {
            quantitysugar = 1;
            Context context = getApplicationContext();
            CharSequence text = "Sorry you can't choose below 1 Sugar";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        displaysugar(quantitysugar);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrementmilk(View view) {

        quantitymilk = quantitymilk - 1;
        if(quantitymilk < 1) {
            quantitymilk = 1;
            Context context = getApplicationContext();
            CharSequence text = "Sorry you can't choose below 1 Milk";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        displaymilk(quantitymilk);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name);
        String hasName = nameField.getText().toString();

        String subject = "Your coffee order details";



        int price = calculatePrice();
        composeEmail(subject, price, hasName);

    }

    public void composeEmail( String subject, int price, String addName) {
        String orderSummary = "Name: "+ addName;
        orderSummary += "\nType: Normal";
        orderSummary += "\nType: Sugar Quantity: " + quantitysugar;
        orderSummary += "\nType: Milk Quantity: " + quantitymilk;
        orderSummary += "\nQuantity" + quantity;
        orderSummary += "\nTotal: " + price;
        orderSummary += "\nThank You!";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice() {

        return quantity * 5;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numbers);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displaysugar(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_sugar);
        quantityTextView.setText("" + numbers);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displaymilk(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_milk);
        quantityTextView.setText("" + numbers);
    }

    /**
     * Refresh method to home
     */
    public void refresh(View view) {
        Intent home_page = new Intent(this, MainActivity.class);
        startActivity(home_page);
    }
}
