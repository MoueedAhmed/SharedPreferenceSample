package com.example.sharedpreferencesample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextName,editTextPhone,editTextEmail;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String m_name = "name";
    public static final String m_phone = "phone";
    public static final String m_email = "email";

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName=(EditText)findViewById(R.id.editText);
        editTextPhone=(EditText)findViewById(R.id.editText2);
        editTextEmail=(EditText)findViewById(R.id.editText3);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }
    public void readButtonPressed(View view) {
        String name  = sharedPreferences.getString(m_name, "");
        String phone  = sharedPreferences.getString(m_phone, "");
        String email  = sharedPreferences.getString(m_email, "");

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(name + "\n" + phone + "\n" + email + "\n");
    }

    public void saveButtonPressed(View v)
    {
        String name  = editTextName.getText().toString();
        String phone  = editTextPhone.getText().toString();
        String email  = editTextEmail.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(m_name, name);
        editor.putString(m_phone, phone);
        editor.putString(m_email, email);

        editor.commit();
    }
}
