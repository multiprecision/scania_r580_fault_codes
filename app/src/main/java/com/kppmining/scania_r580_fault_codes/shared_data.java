/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;

import java.util.ArrayList;

/**
 * @author Samuel I. Gunadi
 */
public class shared_data {

    public fault_code result;

    public ArrayList<fault_code> fault_codes;

    public boolean data_loaded;

    protected shared_data() {
        fault_codes = new ArrayList<>();
        data_loaded = false;
    }

    private static final shared_data instance = new shared_data();
    public static shared_data get_instance() {
        return instance;
    }
}