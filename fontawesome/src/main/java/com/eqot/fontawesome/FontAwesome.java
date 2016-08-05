package com.eqot.fontawesome;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FontAwesome {
    private static final String FONT_FILENAME = "fontawesome-webfont.ttf";

    private static Typeface sTypeface = null;
    private static final Pattern pattern = Pattern.compile("\\{([\\w\\-]+)\\}");

    public static void apply(Context context, View view) {
        setFont(context, view);
        replaceText(context, view);
    }

    private static void setFont(Context context, View view) {
        if (sTypeface == null) {
            sTypeface = Typeface.createFromAsset(context.getAssets(), FONT_FILENAME);
        }

        final TextView textView = (TextView) view;
        textView.setTypeface(sTypeface);
    }

    private static void replaceText(Context context, View view) {
        final TextView textView = (TextView) view;
        String text = (String) textView.getText();

        final Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            final String orgCode = matcher.group(1);
            final String code = orgCode.replace("-", "_");

            final int id = context.getResources().getIdentifier(code, "string", context.getPackageName());
            final String string = context.getResources().getString(id);

            text = text.replace("{" + orgCode + "}", string);
        }

        textView.setText(text);
    }
}
