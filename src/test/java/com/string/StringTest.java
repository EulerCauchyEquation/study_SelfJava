package com.string;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * String class test
 *
 * @author 송훤출
 * @since 20.05.02
 */
public class StringTest {

    @Test
    public void testStringConcat() {
        MyString str = new MyString("abcde");

        Assert.assertThat(str.concat(""), is(new MyString("abcde")));
        Assert.assertThat(str.concat("fghi"), is(new MyString("abcdefghi")));
    }

    @Test
    public void testIndexOf() {
        MyString str = new MyString("abcdef");

        Assert.assertThat(str.indexOf("cde"), is(2));
        Assert.assertThat(str.indexOf("gf"), is(-1));
    }

    @Test
    public void testStartsWith() {
        MyString str = new MyString("abcdef");

        Assert.assertThat(str.startsWith("cde"), is(false));
        Assert.assertThat(str.startsWith("abc"), is(true));
    }

    @Test
    public void testSubString() {
        MyString str = new MyString("abcdef");

        Assert.assertThat(str.subString(2), is(new MyString("cdef")));
    }

    @Test
    public void testTrim() {
        MyString str = new MyString(" abc def   ");

        Assert.assertThat(str.trim(), is(new MyString("abc def")));
    }

    @Test
    public void testToCharArray() {
        MyString str = new MyString("abcde");

        Assert.assertThat(str.toCharArray(), is(new char[]{'a', 'b', 'c', 'd', 'e'}));
    }
}
