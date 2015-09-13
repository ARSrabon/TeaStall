package com.example.student.teastall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_add;
    Button btn_sub;
    Button btn_calc;

    EditText tea_price;
    EditText tea_Customer;
    TextView result;

    int customer = 2;
    int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_calc = (Button) findViewById(R.id.btn_calc);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_calc.setOnClickListener(this);

        tea_price = (EditText) findViewById(R.id.T_price);
        tea_Customer = (EditText) findViewById(R.id.T_customer);
        result = (TextView) findViewById(R.id.result);


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

    public void onClick(View v) {
        int total;
        String A = tea_price.getText().toString();
        String B = tea_Customer.getText().toString();
        if (v == btn_add) {
            customer = Integer.valueOf(B);
            customer++;
            tea_Customer.setText(String.valueOf(customer));
        } else if (v == btn_sub) {

            if (customer >= 2) {
                customer = Integer.valueOf(B);
                customer--;
                tea_Customer.setText(String.valueOf(customer));
            } else {
                Toast.makeText(MainActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }

        } else if (v == btn_calc) {

            customer = Integer.valueOf(B);
            price = Integer.valueOf(A);
            total = price * customer;
            result.setText("Total : " + Integer.toString(total));
        }
    }
}
