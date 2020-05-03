package com.stringbuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * StringBuilder test
 *
 * @author 송훤출
 * @since 20.05.03
 */
public class StringBuilderTest {
    private MyStringBuilder sb;

    @Before
    public void setUp() {
        sb = new MyStringBuilder("abcde");
    }

    @Test
    public void testAppend() {
        sb.append("fghi");

        Assert.assertThat(sb.toString(), is("abcdefghi"));
    }

    @Test
    public void testInsert() {
        sb.insert(2, "fghi");

        Assert.assertThat(sb.toString(), is("abfghicde"));
    }
}
