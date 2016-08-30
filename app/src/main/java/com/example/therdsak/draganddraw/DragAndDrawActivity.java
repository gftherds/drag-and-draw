package com.example.therdsak.draganddraw;

import android.support.v4.app.Fragment;

/**
 * Created by Therdsak on 8/30/2016.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {
    @Override
    protected Fragment onCreateFragment() {
        return DragAndDrawFragment.newInstance();
    }
}
