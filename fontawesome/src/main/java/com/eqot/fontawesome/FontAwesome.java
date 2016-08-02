package com.eqot.fontawesome;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class FontAwesome {
    private static final String FONT_FILENAME = "fontawesome-webfont.ttf";

    private static Typeface sTypeface = null;

    public static void apply(Context context, View view) {
        if (sTypeface == null) {
            sTypeface = Typeface.createFromAsset(context.getAssets(), FONT_FILENAME);
        }

        ((TextView) view).setTypeface(sTypeface);
    }
}
