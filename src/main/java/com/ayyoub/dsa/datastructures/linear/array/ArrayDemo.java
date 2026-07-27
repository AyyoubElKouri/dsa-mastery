package com.ayyoub.dsa.datastructures.linear.array;

public class ArrayDemo {
    public static void run() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        // Add elements to the dynamic array
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);

        // Display elements in the dynamic array
        System.out.println("Elements in the dynamic array:");
        for (int i = 0; i < 3; i++) {
            System.out.println(dynamicArray.get(i));
        }

        // Add an element at a specific index
        dynamicArray.add(1, 15); // Adding 15 at index 1
        System.out.println("Element added at index 1:");
        System.out.println(dynamicArray.get(1));

        // Display elements after adding at a specific index
        System.out.println("Elements in the dynamic array after adding at index 1:");
        for (int i = 0; i < 4; i++) {
            System.out.println(dynamicArray.get(i));
        }

        // Attempt to access an out-of-bounds index
        try {
            dynamicArray.get(5); // This should throw an exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        // Attempt to add an element at an out-of-bounds index
        try {
            dynamicArray.add(5, 40); // This should throw an exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        // Remove an element at a specific index
        dynamicArray.remove(2);
        System.out.println("Elements in the dynamic array after removing index 2:");
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }

        // Attempt to remove an element at an out-of-bounds index
        try {
            dynamicArray.remove(5); // This should throw an exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
