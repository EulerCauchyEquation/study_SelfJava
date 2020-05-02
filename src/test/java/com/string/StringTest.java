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

        Assert.assertThat(str.startsWith("cde"), is(2));
        Assert.assertThat(str.startsWith("gf"), is(-1));
    }

    @Test
    public void testValueOf() {
        MyString str = MyString.valueOf(100);

        Assert.assertThat(str, is(new MyString("100")));
    }

    @Test
    public void testSubString() {
        MyString str = new MyString("abcdef");

        Assert.assertThat(str.subString(2), is(new MyString("cdef")));
    }

    @Test
    public void testSplit() {
        MyString str = new MyString("ab cd ef");

        MyString[] result = {
                new MyString("ab"),
                new MyString("cd"),
                new MyString("ef")};

        Assert.assertThat(str.split(" "), is(result));
    }

    @Test
    public void testTrim() {
        MyString str = new MyString("ab cd ef");

        Assert.assertThat(str.trim(), is(new MyString("abcdef")));
    }

    @Test
    public void testToCharArray() {
        MyString str = new MyString("abcde");

        Assert.assertThat(str.toCharArray(), is(new char[]{'a', 'b', 'c', 'd', 'e'}));
    }


    // equals
    // toString
}
