package com.example.piggame;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragrment())
                .commit();
    }
}
