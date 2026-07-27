package com.ayyoub.dsa.datastructures.linear.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A dynamic array implementation that can grow and shrink in size.
 * DynamicArray
 * @param <T>
 */
public class DynamicArray<T> implements Iterable<T> {

  private T[] array;
  private int size;

  /**
   * Constructs a DynamicArray with the specified initial capacity.
   * @param initialCapacity
  */
  @SuppressWarnings("unchecked")
  public DynamicArray(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Initial capacity must be greater than 0");
    }

    array = (T[]) new Object[initialCapacity];
    size = 0;
  }

  /**
   * Constructs a DynamicArray with a default initial capacity of 10.
   */
  public DynamicArray() {
    this(10); // Default initial capacity
  }
  
  /**
   * Returns the element at the specified index.
   * @param index
   * @return
   */
  public T get(int index) {
    
    // Check if the index is within bounds
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    return array[index];
  }

  /**
   * Adds an element to the end of the array.
   * @param element
   */
  public void add(T element) {
    // Check the capacity and resize if necessary
    if (size == array.length) {
      resize();
    }

    array[size++] = element;
  }

  /**
   * Adds an element at the specified index
   * @param index
   * @param element
   */
  public void add(int index, T element) {
    // Check if the index is within bounds
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Check the capacity and resize if necessary
    if (size == array.length) {
      resize();
    }

    // Shift elements to the right, make space for the new element
    for (int i = size ; i > index ; i--) {
      array[i] = array[i - 1];
    }

    array[index] = element;
    size++;
  }

  /**
   * Sets the element at the specified index.
   * @param index
   * @param element
   */
  public void set(int index, T element) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      }
      array[index] = element;
  }

  /**
   * Removes the element at the specified index.
   * @param index
   */
  public void remove(int index) {
    // Check if the index is within bounds
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Shift elements to the left (overwrite the element at the specified index)
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }

    // Set the last element to null and decrease the size
    array[size - 1] = null;
    size--;

    if (size < array.length / 4) {
      shrink();
    }
  }

  /**
   * Returns the current size of the array.
   * @return
   */
  public int size() {
    return size;
  }

  /**
   * Returns the current capacity of the array.
   * @return
   */
  public int capacity() {
    return array.length;
  }

  /**
   * Resizes the array to double its current capacity.
   */
  @SuppressWarnings("unchecked")
  private void resize() {
    int newCapacity = array.length * 2;
    T[] newArray = (T[]) new Object[newCapacity];

    // Copy all elements to the new zone
    for (int i = 0 ; i < size ; i++) {
      newArray[i] = array[i];
    }

    array = newArray;
  }

  /**
   * Shrinks the array to half its current capacity.
   */
  @SuppressWarnings("unchecked")
  private void shrink() {
    int newCapacity = array.length / 2;
    T[] newArray = (T[]) new Object[newCapacity];

    // Copy all elements to the new array
    for (int i = 0 ; i < size ; i++) {
      newArray[i] = array[i];
    }

    array = newArray;
  }

  @Override
  public Iterator<T> iterator() {
    return new DynamicArrayIterator();
  }

  private class DynamicArrayIterator implements Iterator<T> {
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
      return currentIndex < size;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No more elements to iterate.");
      }
      return array[currentIndex++];
    }
  }
}
