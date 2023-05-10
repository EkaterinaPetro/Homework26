package com.homework__26.homework26;

public class StringListImpl implements StringList{

    private final String[] stringArr;
    private int size = 0;

    public StringListImpl(int size) {
        stringArr = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullItemException();
        }

        if (size < stringArr.length) {
            stringArr[size] = item;
            size++;
            return item;
        }
        throw new ListIsFullException();
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullItemException();
        }

        if (index >= stringArr.length || index > size) {
            throw new IndexOutOfBoundException();
        }

        if (stringArr[stringArr.length - 1] != null) {
            throw new ListIsFullException();
        }

        for (int i = size - 1; i >= index; i--) {
            stringArr[i + 1] = stringArr[i];
        }
        stringArr[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullItemException();
        }

        if (index >= size) {
            throw new IndexOutOfBoundException();
        }

        stringArr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullItemException();
        }

        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (stringArr[i].equals(item)) {
                stringArr[i] = null;
                found = true;
            }

            if (found) {
                stringArr[i] = stringArr[i + 1];
            }
        }

        if (found) {
            size--;
            return item;
        }
        throw new ItemNotFoundException();
    }

    @Override
    public String remove(int index) {
        if (stringArr[index] == null) {
            throw new ItemNotFoundException();
        }

        String item = stringArr[index];
        stringArr[index] = null;

        for (int i = index; i < size; i++) {
            stringArr[i] = stringArr[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new NullItemException();
        }

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new NullItemException();
        }

        for (int i = 0; i < size; i++) {
            if (stringArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullItemException();
        }

        for (int i = size - 1; i >= 0; i--) {
            if (stringArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundException();
        }

        return stringArr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullListException();
        }

        if (size != otherList.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!stringArr[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            stringArr[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];

        System.arraycopy(stringArr, 0, array, 0, size);
        return array;
    }
}
