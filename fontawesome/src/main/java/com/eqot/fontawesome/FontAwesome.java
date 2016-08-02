package com.eqot.fontawesome;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class FontAwesome {
    private static final String FONT_FILENAME = "fontawesome-webfont.ttf";

    public static void apply(Context context, View view) {
        final Typeface font = Typeface.createFromAsset(context.getAssets(), FONT_FILENAME);
        ((TextView) view).setTypeface(font);
    }
}
