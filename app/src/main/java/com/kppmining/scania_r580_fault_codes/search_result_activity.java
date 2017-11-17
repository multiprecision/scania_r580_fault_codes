/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Samuel I. Gunadi
 */
public class search_result_activity extends AppCompatActivity {
    private static final int CHECK_MENU_ID = Menu.FIRST + 1;
    private static final int COMPONENT_MENU_ID = Menu.FIRST + 2;
    private static final int LOCATION_MENU_ID = Menu.FIRST + 3;
    private static final int CHECK_V_MENU_ID = Menu.FIRST + 4;
    private static final int COMPONENT_V_MENU_ID = Menu.FIRST + 5;
    private static final int LOCATION_V_MENU_ID = Menu.FIRST + 6;
    private static final int CHECK_L_MENU_ID = Menu.FIRST + 7;
    private static final int COMPONENT_L_MENU_ID = Menu.FIRST + 8;
    private static final int LOCATION_L_MENU_ID = Menu.FIRST + 9;
    private static final int CHECK_R_MENU_ID = Menu.FIRST + 10;
    private static final int COMPONENT_R_MENU_ID = Menu.FIRST + 11;
    private static final int LOCATION_R_MENU_ID = Menu.FIRST + 12;
    fault_code data;
    private TextView text_heading;
    private TextView text_description;
    private TextView text_cause;
    private TextView text_notes;
    private TextView text_action;

    public search_result_activity() {
        // Required empty public constructor
    }

    public static search_result_activity new_instance() {
        return new search_result_activity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        text_heading = findViewById(R.id.text_heading);
        text_description = findViewById(R.id.text_description);
        text_cause = findViewById(R.id.text_cause);
        text_notes = findViewById(R.id.text_notes);
        text_action = findViewById(R.id.text_action);

        data = shared_data.get_instance().result;
        text_heading.setText(data.system + data.code + " " + data.heading);
        text_description.setText(data.description);
        text_cause.setText(data.cause);
        text_notes.setText(data.notes);
        text_action.setText(data.action);

        // Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // handle toolbar back button
            case android.R.id.home:
                onBackPressed();
                return true;
            case CHECK_MENU_ID: {
                open_pdf("CODES/" + data.system + "/CHECK/" + data.code + ".pdf");
                return true;
            }
            case COMPONENT_MENU_ID: {
                open_pdf("CODES/" + data.system + "/COMPONENT/" + data.code + ".pdf");
                return true;
            }
            case LOCATION_MENU_ID: {
                open_pdf("CODES/" + data.system + "/LOCATION/" + data.code + ".pdf");
                return true;
            }
            case CHECK_V_MENU_ID: {
                open_pdf("CODES/" + data.system + "/CHECK/" + data.code + "V.pdf");
                return true;
            }
            case COMPONENT_V_MENU_ID: {
                open_pdf("CODES/" + data.system + "/COMPONENT/" + data.code + "V.pdf");
                return true;
            }
            case LOCATION_V_MENU_ID: {
                open_pdf("CODES/" + data.system + "/LOCATION/" + data.code + "V.pdf");
                return true;
            }
            case CHECK_L_MENU_ID: {
                open_pdf("CODES/" + data.system + "/CHECK/" + data.code + "L.pdf");
                return true;
            }
            case COMPONENT_L_MENU_ID: {
                open_pdf("CODES/" + data.system + "/COMPONENT/" + data.code + "L.pdf");
                return true;
            }
            case LOCATION_L_MENU_ID: {
                open_pdf("CODES/" + data.system + "/LOCATION/" + data.code + "L.pdf");
                return true;
            }
            case CHECK_R_MENU_ID: {
                open_pdf("CODES/" + data.system + "/CHECK/" + data.code + "R.pdf");
                return true;
            }
            case COMPONENT_R_MENU_ID: {
                open_pdf("CODES/" + data.system + "/COMPONENT/" + data.code + "R.pdf");
                return true;
            }
            case LOCATION_R_MENU_ID: {
                open_pdf("CODES/" + data.system + "/LOCATION/" + data.code + "R.pdf");
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        try {
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/CHECK")).contains(data.code + ".pdf"))
                menu.add(Menu.NONE, CHECK_MENU_ID, Menu.NONE, "Check");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/COMPONENT")).contains(data.code + ".pdf"))
                menu.add(Menu.NONE, COMPONENT_MENU_ID, Menu.NONE, "Component");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/LOCATION")).contains(data.code + ".pdf"))
                menu.add(Menu.NONE, LOCATION_MENU_ID, Menu.NONE, "Location");

            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/CHECK")).contains(data.code + "V.pdf"))
                menu.add(Menu.NONE, CHECK_V_MENU_ID, Menu.NONE, "Check V");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/COMPONENT")).contains(data.code + "V.pdf"))
                menu.add(Menu.NONE, COMPONENT_V_MENU_ID, Menu.NONE, "Component V");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/LOCATION")).contains(data.code + "V.pdf"))
                menu.add(Menu.NONE, LOCATION_V_MENU_ID, Menu.NONE, "Location V");

            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/CHECK")).contains(data.code + "L.pdf"))
                menu.add(Menu.NONE, CHECK_L_MENU_ID, Menu.NONE, "Check L");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/COMPONENT")).contains(data.code + "L.pdf"))
                menu.add(Menu.NONE, COMPONENT_L_MENU_ID, Menu.NONE, "Component L");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/LOCATION")).contains(data.code + "L.pdf"))
                menu.add(Menu.NONE, LOCATION_L_MENU_ID, Menu.NONE, "Location L");

            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/CHECK")).contains(data.code + "R.pdf"))
                menu.add(Menu.NONE, CHECK_R_MENU_ID, Menu.NONE, "Check R");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/COMPONENT")).contains(data.code + "R.pdf"))
                menu.add(Menu.NONE, COMPONENT_R_MENU_ID, Menu.NONE, "Component R");
            if (Arrays.asList(getAssets().list("CODES/" + data.system + "/LOCATION")).contains(data.code + "R.pdf"))
                menu.add(Menu.NONE, LOCATION_R_MENU_ID, Menu.NONE, "Location R");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private void open_pdf(String path) {
        Intent intent = new Intent(search_result_activity.this, pdf_viewer_activity.class);
        // based on item add info to intent
        Bundle b = new Bundle();
        b.putString("path", path);
        intent.putExtras(b);
        startActivity(intent);
    }

}
