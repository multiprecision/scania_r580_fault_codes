/*
 * Copyright (c) 2017 Samuel Ivan Gunadi.
 * All rights reserved.
 */

package com.kppmining.scania_r580_fault_codes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * @author Samuel I. Gunadi
 */
public class about_fragment extends Fragment {

    public about_fragment() {
        // Required empty public constructor
    }

    public static about_fragment new_instance() {
        return new about_fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        WebView web_view = getView().findViewById(R.id.web_view_about);
        web_view.loadData("<!doctype html><html lang=\"en-US\"><head> <meta charset=\"utf-8\"></head><body style=\"font-family: sans-serif; margin: 20px; padding: 0px;\"> <div style=\"position: relative;\"> <div style=\"margin: 0px; text-align: justify;\"> <p>Aplikasi smartphone ini dibuat hanya untuk kalangan sendiri, dan tidak untuk dikomersilkan atau disebarluaskan. Aplikasi ini dibuat untuk memudahkan mekanik dan mempercepat proses perbaikan jika ditemukan error codes pada unit Scania Type R580.</p> <p style=\"text-indent: 24px;\">Terima kasih kepada seluruh manajemen, group leader, mekanik Site PDRO serta khususnya kepada Bapak Oktavian Tony Arianto selaku Project Manager dimana telah mendukung diluncurkannya aplikasi smartphone ini.</p> <p style=\"text-indent: 24px;\">Segala kekurangan yang ada pada aplikasi Android ini akan terus diperbaiki dan diimprove sesuai fungsinya, dan semoga segala yang telah kita buat memberikan manfaat untuk kita semua dan membantu meningkatkan produktivitas.</p> </div> <div style=\"float: right; display: table; text-align: center;\"> Salam, <br> <b>Margian</b> <br> Mechanic instructor <br> Site PDRO </div> <div style=\"clear: both;\"></div> <div style=\"margin-top: 24px;\"> Version 2.0.0 <br>Cover Design by Aswin Adhrian <p style=\"color: #006400; margin: 0; text-align: center;\"> <b>Copyright (c) 2017 PT. KPP SITE PDRO.</b> </p> </div> </div></body></html>", "text/html", "utf-8");
    }
}
