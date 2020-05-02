package com.string;

/**
 * String class
 *
 * @author 송훤출
 * @since 20.05.02
 */
public class MyString {
    private final char[] str;

    public MyString() {
        this("");
    }

    public MyString(String original) {
        this.str = original.toCharArray();
    }

    public static MyString valueOf(int i) {
        return null;
    }

    public int indexOf(String str) {
        return 0;
    }

    public int startsWith(String str) {
        return 0;
    }

    public MyString subString(int from) {
        return null;
    }

    public MyString[] split(String original) {
        return null;
    }

    public MyString trim() {
        return null;
    }

    public char[] toCharArray() {
        return new char[0];
    }
}
