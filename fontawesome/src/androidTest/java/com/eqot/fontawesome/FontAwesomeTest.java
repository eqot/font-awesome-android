package com.eqot.fontawesome;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.text.SpannableStringBuilder;

import com.eqot.fontawesome.xray.FontAwesome$Xray;
import com.eqot.xray.Xray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

@Xray(FontAwesome.class)
public class FontAwesomeTest {
    private Context mContext;

    @Before
    public void setUp() throws Exception {
        mContext = InstrumentationRegistry.getTargetContext();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convertTextWithCode() throws Exception {
        SpannableStringBuilder sb = FontAwesome$Xray.convertText(mContext,
                "foo {fa-thumbs-o-up} bar");
        assertEquals("foo \uf087 bar", sb.toString());
    }

    @Test
    public void convertTextWithTwoCodes() throws Exception {
        SpannableStringBuilder sb = FontAwesome$Xray.convertText(mContext,
                "foo {fa-thumbs-o-up} bar {fa-smile-o} baz");
        assertEquals("foo \uf087 bar \uf118 baz", sb.toString());
    }

    @Test
    public void convertTextWithoutCode() throws Exception {
        SpannableStringBuilder sb = FontAwesome$Xray.convertText(mContext, "foo");
        assertEquals("foo", sb.toString());
    }

    @Test
    public void getCharacterFromCode() throws Exception {
        String character = FontAwesome$Xray.getCharacterFromCode(mContext, "fa-thumbs-o-up");
        assertEquals("\uf087", character);
    }
}
