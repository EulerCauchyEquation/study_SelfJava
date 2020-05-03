package com.string;

import java.util.Arrays;

/**
 * String class
 *
 * @author 송훤출
 * @since 20.05.02
 */
public class MyString {
    private final char[] value;

    public MyString() {
        this("");
    }

    public MyString(char[] value) {
        this.value = value;
    }

    public MyString(String original) {
        this.value = original.toCharArray();
    }

    /**
     * 서브 문자열과 병합하기
     * time - complexity : O(n + m)
     */
    public MyString concat(String subString) {
        if (subString == null) {
            throw new NullPointerException();
        }

        final char[] subValue = subString.toCharArray();
        final int newSize = value.length + subValue.length;
        final char[] newValue = Arrays.copyOf(value, newSize);
        System.arraycopy(subValue, 0, newValue, value.length, subValue.length);
        return new MyString(newValue);
    }

    /**
     * 서브 문자열이 매치되는 첫번째 index 를 찾는다.
     * time - complexity : O(MN)
     */
    public int indexOf(String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        final char[] subValue = str.toCharArray();
        boolean isMatched = false;
        int fromIndex;

        for (fromIndex = 0; fromIndex <= value.length - subValue.length; fromIndex++) {
            isMatched = match(fromIndex, subValue);

            if (isMatched) {
                break;
            }
        }
        return isMatched
                ? fromIndex
                : -1;
    }

    private boolean match(int fromIndex, char[] subValue) {
        for (int i = 0; i < subValue.length; i++) {
            if (value[i + fromIndex] != subValue[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 문자열이 접두사로 시작하는지 체크
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            throw new NullPointerException();
        }

        char[] subValue = prefix.toCharArray();
        return match(0, subValue);
    }

    /**
     * 서브 문자열 가져오기
     */
    public MyString subString(int beginIndex) {
        return subString(beginIndex, value.length);
    }

    public MyString subString(int beginIndex, int endIndex) {
        checkRange(beginIndex);
        final char[] newValue = Arrays.copyOfRange(value, beginIndex, endIndex);
        return new MyString(newValue);
    }

    private void checkRange(int from) {
        if (from < 0 || from >= value.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public MyString trim() {
        int start = 0;
        int end = value.length - 1;

        while (start < end) {
            if (value[start] != ' ') {
                break;
            }
            start++;
        }
        while (start < end) {
            if (value[end] != ' ') {
                break;
            }
            end--;
        }
        return subString(start, end + 1);
    }

    public char[] toCharArray() {
        char[] result = new char[value.length];
        System.arraycopy(value, 0, result, 0, value.length);
        return result;
    }

    @Override
    public boolean equals(Object anotherObj) {
        if (this == anotherObj) {
            return true;
        }

        if (anotherObj instanceof MyString) {
            MyString another = (MyString) anotherObj;

            if (another.value.length == value.length) {
                for (int i = 0; i < another.value.length; i++) {
                    if (another.value[i] != this.value[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
