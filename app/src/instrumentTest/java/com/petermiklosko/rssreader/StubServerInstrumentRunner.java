package com.petermiklosko.rssreader;

import android.app.Application;
import android.content.Context;
import android.test.InstrumentationTestRunner;

public class StubServerInstrumentRunner extends InstrumentationTestRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return newApplication(cl.loadClass(StubServerApplication.class.getName()), context);
    }
}
