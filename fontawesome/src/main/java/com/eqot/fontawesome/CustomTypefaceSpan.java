package com.eqot.fontawesome;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface mTypeface;

    public CustomTypefaceSpan(String family, Typeface type) {
        super(family);

        mTypeface = type;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeface(ds, mTypeface);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeface(paint, mTypeface);
    }

    private static void applyCustomTypeface(Paint paint, Typeface typeface) {
        final Typeface previousTypeface = paint.getTypeface();
        final int previousStyle = previousTypeface != null ? previousTypeface.getStyle() : 0;

        final int fake = previousStyle & ~typeface.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(typeface);
    }
}
