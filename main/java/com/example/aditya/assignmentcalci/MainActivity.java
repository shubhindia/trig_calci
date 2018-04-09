package com.example.aditya.assignmentcalci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    ArrayList<String> arrayList = new ArrayList<String>();
    String string = "";

    public void onClick(View v)
    {
        TextView textView = (TextView)findViewById(R.id.textView);
        EditText editText = (EditText)findViewById(R.id.editText);

        string = editText.getText().toString();
        String string2;
        switch (v.getId())
        {
            case R.id.button1:
                    arrayList.add(string);
                    arrayList.add("+");
                    string="";
                    editText.setText("");
                break;

            case R.id.button2:
                arrayList.add(string);
                arrayList.add("-");
                string="";
                editText.setText("");
                break;

            case R.id.button3:
                arrayList.add(string);
                arrayList.add("*");
                string="";
                editText.setText("");
                break;

            case R.id.button4:
                arrayList.add(string);
                arrayList.add("/");
                string="";
                editText.setText("");
                break;

            case R.id.buttonS:
                arrayList.add("Sin");
                editText.setText("");
                break;

            case R.id.buttonC:
                arrayList.add("Cos");
                editText.setText("");
                break;

            case R.id.buttonsq:
                arrayList.add("Sqroot");
                editText.setText("");
                break;
        }
        string2 = arrayList.toString().replace(",", "")  //remove the commas
            .replace("[", "")  //remove the right bracket
            .replace("]", "")  //remove the left bracket
            .trim();
        textView.setText(string2);
    }

public void onEqual (View v)
{
    TextView textView = (TextView)findViewById(R.id.textView);
    EditText editText = (EditText)findViewById(R.id.editText);
    string =  editText.getText().toString();
    arrayList.add(string);


    double calc = 0;
    int c=arrayList.size();

    String string2 = arrayList.toString().replace(",", "")  //remove the commas
            .replace("[", "")  //remove the right bracket
            .replace("]", "")  //remove the left bracket
            .trim();
    while(c!=1)
    {
        if(c==2)
        {
            if(arrayList.get(0).contains("Sin")) {calc = Math.sin(Double.parseDouble(arrayList.get(1)));}
            if(arrayList.get(0).contains("Cos")) {calc = Math.sin(Double.parseDouble(arrayList.get(1)));}
            if(arrayList.get(0).contains("Sqroot")) {calc = Math.sin(Double.parseDouble(arrayList.get(1)));}

            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, Double.toString(calc));
            c = arrayList.size();
        }
        else if(c == 3)
        {
            if(arrayList.get(1).contains("+")) {calc = Double.parseDouble(arrayList.get(0)) + Double.parseDouble(arrayList.get(2));}
            if(arrayList.get(1).contains("-")) {calc = Double.parseDouble(arrayList.get(0)) - Double.parseDouble(arrayList.get(2));}
            if(arrayList.get(1).contains("*")) {calc = Double.parseDouble(arrayList.get(0)) * Double.parseDouble(arrayList.get(2));}
            if(arrayList.get(1).contains("/")) {calc = Double.parseDouble(arrayList.get(0)) / Double.parseDouble(arrayList.get(2));}

            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, Double.toString(calc));
            c = arrayList.size();
        }

        else {
            for (int i = 0; i < c; i++) {
                if (arrayList.get(i).contains("Sin")) {
                    calc = Math.sin(Double.parseDouble(arrayList.get(i + 1)));
                    arrayList.remove(i);
                    arrayList.remove(i);
                    arrayList.add(i, Double.toString(calc));
                    c = arrayList.size();
                }

                if (arrayList.get(i).contains("Cos")) {
                    calc = Math.cos(Double.parseDouble(arrayList.get(i + 1)));
                    arrayList.remove(i);
                    arrayList.remove(i);
                    arrayList.add(i, Double.toString(calc));
                    c = arrayList.size();
                }

                if (arrayList.get(i).contains("Sqroot")) {
                    calc = Math.sqrt(Double.parseDouble(arrayList.get(i + 1)));
                    arrayList.remove(i);
                    arrayList.remove(i);
                    arrayList.add(i, Double.toString(calc));
                    c = arrayList.size();
                }
            }
            if (c > 3) {

                if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {
                    if (arrayList.get(3).contains("*")) {
                        calc = Double.parseDouble(arrayList.get(2)) * Double.parseDouble(arrayList.get(4));
                    }
                    if (arrayList.get(3).contains("/")) {
                        calc = Double.parseDouble(arrayList.get(2)) / Double.parseDouble(arrayList.get(4));
                    }

                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.add(2, Double.toString(calc));
                    c = arrayList.size();
                } else {
                    if (arrayList.get(1).contains("+")) {
                        calc = Double.parseDouble(arrayList.get(0)) + Double.parseDouble(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("-")) {
                        calc = Double.parseDouble(arrayList.get(0)) - Double.parseDouble(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("*")) {
                        calc = Double.parseDouble(arrayList.get(0)) * Double.parseDouble(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("/")) {
                        calc = Double.parseDouble(arrayList.get(0)) / Double.parseDouble(arrayList.get(2));
                    }

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.add(0, Double.toString(calc));
                    c = arrayList.size();
                }
            }
        }
    }
    string2 = string2 + "=" + Double.toString(calc);
    textView.setText(string2);
    editText.setText("");
    arrayList.clear();
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
}
