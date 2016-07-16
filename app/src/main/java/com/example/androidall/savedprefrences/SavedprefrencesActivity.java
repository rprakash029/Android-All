package com.example.androidall.savedprefrences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class SavedprefrencesActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkBox;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedprefrences);

        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
        loadSavedPreferences();
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        String name = sharedPreferences.getString("storedName", "YourName");
        if (checkBoxValue) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }

        editText.setText(name);
    }

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        savePreferences("CheckBox_Value", checkBox.isChecked());
        if (checkBox.isChecked())
            savePreferences("storedName", editText.getText().toString());

        finish();
    }
}
