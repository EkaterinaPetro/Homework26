package com.homework__26.homework26;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{

    private Integer[] integerArr;
    private int size = 0;

    public IntegerListImpl(int size) {
        integerArr = new Integer[size];
    }
    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        if (size < integerArr.length) {
            integerArr[size] = item;
            size++;
            return item;
        } else {
            grow();
            integerArr[size] = item;
            size++;
            return item;
        }
        //throw new ListIsFullException();
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        if (index >= integerArr.length || index > size) {
            throw new IndexOutOfBoundException();
        }

        if (integerArr[integerArr.length - 1] != null) {
            //throw new ListIsFullException();
            grow();
        }

        for (int i = size - 1; i >= index; i--) {
            integerArr[i + 1] = integerArr[i];
        }
        integerArr[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        if (index >= size) {
            throw new IndexOutOfBoundException();
        }

        integerArr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (integerArr[i].equals(item)) {
                integerArr[i] = null;
                found = true;
            }

            if (found) {
                integerArr[i] = integerArr[i + 1];
            }
        }

        if (found) {
            size--;
            return item;
        }
        throw new ItemNotFoundException();
    }

    @Override
    public Integer removeByIndex(int index) {
        if (integerArr[index] == null) {
            throw new ItemNotFoundException();
        }

        Integer item = integerArr[index];
        integerArr[index] = null;

        for (int i = index; i < size; i++) {
            integerArr[i] = integerArr[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        sort();
        return find(item);
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        for (int i = 0; i < size; i++) {
            if (integerArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }

        for (int i = size - 1; i >= 0; i--) {
            if (integerArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundException();
        }

        return integerArr[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullListException();
        }

        if (size != otherList.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!integerArr[i].equals(otherList.get(i))) {
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
            integerArr[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];

        System.arraycopy(integerArr, 0, array, 0, size);
        return array;
    }

    private void sort() {
        quickSort(0, size - 1);
    }

    public void quickSort(int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(begin, end);

            quickSort(begin, partitionIndex - 1);
            quickSort(partitionIndex + 1, end);
        }
    }

    private int partition(int begin, int end) {
        int pivot = integerArr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (integerArr[j] <= pivot) {
                i++;

                swapElements(i, j);
            }
        }

        swapElements(i + 1, end);
        return i + 1;
    }

    private void swapElements(int left, int right) {
        int temp = integerArr[left];
        integerArr[left] = integerArr[right];
        integerArr[right] = temp;
    }

    private boolean find(Integer item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(integerArr[mid])) {
                return true;
            }

            if (item < integerArr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        integerArr = Arrays.copyOf(integerArr, size + size / 2);
    }
}
