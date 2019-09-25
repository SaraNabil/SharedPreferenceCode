package com.example.pc.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.ediText);
        textView = findViewById(R.id.textView);
        pref = getSharedPreferences("myPref", MODE_PRIVATE);
    }

    public void save(View view) {
        String username = editText.getText().toString();
        editor = pref.edit();
        editor.putString("username", username);
//        editor.putInt("num",100);
        editor.apply();

        editText.setText("");

    }

    public void retrieve(View view) {
//        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
        String username = pref.getString("username", "");
//        String num = Integer.toString(pref.getInt("num",0));
//        textView.setText(username + "\n" + num);
        textView.setText(username);

    }

    public void clear(View view) {
        editor.clear();
        editor.apply();

    }

}
