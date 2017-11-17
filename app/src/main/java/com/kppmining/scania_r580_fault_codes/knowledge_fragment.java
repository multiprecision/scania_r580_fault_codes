/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Samuel I. Gunadi
 */
public class knowledge_fragment extends Fragment {

    ListView list_view;

    public knowledge_fragment() {
        // Required empty public constructor
    }

    public static knowledge_fragment new_instance() {
        return new knowledge_fragment();
    }

    @Override
    public void onCreate(Bundle saved_instance_state) {
        super.onCreate(saved_instance_state);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saved_instance_state) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_knowledge, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        list_view = getView().findViewById(R.id.knowledge_list_view);

        AssetManager asset_mgr = getActivity().getAssets();

        ArrayList<String> pdf_list = null;
        try {
            pdf_list = new ArrayList<>(Arrays.asList(asset_mgr.list("KNOWLEDGE")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, pdf_list);
        list_view.setAdapter(adapter);
        list_view.setClickable(true);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                String item = (String) adapter.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), pdf_viewer_activity.class);
                // based on item add info to intent
                Bundle b = new Bundle();
                b.putString("path", "KNOWLEDGE/" + item);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
