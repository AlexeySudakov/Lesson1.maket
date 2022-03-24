package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

//    private Switch Switch1;

    private CheckBox CheckBox1;  // Вариант 1. Для использования в работе методов Checkbox позволяющих получать ответ,
    private CheckBox CheckBox2;  // какие галочки выбраны в списке Checkbox при нажатии на кнопку Результаты (btn_res)
    private CheckBox CheckBox3;  // Методы btn_res1.setOnClickListener, showResult и checkAllCheckedChange
//    private TextView TextForToggle;
//    private Object ToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Switch Switch1 = findViewById( R.id.Switch1 );
//        EditText EditText1 = findViewById( R.id.EditText1 );
//        Button btn1 = findViewById( R.id.btn1 );
//        Button btn2 = findViewById( R.id.btn2 );
//        Button btn3 = findViewById( R.id.btn3 );
        this.CheckBox1 = this.findViewById( R.id.checkbox1 ); // Для варианта 1
        this.CheckBox2 = this.findViewById( R.id.checkbox2 ); // Для варианта 1
        this.CheckBox3 = this.findViewById( R.id.checkbox3 ); // Для варианта 1
        Button btn_res1 = this.findViewById( R.id.btn_result ); // Для варианта 1
//        ToggleButton = (ToggleButton) findViewById( R.id.ToggleButton1 );
//        TextForToggle = (TextView) findViewById( R.id.TextForToggle );


        Switch1.setBackgroundColor( Color.blue( 1 ) );
        Switch1.setOnClickListener( view -> {
            String statusSwitch1;
            if (Switch1.isChecked())
                statusSwitch1 = Switch1.getTextOn().toString();
            else
                statusSwitch1 = Switch1.getTextOff().toString();
            Toast.makeText( getApplicationContext(), "Switch1 :" + statusSwitch1 + "\n", Toast.LENGTH_LONG ).show();

        } );

        btn_res1.setOnClickListener( new View.OnClickListener() {  // Для варианта 1

            @Override
            public void onClick(View view) {
                showResult();
            }
        } );
    }

    private void showResult() {                               // Для варианта 1
        String message = null;
        if (this.CheckBox1.isChecked()) {
            message = this.CheckBox1.getText().toString();
        }
        if (this.CheckBox2.isChecked()) {
            if (message == null) {
                message = this.CheckBox2.getText().toString();
            } else {
                message += "," + this.CheckBox2.getText().toString();
            }
        }
        if (this.CheckBox3.isChecked()) {
            if (message == null) {
                message = this.CheckBox3.getText().toString();
            } else {
                message += "," + this.CheckBox3.getText().toString();
            }

        }
        message = message == null ? "Вы ничего не выбрали" : "Вы выбрали: " + message;
        Toast.makeText( this, message, Toast.LENGTH_LONG ).show();

    }

    private void checkAllCheckedChange(boolean isChecked) {       // Для варианта 1
        this.CheckBox1.setChecked( isChecked );
        this.CheckBox2.setChecked( isChecked );
        this.CheckBox3.setChecked( isChecked );
    }

    //         Вариант 2. Для использования Checkbox позволяющих получать всплывающую подсказку при,
//         включении галочки в списке Checkbox
    public void onCheckboxClicked(View view) {

        CheckBox checkBox = (CheckBox) view;
        boolean checked = checkBox.isChecked();
        TextView selection = findViewById( R.id.selection );

        switch (view.getId()) {
            case R.id.checkbox1:
                if (checked)
                    Toast.makeText( this, "Вы выбрали Поп ", Toast.LENGTH_LONG ).show();
                break;
            case R.id.checkbox2:
                if (checked)
                    Toast.makeText( this, "Вы выбрали Рок", Toast.LENGTH_LONG ).show();
                break;
            case R.id.checkbox3:
                if (checked)
                    Toast.makeText( this, "Вы выбрали Панк", Toast.LENGTH_LONG ).show();
                break;
            default:                            //Не обязательное для использования поле
                selection.setText( "охохо" );     //
        }
    }


}












