/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Samuel I. Gunadi
 */
public class search_fragment extends Fragment {
    private static final String[] systems = {"COO", "EMS", "GMS", "RET", "VIS", "ICL", "BMS", "APS", "TCO"};
    private Spinner spinner_system;
    private Button button_search;
    private EditText edit_code;
    private TextView text_not_found;

    public search_fragment() {
        // Required empty public constructor
    }

    public static search_fragment new_instance() {
        return new search_fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        spinner_system = getView().findViewById(R.id.spinner_system);
        button_search = getView().findViewById(R.id.button_search);
        edit_code = getView().findViewById(R.id.edit_code);
        text_not_found = getView().findViewById(R.id.text_not_found);

        // Set spinner values.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, systems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_system.setAdapter(adapter);

        if (shared_data.get_instance().data_loaded) {
            text_not_found.setText("Loaded " + String.valueOf(shared_data.get_instance().fault_codes.size()) + " items.");
        }

        // Set button click listener.
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search through the fault_codes
                int index = -1;
                for (int i = 0; i < shared_data.get_instance().fault_codes.size(); i++) {
                    fault_code row = shared_data.get_instance().fault_codes.get(i);
                    if (row.system.equals(spinner_system.getSelectedItem().toString()) &&
                            row.code.equals(edit_code.getText().toString())) {
                        index = i;
                        break;
                    }
                }
                if (index >= 0) {
                    text_not_found.setText("");
                    shared_data.get_instance().result = shared_data.get_instance().fault_codes.get(index);
                    // start activity
                    Intent intent = new Intent(getActivity(), search_result_activity.class);
                    startActivity(intent);
                } else {
                    text_not_found.setText("Not found!");
                }
            }
        });
    }
}
