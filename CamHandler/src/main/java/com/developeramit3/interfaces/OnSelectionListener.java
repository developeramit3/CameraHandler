package com.developeramit3.interfaces;

import android.view.View;

import com.developeramit3.modals.Img;

/*
 *Created by amit on 30/07/20.
 */


public interface OnSelectionListener {
    void onClick(Img Img, View view, int position);

    void onLongClick(Img img, View view, int position);
}
