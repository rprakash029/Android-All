package com.example.androidall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidall.activity.TransitionsActivity1;
import com.example.androidall.animation.AnimationActivity;
import com.example.androidall.bluetooth.BluetoothActivity;
import com.example.androidall.broadcast_reciever.BroadcastActivity;

public class MainActivity extends AppCompatActivity {
    private static final String EMPTY_STRING = "";

    private EditText searchEditText;
    private RadioButton moviesSearchRadioButton;
    private RadioButton peopleSearchRadioButton;
    private RadioGroup searchRadioGroup;
    private TextView searchTypeTextView;
    private Button searchButton;
    private View.OnClickListener radioButtonListener = new View.OnClickListener() {

        public void onClick(View v) {

            RadioButton radioButton = (RadioButton) v;

            searchTypeTextView.setText(radioButton.getText());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findAllViewsById();

        moviesSearchRadioButton.setOnClickListener(radioButtonListener);

        peopleSearchRadioButton.setOnClickListener(radioButtonListener);

        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String query = searchEditText.getText().toString();

                if (moviesSearchRadioButton.isChecked()) {

                    longToast(moviesSearchRadioButton.getText() + " " + query);

                } else if (peopleSearchRadioButton.isChecked()) {

                    longToast(peopleSearchRadioButton.getText() + " " + query);

                }

            }

        });

        searchEditText.setOnFocusChangeListener(new DftTextOnFocusListener(getString(R.string.search)));

        int id = searchRadioGroup.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) findViewById(id);

        searchTypeTextView.setText(radioButton.getText());

    }

    private void findAllViewsById() {

        searchEditText = (EditText) findViewById(R.id.search_edit_text);

        moviesSearchRadioButton = (RadioButton) findViewById(R.id.movie_search_radio_button);

        peopleSearchRadioButton = (RadioButton) findViewById(R.id.people_search_radio_button);

        searchRadioGroup = (RadioGroup) findViewById(R.id.search_radio_group);

        searchTypeTextView = (TextView) findViewById(R.id.search_type_text_view);

        searchButton = (Button) findViewById(R.id.search_button);
    }

    public void longToast(CharSequence message) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // menu button settings
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_menu:
                startActivity(new Intent(this, TransitionsActivity1.class));
                break;
            case R.id.animation_menu:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case R.id.bluetooth_menu:
                startActivity(new Intent(this, BluetoothActivity.class));
                break;
            case R.id.broadcast_menu:
                startActivity(new Intent(this, BroadcastActivity.class));
break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DftTextOnFocusListener implements View.OnFocusChangeListener {

        private String defaultText;

        public DftTextOnFocusListener(String defaultText) {

            this.defaultText = defaultText;

        }

        public void onFocusChange(View v, boolean hasFocus) {

            if (v instanceof EditText) {

                EditText focusedEditText = (EditText) v;

                // handle obtaining focus

                if (hasFocus) {

                    if (focusedEditText.getText().toString().equals(defaultText)) {

                        focusedEditText.setText(EMPTY_STRING);

                    }

                }

                // handle losing focus

                else {

                    if (focusedEditText.getText().toString().equals(EMPTY_STRING)) {

                        focusedEditText.setText(defaultText);

                    }

                }

            }

        }

    }
}
