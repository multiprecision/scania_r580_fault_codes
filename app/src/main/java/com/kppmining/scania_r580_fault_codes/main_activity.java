/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author Samuel I. Gunadi
 */
public class main_activity extends AppCompatActivity {

    Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load_fault_codes();

        // Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scania R580 Fault Codes");


        if (savedInstanceState == null) {
            Fragment f = home_fragment.new_instance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
        }

        // create the drawer
        drawer = new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(0).withName("Home"),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withIdentifier(1).withName("Search"),
                        new PrimaryDrawerItem().withIdentifier(2).withName("Knowledge"),
                        new PrimaryDrawerItem().withIdentifier(3).withName("Wiring Diagram"),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withIdentifier(4).withName("Company Profile"),
                        new PrimaryDrawerItem().withIdentifier(5).withName("About")
                )
                .withToolbar(toolbar)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 0: {
                                getSupportActionBar().setTitle("Scania R580 Fault Codes");
                                Fragment f = home_fragment.new_instance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                break;
                            }
                            case 1: {
                                toolbar.setTitle("Search");
                                Fragment f = search_fragment.new_instance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                break;
                            }
                            case 2: {
                                toolbar.setTitle("Knowledge");
                                Fragment f = knowledge_fragment.new_instance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                break;
                            }
                            case 3: {
                                toolbar.setTitle("Wiring Diagram");
                                Fragment f = wiring_diagram_fragment.new_instance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                break;
                            }
                            case 4: {
                                toolbar.setTitle("Company Profile");
                                Fragment f = profile_fragment.new_instance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                break;
                            }
                            case 5: {
                                toolbar.setTitle("About");
                                Fragment f = about_fragment.new_instance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                                break;
                            }
                            default:
                                ;
                        }
                        return false;
                    }
                })
                .build();
    }

    @Override
    public void onBackPressed() {
        // close the drawer first
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void load_fault_codes() {
        // Load fault_codes from JSON.
        if (!shared_data.get_instance().data_loaded) {
            // Read fault_codes.jsones.json from raw resources.
            InputStream istream = getResources().openRawResource(R.raw.fault_codes);
            ByteArrayOutputStream ostream = new ByteArrayOutputStream();

            int next;
            try {
                next = istream.read();
                while (next != -1) {
                    ostream.write(next);
                    next = istream.read();
                }
                istream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                shared_data.get_instance().data_loaded = false;
            }

            // Parse JSON.
            try {
                JSONObject json_obj = new JSONObject(ostream.toString());
                JSONArray json_arr = json_obj.getJSONArray("fault_codes");
                for (int i = 0; i < json_arr.length(); i++) {
                    fault_code data = new fault_code();
                    data.system = json_arr.getJSONObject(i).getString("system");
                    data.code = json_arr.getJSONObject(i).getString("code");
                    data.heading = json_arr.getJSONObject(i).optString("heading");
                    data.description = json_arr.getJSONObject(i).optString("description");
                    data.cause = json_arr.getJSONObject(i).optString("cause");
                    data.notes = json_arr.getJSONObject(i).optString("notes");
                    data.action = json_arr.getJSONObject(i).optString("action");
                    shared_data.get_instance().fault_codes.add(data);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                shared_data.get_instance().data_loaded = false;
            }

            shared_data.get_instance().data_loaded = true;
        }
    }
}
