package com.example.lged;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText total_ET, advance_ET, vat_ET, incometax_ET, labtest_ET, rollerrent_ET;
    Button reset_button, submit_button;
    TextView rp_view,vp_view,ip_view, deduction_view, result_view,result_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Bill Checker");


        total_ET = findViewById(R.id.id_totalbill);
        advance_ET = findViewById(R.id.id_advance);
        vat_ET = findViewById(R.id.id_vat);
        incometax_ET = findViewById(R.id.id_incometax);
        labtest_ET = findViewById(R.id.id_labtest);
        rollerrent_ET = findViewById(R.id.id_rollerrent);

        reset_button = findViewById(R.id.id_reset);
        submit_button = findViewById(R.id.id_submit);

        rp_view = findViewById(R.id.rp_id);
        vp_view = findViewById(R.id.vp_id);
        ip_view = findViewById(R.id.ip_id);

        deduction_view = findViewById(R.id.id_dediction_view);
        result_view = findViewById(R.id.id_result_view);
        result_view2 = findViewById(R.id.id_result_view2);

        total_ET.setOnClickListener(this);
        advance_ET.setOnClickListener(this);
        vat_ET.setOnClickListener(this);
        incometax_ET.setOnClickListener(this);
        labtest_ET.setOnClickListener(this);
        rollerrent_ET.setOnClickListener(this);
        reset_button.setOnClickListener(this);
        submit_button.setOnClickListener(this);

        rp_view.setOnClickListener(this);
        vp_view.setOnClickListener(this);
        ip_view.setOnClickListener(this);
        deduction_view.setOnClickListener(this);
        result_view.setOnClickListener(this);
        result_view2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        try {
            String total = total_ET.getText().toString();
            String advance = advance_ET.getText().toString();
            String vat = vat_ET.getText().toString();
            String income = incometax_ET.getText().toString();
            String lab = labtest_ET.getText().toString();
            String roller = rollerrent_ET.getText().toString();

           /* BigDecimal total0 = new BigDecimal(Double.parseDouble(total)) ;
            long total1 =  total0.longValue();

            BigDecimal advance0 = new BigDecimal(Double.parseDouble(advance)) ;
            long  advance1=  advance0.longValue();

            BigDecimal vat0 = new BigDecimal(Double.parseDouble(vat)) ;
            long vat1=  vat0.longValue();

            BigDecimal income0 = new BigDecimal(Double.parseDouble(income)) ;
            long income1=  income0.longValue();
            BigDecimal lab0 = new BigDecimal(Double.parseDouble(lab)) ;
            long lab1=  lab0.longValue();
            BigDecimal roller0 = new BigDecimal(Double.parseDouble(roller)) ;
            long roller1=  roller0.longValue(); */

            double total1 = Double.parseDouble(total);
            double advance1 = Double.parseDouble(advance);
            double vat1 = Double.parseDouble(vat);
            double income1 = Double.parseDouble(income);
            double lab1 = Double.parseDouble(lab);
            double roller1 = Double.parseDouble(roller);
            double deduction= 0;


            BigDecimal advancetk = new BigDecimal  ((advance1/100)*total1);
            long  advancetk1=  advancetk.longValue();

            BigDecimal vattk = new BigDecimal ( (vat1/100)*total1);
            long  vattk1=  vattk.longValue();

            BigDecimal incometk = new BigDecimal ( (income1/100)*total1);
            long  incometk1=  incometk.longValue();

            rp_view.setText("%   =  "+(advancetk1+" tk"));
            vp_view.setText("%   =  "+(vattk1+" tk"));
            ip_view.setText("%   =  "+(incometk1+" tk"));


            deduction=((((advance1/100)*total1)+((vat1/100)*total1)+((income1/100)*total1))+(lab1+roller1));
            BigDecimal deductiontk = new BigDecimal (deduction);
            long  deduction2=  deductiontk.longValue();

            BigDecimal netbill = new BigDecimal ( total1-deduction2);
            long  netbill1=  netbill.longValue();


            if (v.getId() == R.id.id_submit) {

                deduction_view.setText(+deduction2+"  tk");
                result_view.setText("( "+total+ " - " +deduction2+" )");
                result_view2.setText(" = "+netbill1);

            }
            else if(v.getId()== R.id.id_reset) {

                total_ET.getText().clear();
                advance_ET.getText().clear();
                vat_ET.getText().clear();
                incometax_ET.getText().clear();
                labtest_ET.getText().clear();
                rollerrent_ET.getText().clear();


                rp_view.setText("%   =  ");
                vp_view.setText("%   =  ");
                ip_view.setText("%   =  ");
                deduction_view.setText("");
                result_view.setText("");
                result_view2.setText("");
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}