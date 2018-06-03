package com.example.suraj.mycalculator3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    int bracketTemp = 0;
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;
    Button but7;
    Button but8;
    Button but9;
    Button butPlus;
    Button butMinus;
    Button butMultiply;
    Button butDivide;
    Button butCLEAR;
    Button butBackspace;
    Button butBrackets;
    Button butEqual;
    Button butDot;
    Button but0;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = (Button) findViewById(R.id.button1);
        but2 = (Button) findViewById(R.id.button2);
        but3 = (Button) findViewById(R.id.button3);
        but4 = (Button) findViewById(R.id.button4);
        but5 = (Button) findViewById(R.id.button5);
        but6 = (Button) findViewById(R.id.button6);
        but7 = (Button) findViewById(R.id.button7);
        but8 = (Button) findViewById(R.id.button8);
        but9 = (Button) findViewById(R.id.button9);
        butPlus = (Button) findViewById(R.id.buttonPlus);
        butMinus = (Button) findViewById(R.id.buttonMinus);
        butMultiply = (Button) findViewById(R.id.buttonMultiply);
        butDivide = (Button) findViewById(R.id.buttonDivide);
        butCLEAR = (Button) findViewById(R.id.buttonCLEAR);
        butBackspace = (Button) findViewById(R.id.buttonBackspace);
        butBrackets = (Button) findViewById(R.id.buttonBrackets);
        butEqual = (Button) findViewById(R.id.buttonEqual);
        butDot = (Button) findViewById(R.id.buttonDot);
        but0 = (Button) findViewById(R.id.button0);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView2);
        but0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });
        but1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });
        but2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });
        but3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });
        but4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "4");
            }
        });
        but5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "5");
            }
        });
        but6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "6");
            }
        });
        but7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "7");
            }
        });
        but8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "8");
            }
        });
        but9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "9");
            }
        });
        butDot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + ".");
            }
        });
        butDivide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "/");
            }
        });
        butMultiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "*");
            }
        });
        butPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "+");
            }
        });
        butMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "-");
            }
        });
        butBackspace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText((editText.getText().toString()).substring(0, editText.getText().length() - 1));
            }
        });
        butCLEAR.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                textView.setText("");
            }
        });
        butBrackets.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bracketTemp % 2 == 0)
                    editText.setText( editText.getText().toString()+"(" );
                else
                    editText.setText( editText.getText().toString()+")");
                bracketTemp++;
            }
        });
        butEqual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().isEmpty())
                    textView.setText("");
                else {
                    double temp = equalTo(editText.getText().toString());
                    if ((temp - (int) temp) > 0)
                        textView.setText(Double.toString(temp));
                    else
                        textView.setText(Integer.toString((int) temp));
                }
                editText.setText("");
            }
        });


    }
    public double operate1(LinkedList s1,LinkedList s2) {
        String[] list1=(String[]) s1.toArray(new String[s1.size()]);
        String[] list2=(String[]) s2.toArray(new String[s2.size()]);
        System.out.println(list1);
        System.out.println(list2);
        double  sum=0.0d;
        sum=(Double.parseDouble(list1[0]));//lit1.next());
        for(int m=0;m<list2.length;m++)
        {
            Double j=(Double.parseDouble(list1[m+1]));
            String op=list2[m];
            if(op.equals(new String("+")))
            {
                sum=sum+j.doubleValue();
            }
            else if(op.equals(new String("-")))
            {
                sum=sum-j.doubleValue();
            }
            else if(op.equals(new String("*")))
            {
                sum=sum*j.doubleValue();
            }
            else if(op.equals(new String("/")))
            {
                sum=sum/j.doubleValue();
            }
        }
        return sum;
    }
    public LinkedList divideAStringToNumbers(String p) {
        LinkedList list=new LinkedList();
        int opPos=0;
        for(int i=0;i<p.length();i++)
        {
            while(i<p.length()&&(p.charAt(i)=='0'||p.charAt(i)=='1'||p.charAt(i)=='2'||p.charAt(i)=='3'||p.charAt(i)=='4'||p.charAt(i)=='5'||p.charAt(i)=='6'||p.charAt(i)=='7'||p.charAt(i)=='8'||p.charAt(i)=='9'||p.charAt(i)=='.'))
            {
                i++;
            }
            if(i==0)
            {
                String k=new String("0.0");
                list.addLast(k);
            }
            else
                list.addLast(p.substring(opPos,i));
            opPos=i+1;
        }
        return list;
    }
    public LinkedList findAllTheOperators(String p) {
        LinkedList list=new LinkedList();
        int i=0;
        while(i<p.length())
        {
            while(i<p.length()&&(p.charAt(i)=='0'||p.charAt(i)=='1'||p.charAt(i)=='2'||p.charAt(i)=='3'||p.charAt(i)=='4'||p.charAt(i)=='5'||p.charAt(i)=='6'||p.charAt(i)=='7'||p.charAt(i)=='8'||p.charAt(i)=='9'))
            {
                i++;
            }
            if(i<p.length())
                list.addLast(new String((p.substring(i,i+1))));
            i++;
        }
        return list;
    }
    public double equalTo(String p) {
        int stSize=p.length();
        for(int i=0;i<stSize;i++)
        {
            if(p.charAt(i)=='(')
            {
                for (int j=(stSize-1);j>=0;j--)
                {
                    if(p.charAt(j)==')')
                    {
                        String newString=p.substring(0,i)+(Integer.toString((int)equalTo(p.substring(i+1,j))))+p.substring(j+1,p.length());
                        System.out.println(newString);
                        return (operate1(divideAStringToNumbers(newString),findAllTheOperators(newString)));
                    }
                }
            }
        }
        return (operate1(divideAStringToNumbers(p),findAllTheOperators(p)));
    }


}
