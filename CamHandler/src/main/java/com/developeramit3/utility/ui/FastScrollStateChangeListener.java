
package com.developeramit3.utility.ui;
import com.developeramit3.Handler.CameraHandler;
/*
 *Created by amit on 30/07/20.
 */
public interface FastScrollStateChangeListener {

    /**
     * Called when fast scrolling begins
     */
    void onFastScrollStart(CameraHandler fastScroller);

    /**
     * Called when fast scrolling ends
     */
    void onFastScrollStop(CameraHandler fastScroller);
}
