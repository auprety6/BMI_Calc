package com.example.bmicalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.text.DecimalFormat;



    public class  MainActivity extends AppCompatActivity {

        Button buttonCalculate, buttonExit;
        EditText inputKg, inputM;
        TextView showResult, showBMI, showImpBMI;
        private double kg, m;
        private DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");
        MetricFormula metricFormula;
        Imperial imperialFormula;
        BmiClassification bmiCategory = new BmiClassification();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            buttonCalculate = findViewById(R.id.buttonCalculate);
            buttonExit = findViewById(R.id.buttonExit);
            inputKg = findViewById(R.id.inputKg);
            inputM = findViewById(R.id.inputM);
            showResult = findViewById(R.id.showResult);
            showBMI = findViewById(R.id.showBMI);
            showImpBMI = findViewById(R.id.showImpBMI);

            buttonCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    kg = Double.parseDouble(inputKg.getText().toString());
                    m = Double.parseDouble(inputM.getText().toString());

                    metricFormula = new MetricFormula(kg, m);
                    imperialFormula = new Imperial(kg, m);

                    showBMI.setText("BMI = " + String.valueOf(TWO_DECIMAL_PLACES.format(metricFormula.computeBMI(metricFormula.getInputKg(),metricFormula.getInputM()))));
                    showImpBMI.setText("In imperial formula: " + String.valueOf(TWO_DECIMAL_PLACES.format(imperialFormula.computeBMI(imperialFormula.getInputKg(), imperialFormula.getInputM()))));
                    showResult.setText(bmiCategory.getCategory(metricFormula.computeBMI(metricFormula.getInputKg(),metricFormula.getInputM())));

                }
            });



        }
}
