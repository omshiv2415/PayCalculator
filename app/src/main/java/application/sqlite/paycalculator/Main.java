package application.sqlite.paycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class Main extends Activity {

    public EditText salary;

    public TextView Gpermonth;
    public TextView Gperweeky;
    public TextView Gperannuam;

    public TextView Tpermonth;
    public TextView Tperweeky;
    public TextView Tperannuam;

    public TextView NIpermonth;
    public TextView NIperweeky;
    public TextView NIperannuam;

    public TextView Npermonth;
    public TextView Nperweeky;
    public TextView Nperannuam;

    public Button Reset;
    public double BasicRate = .20;
    public double HighestRate = .40;
    public double AdditionalRate = .45;
    public double AnnualAllowance = 10600;

    public final double NIRate1 = 0.12;
    public double NIRate2 = 0.02;

    public double perMonth;
    public double perWeek;
    public double perAnnuam;

   // final double TotalSalary = Double.parseDouble(Salary.getText().toString())-AnnualAllowance;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        salary = (EditText)findViewById(R.id.Salary);

        Gpermonth = (TextView)findViewById(R.id.GrossPerMonath);
        Gperweeky = (TextView) findViewById(R.id.GrossPerWeek);
        Gperannuam = (TextView) findViewById(R.id.GrossPerAnnuam);

        Tpermonth = (TextView) findViewById(R.id.TaxPerMonth);
        Tperweeky = (TextView) findViewById(R.id.TaxPerWeek);
        Tperannuam = (TextView)findViewById(R.id.TaxPerAnnuam);

        NIpermonth = (TextView) findViewById(R.id.NIPerMonth);
        NIperweeky = (TextView) findViewById(R.id.NIPerWeek);
        NIperannuam = (TextView)findViewById(R.id.NIPerAnnuam);

        Npermonth = (TextView) findViewById(R.id.NetPerMonth);
        Nperweeky = (TextView) findViewById(R.id.NetPerWeek);
        Nperannuam = (TextView)findViewById(R.id.NetPerAnnuam);

        Reset = (Button)findViewById(R.id.ResetBtn);

       Button CalculateSalary = (Button)findViewById(R.id.button);
       CalculateSalary.setEnabled(true);
       CalculateSalary.setOnClickListener(new View.OnClickListener() {
       DecimalFormat dec = new DecimalFormat("#.00");
       Double NiAllowance = 8060.00;

           @Override
           public void onClick(View v) {


               Double salary1 = Double.valueOf((salary.getText().toString()));

               if(salary1 < 10600){


                   Toast toast = Toast.makeText(Main.this, " Please Enter Minimum Allowance (10,600) ", Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.CENTER, 0, 0);
                   toast.show();

               }else if (salary1 > 8060 && salary1 <= 10600) {

                   Double sal =  (salary1 - NiAllowance);
                   Double NI = (sal*NIRate1/12);
                   Double permonth = salary1/12;


                   Double NIperweek = (sal*NIRate1/52);
                   Double perweek = salary1/52;

                   Double NIAnnum = (sal*NIRate1);

                   Gpermonth.setText(String.valueOf(dec.format(permonth)));
                   Tpermonth.setText(String.valueOf("NIL"));
                   NIpermonth.setText(String.valueOf(dec.format(NI)));
                   Npermonth.setText(String.valueOf(dec.format(permonth-NI)));


                   Gperweeky.setText(String.valueOf(dec.format(perweek)));
                   Tperweeky.setText(String.valueOf(("NIL")));
                   NIperweeky.setText(String.valueOf(dec.format(NIperweek)));
                   Nperweeky.setText(String.valueOf(dec.format(perweek-NIperweek)));


                   Gperannuam.setText(String.valueOf(dec.format(salary1)));
                   Tperannuam.setText(String.valueOf(("NIL")));
                   NIperannuam.setText(String.valueOf(dec.format(NIAnnum)));
                   Nperannuam.setText(String.valueOf(dec.format(salary1-NIAnnum)));







               }else if (salary1 > 10600 && salary1 <= 31785) {


                   Double sal =  (salary1 - NiAllowance);
                   Double NI = (sal*NIRate1/12);
                   Double permonth = salary1/12;

                   Double TaxCal = (salary1 - AnnualAllowance);
                   Double Tax = TaxCal*BasicRate;
                   Double Taxpermonth = Tax/12;
                   Double TaxperWeek = Tax/52;


                   Double NIperweek = (sal*NIRate1/52);
                   Double perweek = salary1/52;

                   Double NIAnnum = (sal*NIRate1);


                   Gpermonth.setText(String.valueOf(dec.format(permonth)));
                   Tpermonth.setText(String.valueOf(dec.format(Taxpermonth)));
                   NIpermonth.setText(String.valueOf(dec.format(NI)));
                   Npermonth.setText(String.valueOf(dec.format(permonth-NI-Taxpermonth)));


                   Gperweeky.setText(String.valueOf(dec.format(perweek)));
                   Tperweeky.setText(String.valueOf((dec.format(TaxperWeek))));
                   NIperweeky.setText(String.valueOf(dec.format(NIperweek)));
                   Nperweeky.setText(String.valueOf(dec.format(perweek-NIperweek-TaxperWeek)));


                   Gperannuam.setText(String.valueOf(dec.format(salary1)));
                   Tperannuam.setText(String.valueOf((dec.format(Tax))));
                   NIperannuam.setText(String.valueOf(dec.format(NIAnnum)));
                   Nperannuam.setText(String.valueOf(dec.format(salary1-NIAnnum-Tax)));





               }else if (salary1 > 31786 && salary1 <= 150000){




                   Double sal =  (salary1 - NiAllowance);
                   Double NI = (sal*NIRate2/12);
                   Double permonth = salary1/12;

                   Double TaxCal = (salary1 - AnnualAllowance);
                   Double Tax = TaxCal*HighestRate;
                   Double Taxpermonth = Tax/12;
                   Double TaxperWeek = Tax/52;


                   Double NIperweek = (sal*NIRate1/52);
                   Double perweek = salary1/52;

                   Double NIAnnum = (sal*NIRate1);

                   Gpermonth.setText(String.valueOf(dec.format(permonth)));
                   Tpermonth.setText(String.valueOf(dec.format(Taxpermonth)));
                   NIpermonth.setText(String.valueOf(dec.format(NI)));
                   Npermonth.setText(String.valueOf(dec.format(permonth-NI-Taxpermonth)));


                   Gperweeky.setText(String.valueOf(dec.format(perweek)));
                   Tperweeky.setText(String.valueOf((dec.format(TaxperWeek))));
                   NIperweeky.setText(String.valueOf(dec.format(NIperweek)));
                   Nperweeky.setText(String.valueOf(dec.format(perweek-NIperweek-TaxperWeek)));


                   Gperannuam.setText(String.valueOf(dec.format(salary1)));
                   Tperannuam.setText(String.valueOf((dec.format(Tax))));
                   NIperannuam.setText(String.valueOf(dec.format(NIAnnum)));
                   Nperannuam.setText(String.valueOf(dec.format(salary1-NIAnnum-Tax)));











               }else if (salary1 > 150001){



                   Double sal =  (salary1 - NiAllowance);
                   Double NI = (sal*NIRate2/12);
                   Double permonth = salary1/12;

                   Double TaxCal = (salary1 - AnnualAllowance);
                   Double Tax = TaxCal*AdditionalRate;
                   Double Taxpermonth = Tax/12;
                   Double TaxperWeek = Tax/52;


                   Double NIperweek = (sal*NIRate1/52);
                   Double perweek = salary1/52;

                   Double NIAnnum = (sal*NIRate1);


                   Gpermonth.setText(String.valueOf(dec.format(permonth)));
                   Tpermonth.setText(String.valueOf(dec.format(Taxpermonth)));
                   NIpermonth.setText(String.valueOf(dec.format(NI)));
                   Npermonth.setText(String.valueOf(dec.format(permonth-NI-Taxpermonth)));


                   Gperweeky.setText(String.valueOf(dec.format(perweek)));
                   Tperweeky.setText(String.valueOf((dec.format(TaxperWeek))));
                   NIperweeky.setText(String.valueOf(dec.format(NIperweek)));
                   Nperweeky.setText(String.valueOf(dec.format(perweek-NIperweek-TaxperWeek)));


                   Gperannuam.setText(String.valueOf(dec.format(salary1)));
                   Tperannuam.setText(String.valueOf((dec.format(Tax))));
                   NIperannuam.setText(String.valueOf(dec.format(NIAnnum)));
                   Nperannuam.setText(String.valueOf(dec.format(salary1-NIAnnum-Tax)));







               }



           }
       });


    Reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            Gpermonth.setText("883.33");
            Gperweeky.setText("203.85");
            Gperannuam.setText("10600.00");

            Tpermonth.setText("NIL");
            Tperweeky.setText("NIL");
            Tperannuam.setText("NIL");

            NIpermonth.setText("25.40");
            NIperweeky.setText("5.86");
            NIperannuam.setText("304.80");

            Npermonth.setText("857.93");
            Nperweeky.setText("197.98");
            Nperannuam.setText("10295.20");
            salary.setText("10600");


        }
    });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
