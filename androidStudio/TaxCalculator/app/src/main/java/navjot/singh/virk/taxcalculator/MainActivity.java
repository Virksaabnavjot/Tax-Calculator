package navjot.singh.virk.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Navjot Singh Virk on 13/12/2016.
 * Student Number: x13112406
 */
public class MainActivity extends AppCompatActivity {
    // declaring edittext for annual salary and tax percentage
    EditText annualSalary;
    EditText taxPercentage;
    TextView taxHereDisplay;
    TextView inHandSalaryDisplay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting connection using view by id which helps us connect code with layout elements by their id's
        annualSalary = (EditText) findViewById(R.id.annualsalary);
        taxPercentage = (EditText) findViewById(R.id.taxpercentage);
        taxHereDisplay = (TextView) findViewById(R.id.displayTax);
        inHandSalaryDisplay = (TextView) findViewById(R.id.displaySalary);

        Button calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checking if the textedits are empty or not
                if (TextUtils.isEmpty(annualSalary.getText().toString()) || TextUtils.isEmpty(taxPercentage.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Make Sure to enter values", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    double grossAmount = Double.parseDouble(annualSalary.getText().toString());
                    int taxPercentageInt = Integer.valueOf(taxPercentage.getText().toString());


                    Double taxAmount = calculateTaxAmount(grossAmount, taxPercentageInt);
                    Double inHandSalary = grossAmount - taxAmount;
                    // formatting the result to four decimal places
                    String displayTaxAmount = String.format("%.2f", taxAmount);
                    String displayInHandSalary = String.format("%.2f", inHandSalary);

                    //Setting tax amount and In hand salary to textviews
                    taxHereDisplay.setText(displayTaxAmount);
                    inHandSalaryDisplay.setText(displayInHandSalary);
                }


            }
        });

    }


    private Double calculateTaxAmount(double grossAmount, int taxPercentageInt) {
        Double taxAmount = taxPercentageInt*grossAmount/100;
        return taxAmount;
    }
}
