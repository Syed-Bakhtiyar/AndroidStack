package com.example.syedinkisarahmed.arraystack;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] arr = new int[10];
    int count=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<arr.length;i++){
            arr[i]=0;
        }
    }



    public void add(View v){
        TextView txt = (TextView) findViewById(R.id.value);
        try {
        count++;
            if(Integer.parseInt(txt.getText().toString())==0){
                txt.setText("");
            }else {
                arr[count] = Integer.parseInt(txt.getText().toString());
                txt.setText("");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            Toast.makeText(MainActivity.this, "Stack is full", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Toast.makeText(MainActivity.this, "Only Type Number \n\n Got it?", Toast.LENGTH_SHORT).show();
            txt.setText("");
        }
    }




    public void dlt(View v){
        count--;
    }




    public void display(View v){

        TextView  txt = (TextView) findViewById(R.id.display);
        if(count==arr.length){
            txt.setText("");
            for(int i=0;i<count;i++){
                txt.setText(txt.getText().toString()+arr[i]+"\n");


            }
        }else {
            int countt = 0;
            txt.setText("");
            for (int i = 0; i <= count; i++) {
                txt.setText(txt.getText().toString() + arr[i] + "\n");
                countt++;

            }
            if (countt == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("There is no data");
                builder.show();
            }
        }
    }



    public void reset(View v){
        count=-1;
    }


}
