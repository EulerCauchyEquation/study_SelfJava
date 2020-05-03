package com.stringbuilder;

import java.util.Arrays;

/**
 * StringBuilder class
 *
 * @author 송훤출
 * @since 20.05.03
 */
public class MyStringBuilder {
    private static final int DEFAULT_CAPACITY = 1 << 2;

    private char[] value;
    private int size;

    public MyStringBuilder() {
        this.value = new char[DEFAULT_CAPACITY];
    }

    public MyStringBuilder(String original) {
        this.value = original.toCharArray();
        this.size = original.length();
    }

    public void append(String subString) {
        final char[] subValue = subString.toCharArray();
        ensureCapacity(size + subValue.length);

        System.arraycopy(subValue, 0, value, size, subValue.length);
        size += subValue.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - value.length < 0) {
            return;
        }
        int newCapacity = minCapacity + (minCapacity << 1);
        value = Arrays.copyOf(value, newCapacity);
    }

    public void insert(int fromIndex, String subString) {
        checkRange(fromIndex);

        final char[] subValue = subString.toCharArray();
        ensureCapacity(size + subValue.length);
        System.arraycopy(value, fromIndex, value, fromIndex + subValue.length, size - fromIndex);
        System.arraycopy(subValue, 0, value, fromIndex, subValue.length);

        size += subValue.length;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return new String(value, 0, size);
    }
}
