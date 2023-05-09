package com.homework__26.homework26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringListImplTests {
    @Test
    void add_shouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        Assertions.assertThrows(NullItemException.class, ()-> list.add(null));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void add_shouldReturnItem() {
        StringListImpl list = new StringListImpl(10);
        String result = list.add("Hello");
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Hello", result);
        Assertions.assertEquals("Hello", list.get(0));
    }

    @Test
    void add_shouldThrowListIsFullException() {
        StringListImpl list = new StringListImpl(1);
        list.add("Hello");
        Assertions.assertThrows(ListIsFullException.class, ()-> list.add("Hi"));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void add_withIndexShouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        Assertions.assertThrows(NullItemException.class, ()-> list.add(0,null));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void add_withIndexShouldThrowIndexOutOfBoundExceptionWhenIndexGreaterThanOrEqualToLength() {
        StringListImpl list = new StringListImpl(3);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.add(3,"Hello"));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void add_withIndexShouldThrowIndexOutOfBoundExceptionWhenIndexGreaterThanSize() {
        StringListImpl list = new StringListImpl(3);
        list.add("Hello");
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.add(3,"Hi"));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void add_withIndexShouldThrowListIsFullException() {
        StringListImpl list = new StringListImpl(3);
        list.add("Hello");
        list.add("Yes");
        list.add("No");
        Assertions.assertThrows(ListIsFullException.class, ()-> list.add(2,"Hi"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void add_withIndexShouldReturnItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hi");
        String result = list.add(0,"Hello");
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Hello", result);
        Assertions.assertEquals("Hello", list.get(0));
        Assertions.assertEquals("Hi", list.get(1));
    }

    @Test
    void set_shouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        Assertions.assertThrows(NullItemException.class, ()-> list.set(0, null));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void set_shouldThrowIndexOutOfBoundException() {
        StringListImpl list = new StringListImpl(10);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.set(3, "Hello"));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void set_shouldReturnItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hi");
        String result = list.set(0,"Hello");
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Hello", result);
        Assertions.assertEquals("Hello", list.get(0));
    }

    @Test
    void remove_shouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Assertions.assertThrows(NullItemException.class, ()-> list.remove(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void remove_shouldThrowItemNotFoundException() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Assertions.assertThrows(ItemNotFoundException.class, ()-> list.remove("Hi"));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void remove_shouldReturnItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hi");
        list.add("Hello");
        String result = list.remove("Hi");
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Hi", result);
        Assertions.assertEquals("Hello", list.get(0));
    }

    @Test
    void remove_byIndexShouldThrowItemNotFoundException() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Assertions.assertThrows(ItemNotFoundException.class, ()-> list.remove(1));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void remove_byIndexShouldReturnItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hi");
        list.add("Hello");
        String result = list.remove(0);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Hi", result);
        Assertions.assertEquals("Hello", list.get(0));
    }

    @Test
    void contains_shouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Assertions.assertThrows(NullItemException.class, ()-> list.contains(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void contains_shouldReturnFalse() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Boolean result = list.contains("Hi");
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void contains_shouldReturnTrue() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Boolean result = list.contains("Hello");
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void indexOf_shouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Assertions.assertThrows(NullItemException.class, ()-> list.indexOf(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void indexOf_shouldReturnIndex() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        int result = list.indexOf("Hello");
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void indexOf_shouldReturnMinus1() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        int result = list.indexOf("Hi");
        Assertions.assertEquals(-1, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void lastIndexOf_shouldThrowNullItemException() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Assertions.assertThrows(NullItemException.class, ()-> list.lastIndexOf(null));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void lastIndexOf_shouldReturnIndex() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        int result = list.lastIndexOf("Hello");
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void lastIndexOf_shouldReturnMinus1() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        int result = list.lastIndexOf("Hi");
        Assertions.assertEquals(-1, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void get_shouldThrowIndexOutOfBoundException() {
        StringListImpl list = new StringListImpl(10);
        Assertions.assertThrows(IndexOutOfBoundException.class, ()-> list.get(3));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void get_shouldReturnItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        String result = list.get(0);
        Assertions.assertEquals("Hello", result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void equals_shouldThrowNullListException() {
        StringListImpl list = new StringListImpl(10);
        Assertions.assertThrows(NullListException.class, ()-> list.equals(null));
    }

    @Test
    void equals_shouldReturnFalseWhenSizesAreNotEqual() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        StringListImpl otherList = new StringListImpl(10);
        Boolean result = list.equals(otherList);
        Assertions.assertEquals(false, result);
    }

    @Test
    void equals_shouldReturnFalseWhenItemsAreNotEqual() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        StringListImpl otherList = new StringListImpl(10);
        otherList.add("Hi");
        Boolean result = list.equals(otherList);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(list.size(), otherList.size());
    }

    @Test
    void equals_shouldReturnTrue() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        StringListImpl otherList = new StringListImpl(10);
        otherList.add("Hello");
        Boolean result = list.equals(otherList);
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(list.size(), otherList.size());
        Assertions.assertEquals(list.get(0), otherList.get(0));
    }

    @Test
    void size_shouldReturn2() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        list.add("hi");
        int result = list.size();
        Assertions.assertEquals(2, result);
    }

    @Test
    void size_shouldRemoveAndReturn1() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        list.add("hi");
        list.remove(0);
        int result = list.size();
        Assertions.assertEquals(1, result);
    }

    @Test
    void size_shouldClearAndReturn0() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        list.add("hi");
        list.clear();
        int result = list.size();
        Assertions.assertEquals(0, result);
    }

    @Test
    void isEmpty_shouldReturnTrue() {
        StringListImpl list = new StringListImpl(10);
        Boolean result = list.isEmpty();
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void isEmpty_shouldReturnFalse() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        Boolean result = list.isEmpty();
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void isEmpty_shouldClearAndReturnTrue() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello");
        list.clear();
        Boolean result = list.isEmpty();
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear_shouldClearList() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello 1");
        list.add("Hello 2");
        list.add("Hello 3");
        list.add("Hello 4");
        list.add("Hello 5");
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear_shouldClearEmptyList() {
        StringListImpl list = new StringListImpl(10);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear_shouldClearAndAddItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello 1");
        list.add("Hello 2");
        list.add("Hello 3");
        list.clear();
        list.add("Hello 4");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void toArray_shouldCreateAnArray() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello 1");
        list.add("Hello 2");
        list.add("Hello 3");
        String[] result = list.toArray();
        Assertions.assertNotNull(result);
        Assertions. assertEquals(list.size(), result.length);
        Assertions.assertEquals("Hello 1", result[0]);
        Assertions.assertEquals("Hello 2", result[1]);
        Assertions.assertEquals("Hello 3", result[2]);
    }

    @Test
    void toArray_shouldCreateAnEmptyArray() {
        StringListImpl list = new StringListImpl(10);
        String[] result = list.toArray();
        Assertions.assertNotNull(result);
        Assertions. assertEquals(list.size(), result.length);
    }

    @Test
    void toArray_shouldReturnTheUnmodifiedItem() {
        StringListImpl list = new StringListImpl(10);
        list.add("Hello 1");
        list.add("Hello 2");
        String[] result = list.toArray();
        result[0] = "New Hello";
        Assertions.assertEquals("Hello 1", list.get(0));
    }
}
