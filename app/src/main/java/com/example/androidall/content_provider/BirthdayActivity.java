package com.example.androidall.content_provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidall.R;

/**
 * Created by DELL PC on 7/14/2016.
 */
public class BirthdayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
    }

    public void deleteAllBirthdays (View view) {
        // delete all the records and the table of the database provider
        String URL = "content://com.javacodegeeks.provider.Birthday/friends";
        Uri friends = Uri.parse(URL);
        int count = getContentResolver().delete(
                friends, null, null);
        String countNum = "Javacodegeeks: "+ count +" records are deleted.";
        Toast.makeText(getBaseContext(),
                countNum, Toast.LENGTH_LONG).show();

    }

    public void addBirthday(View view) {
        // Add a new birthday record
        ContentValues values = new ContentValues();

        values.put(BirthdayProvider.NAME,
                ((EditText)findViewById(R.id.name)).getText().toString());

        values.put(BirthdayProvider.BIRTHDAY,
                ((EditText)findViewById(R.id.birthday)).getText().toString());

        Uri uri = getContentResolver().insert(
                BirthdayProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                "Javacodegeeks: " + uri.toString() + " inserted!", Toast.LENGTH_LONG).show();
    }


    public void showAllBirthdays(View view) {
        // Show all the birthdays sorted by friend's name
        String URL = "content://com.javacodegeeks.provider.Birthday/friends";
        Uri friends = Uri.parse(URL);
        Cursor c = getContentResolver().query(friends, null, null, null, "name");
        String result = "Javacodegeeks Results:";

        if (!c.moveToFirst()) {
            Toast.makeText(this, result+" no content yet!", Toast.LENGTH_LONG).show();
        }else{
            do{
                result = result + "\n" + c.getString(c.getColumnIndex(BirthdayProvider.NAME)) +
                        " with id " +  c.getString(c.getColumnIndex(BirthdayProvider.ID)) +
                        " has birthday: " + c.getString(c.getColumnIndex(BirthdayProvider.BIRTHDAY));
            } while (c.moveToNext());
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }

    }
}
