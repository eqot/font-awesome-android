package com.eqot.fontawesome;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.text.SpannableStringBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static junit.framework.Assert.assertEquals;

public class FontAwesomeTest {
    private Method convertText;
    private Method getCharacterFromCode;

    private Context mContext;

    @Before
    public void setUp() throws Exception {
        convertText = FontAwesome.class.getDeclaredMethod(
                "convertText", Context.class, CharSequence.class);
        convertText.setAccessible(true);

        getCharacterFromCode = FontAwesome.class.getDeclaredMethod(
                "getCharacterFromCode", Context.class, String.class);
        getCharacterFromCode.setAccessible(true);

        mContext = InstrumentationRegistry.getTargetContext();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void convertTextWithCode() throws Exception {
        SpannableStringBuilder sb = (SpannableStringBuilder) convertText.invoke(null,
                mContext, "foo {fa-thumbs-o-up} bar");
        assertEquals("foo \uf087 bar", sb.toString());
    }

    @Test
    public void convertTextWithTwoCodes() throws Exception {
        SpannableStringBuilder sb = (SpannableStringBuilder) convertText.invoke(null,
                mContext, "foo {fa-thumbs-o-up} bar {fa-smile-o} baz");
        assertEquals("foo \uf087 bar \uf118 baz", sb.toString());
    }

    @Test
    public void convertTextWithoutCode() throws Exception {
        SpannableStringBuilder sb = (SpannableStringBuilder) convertText.invoke(null,
                mContext, "foo");
        assertEquals("foo", sb.toString());
    }

    @Test
    public void getCharacterFromCode() throws Exception {
        String character = (String) getCharacterFromCode.invoke(null, mContext, "fa-thumbs-o-up");
        assertEquals("\uf087", character);
    }
}