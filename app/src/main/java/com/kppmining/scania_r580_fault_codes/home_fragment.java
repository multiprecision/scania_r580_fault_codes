/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Samuel I. Gunadi
 */
public class home_fragment extends Fragment {


    public home_fragment() {
        // Required empty public constructor
    }

    public static home_fragment new_instance() {
        return new home_fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
