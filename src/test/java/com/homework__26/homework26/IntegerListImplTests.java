package com.homework__26.homework26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntegerListImplTests {
    @Test
    void add_shouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        Assertions.assertThrows(NullItemException.class, ()-> list.add(null));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void add_shouldReturnItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        Integer result = list.add(777);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(777, result);
        Assertions.assertEquals(777, list.get(0));
    }

    @Test
    void add_shouldIncrementArrayIfItsFull() {
        IntegerListImpl list = new IntegerListImpl(2);
        list.add(777);
        list.add(15);
        list.add(37);
        Assertions.assertEquals(37, list.get(2));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void add_withIndexShouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        Assertions.assertThrows(NullItemException.class, ()-> list.add(0,null));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void add_withIndexShouldThrowIndexOutOfBoundExceptionWhenIndexGreaterThanOrEqualToLength() {
        IntegerListImpl list = new IntegerListImpl(3);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.add(3,777));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void add_withIndexShouldThrowIndexOutOfBoundExceptionWhenIndexGreaterThanSize() {
        IntegerListImpl list = new IntegerListImpl(3);
        list.add(777);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.add(3,15));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void add_withIndexShouldIncrementArrayIfItsFull() {
        IntegerListImpl list = new IntegerListImpl(2);
        list.add(777);
        list.add(10);
        list.add(37);
        Assertions.assertEquals(37, list.get(2));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void add_withIndexShouldReturnItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(15);
        Integer result = list.add(0,777);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(777, result);
        Assertions.assertEquals(777, list.get(0));
        Assertions.assertEquals(15, list.get(1));
    }

    @Test
    void set_shouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        Assertions.assertThrows(NullItemException.class, ()-> list.set(0, null));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void set_shouldThrowIndexOutOfBoundException() {
        IntegerListImpl list = new IntegerListImpl(10);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.set(3, 777));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void set_shouldReturnItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(15);
        Integer result = list.set(0,777);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(777, result);
        Assertions.assertEquals(777, list.get(0));
    }

    @Test
    void remove_shouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Assertions.assertThrows(NullItemException.class, ()-> list.remove(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void remove_shouldThrowItemNotFoundException() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Assertions.assertThrows(ItemNotFoundException.class, ()-> list.remove(15));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void remove_shouldReturnItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(15);
        list.add(777);
        Integer result = list.remove(15);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(15, result);
        Assertions.assertEquals(777, list.get(0));
    }

    @Test
    void remove_byIndexShouldThrowItemNotFoundException() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Assertions.assertThrows(ItemNotFoundException.class, ()-> list.removeByIndex(1));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void remove_byIndexShouldReturnItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(15);
        list.add(777);
        Integer result = list.removeByIndex(0);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(15, result);
        Assertions.assertEquals(777, list.get(0));
    }

    @Test
    void contains_shouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Assertions.assertThrows(NullItemException.class, ()-> list.contains(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void contains_shouldReturnFalse() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Boolean result = list.contains(15);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void contains_shouldReturnTrue() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Boolean result = list.contains(777);
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void indexOf_shouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Assertions.assertThrows(NullItemException.class, ()-> list.indexOf(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void indexOf_shouldReturnIndex() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        int result = list.indexOf(777);
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void indexOf_shouldReturnMinus1() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        int result = list.indexOf(15);
        Assertions.assertEquals(-1, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void lastIndexOf_shouldThrowNullItemException() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Assertions.assertThrows(NullItemException.class, ()-> list.lastIndexOf(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void lastIndexOf_shouldReturnIndex() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        int result = list.lastIndexOf(777);
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void lastIndexOf_shouldReturnMinus1() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        int result = list.lastIndexOf(15);
        Assertions.assertEquals(-1, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void get_shouldThrowIndexOutOfBoundException() {
        IntegerListImpl list = new IntegerListImpl(10);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.get(3));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void get_shouldReturnItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Integer result = list.get(0);
        Assertions.assertEquals(777, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void equals_shouldThrowNullListException() {
        IntegerListImpl list = new IntegerListImpl(10);
        Assertions.assertThrows(NullListException.class, ()-> list.equals(null));
    }

    @Test
    void equals_shouldReturnFalseWhenSizesAreNotEqual() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        IntegerListImpl otherList = new IntegerListImpl(10);
        Boolean result = list.equals(otherList);
        Assertions.assertEquals(false, result);
    }

    @Test
    void equals_shouldReturnFalseWhenItemsAreNotEqual() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        IntegerListImpl otherList = new IntegerListImpl(10);
        otherList.add(15);
        Boolean result = list.equals(otherList);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(list.size(), otherList.size());
    }

    @Test
    void equals_shouldReturnTrue() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        IntegerListImpl otherList = new IntegerListImpl(10);
        otherList.add(777);
        Boolean result = list.equals(otherList);
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(list.size(), otherList.size());
        Assertions.assertEquals(list.get(0), otherList.get(0));
    }

    @Test
    void size_shouldReturn2() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        list.add(15);
        int result = list.size();
        Assertions.assertEquals(2, result);
    }

    @Test
    void size_shouldRemoveAndReturn1() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        list.add(15);
        list.removeByIndex(0);
        int result = list.size();
        Assertions.assertEquals(1, result);
    }

    @Test
    void size_shouldClearAndReturn0() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        list.add(15);
        list.clear();
        int result = list.size();
        Assertions.assertEquals(0, result);
    }

    @Test
    void isEmpty_shouldReturnTrue() {
        IntegerListImpl list = new IntegerListImpl(10);
        Boolean result = list.isEmpty();
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void isEmpty_shouldReturnFalse() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        Boolean result = list.isEmpty();
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void isEmpty_shouldClearAndReturnTrue() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(777);
        list.clear();
        Boolean result = list.isEmpty();
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear_shouldClearList() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(40);
        list.add(486);
        list.add(678);
        list.add(2);
        list.add(7);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear_shouldClearEmptyList() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear_shouldClearAndAddItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(40);
        list.add(486);
        list.add(678);
        list.clear();
        list.add(2);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void toArray_shouldCreateAnArray() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(40);
        list.add(486);
        list.add(678);
        Integer[] result = list.toArray();
        Assertions.assertNotNull(result);
        Assertions. assertEquals(list.size(), result.length);
        Assertions.assertEquals(40, result[0]);
        Assertions.assertEquals(486, result[1]);
        Assertions.assertEquals(678, result[2]);
    }

    @Test
    void toArray_shouldCreateAnEmptyArray() {
        IntegerListImpl list = new IntegerListImpl(10);
        Integer[] result = list.toArray();
        Assertions.assertNotNull(result);
        Assertions. assertEquals(list.size(), result.length);
    }

    @Test
    void toArray_shouldReturnTheUnmodifiedItem() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(40);
        list.add(486);
        Integer[] result = list.toArray();
        result[0] = 5;
        Assertions.assertEquals(40, list.get(0));
    }
}
