package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button AC, power, back, div;
    private Button un, deux, trois, plus;
    private Button quatre, cinq, six, moins;
    private Button sept, huit, neuf, mult;
    private Button zero, Ans,point, egal;
    private String input, response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);

        AC = findViewById(R.id.AC);
        power = findViewById(R.id.power);
        back = findViewById(R.id.back);
        zero = findViewById(R.id.zero);
        un = findViewById(R.id.un);
        deux = findViewById(R.id.deux);
        trois = findViewById(R.id.trois);
        quatre = findViewById(R.id.quatre);
        cinq = findViewById(R.id.cinq);
        six = findViewById(R.id.six);
        sept = findViewById(R.id.sept);
        huit = findViewById(R.id.huit);
        neuf = findViewById(R.id.neuf);
        point = findViewById(R.id.point);
        egal = findViewById(R.id.egal);
        Ans = findViewById(R.id.ans);
        plus = findViewById(R.id.plus);
        moins = findViewById(R.id.moins);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);

    }

     public void  ButtonClick(View view)
     {
         Button bouton = (Button)view;
         String data = bouton.getText().toString();
         switch (data)
         {
             case "AC" :
                  input = "";
                  break;

             case "Ans" :
                  input+=response;
                  break;

             case "X" :
                   Solve();
                   input+="*";
                   break;

             case "^" :
                   Solve();
                   input+="^";
                   break;

             case "=" :
                   Solve();
                   response = input;
                   break;

             case "EFF" :
                   String nouvellevaleur = input.substring(0,input.length()-1);
                   input = nouvellevaleur;
                   break;

             default:
                 if(input==null)
                 {
                     input = "";
                 }
                 if(data.equals("+") || data.equals("-") || data.equals("/"))
                 {
                     Solve();
                 }
                 input += data;

         }
         screen.setText(input);
     }

     private void  Solve()
     {
         if(input.split("\\*").length==2)
         {
             String number [] = input.split("\\*");
             try {
                 double multi = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                 input = multi+"";
             }
             catch (Exception e)
             {

             }
         }

         else if(input.split("/").length==2)
         {
             String number [] = input.split("/");
             try {
                 double divi = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                 input = divi+"";
             }
             catch (Exception e)
             {

             }
         }

         else if(input.split("\\^").length==2)
         {
             String number [] = input.split("\\^");
             try {
                 double puiss = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                 input = puiss + "";
             }
             catch (Exception e)
             {

             }
         }

         else if(input.split("\\+").length==2)
         {
             String number [] = input.split("\\+");
             try {
                 double add = Double.parseDouble(number[0])+ Double.parseDouble(number[1]);
                 input =add + "";
             }
             catch (Exception e)
             {

             }
         }

         else if(input.split("-").length>1)
         {
             String number [] = input.split("-");
             if(number[0]=="" && number.length==2)
             {
                 number[0] = 0+"";
             }
             try {
                 double sous = 0;
                 if(number.length==2)
                 {
                     sous = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                 }

                 else if(number.length==3)
                 {
                     sous = Double.parseDouble(number[1])-Double.parseDouble(number[2]);
                 }

                 input = sous+"";
             }
             catch (Exception e)
             {

             }
         }

         String n[] = input.split(".");
         if(n.length>1)
         {
             if(n[1].equals("0"))
             {
               input = n[0];

             }

         }

        screen.setText(input);






     }


}