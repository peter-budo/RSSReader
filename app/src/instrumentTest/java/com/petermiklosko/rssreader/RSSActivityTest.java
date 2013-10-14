package com.petermiklosko.rssreader;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import static android.test.ViewAsserts.assertOnScreen;

public class RSSActivityTest extends ActivityInstrumentationTestCase2<RSSActivity> {

    private RSSActivity activity;

    public RSSActivityTest() {
        super(RSSActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = this.getActivity();
    }

    public void initialScreenElelements() {
        final View view = decorView();
        assertOnScreen(view, view.findViewById(R.id.empty_view_progress_bar));
    }

    private View decorView() {
        return activity.getWindow().getDecorView();
    }

}
