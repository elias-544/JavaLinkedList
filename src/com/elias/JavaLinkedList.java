package com.elias;

/**
 * @author Elias Khatoun
 * date 06/06/2024
 * A java implementation of a simple LinkedList
 */

// A public class to represent a LinkedList
public class JavaLinkedList {

    // Instance variables
    private Node head;

    // Constructor
    public JavaLinkedList() {
        this.head = null;
    }

    // Instance methods
    public boolean isEmpty() {
        return this.head == null;
    }


    /**
     * A method to add a new node to the front of the list
     * @param value The value to add to the front of the list
     */

    public void addToFront(int value) {
        // Create a new Node from the value
        Node node = new Node(value);

        if (this.isEmpty()) {
            this.head = node;
            // Return to end the function
            return;
        }
        // Make the new node the head of the list
        Node oldHead = head;
        node.setNext(oldHead);
        this.head = node;
    }


    /**
     * A method to look at the value at the front of the list and return it
     * @return The value at the front of the list
     * @throws Exception Cannot look at the front of an empty list
     */

    public int lookAtFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot look at the front of an empty list.");
        }

        return this.head.value;
    }


    /**
     * A method to remove the first node from the list
     */

    public void removeFromFront() {
        if (!isEmpty()) {
            this.head = this.head.next;
        }
    }


    /**
     * A method to add a new node to the back of the list
     * @param value Returns the value at the back of the list
     */

    public void addToBackSlow(int value) {
        // Create our new node
        Node node = new Node(value);

        // Handle empty case
        if (isEmpty()) {
            this.head = node;
            return;
        }

        // We need to find the back of the list
        // DON'T MESS UP OUR LIST
        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Add the new node to the back's next
        curr.next = node;
    }


    /**
     * A method to remove the last node from the list
     */

    public void removeFromBackSlow() {
        if (!isEmpty()) {

            // Check if there is only one element in the list
            if (this.head.next == null) {
                // Empty the list
                this.head = null;
                return;
            }


            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;

        }
    }


    /**
     * A method to look at the value at the back of the list and return it
     * @return The value at the back of the list
     * @throws Exception Cannot look at the back of an empty list
     */

    public int lookAtBack() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot look at the back of an empty list.");
        }

        // Go to the back of the list
        // DON'T MESS UP THE LIST
        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.value;
    }


    /**
     * A toString method to represent the list as a string
     * @return A string representation of the list
     */

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }

        String listRep = "[";

        // "Loop" over every element in the list
        // DON'T MESS UP OUR LIST
        Node curr = head;
        while (curr.next != null) {
            // Add the current value to the String
            listRep += curr + ", ";
            // Move up the list
            curr = curr.next;
        }
        // Right now, curr is at the LAST value of the list
        listRep += curr;

        listRep += "]";
        return listRep;

    }

    // A private inner class to represent a Node in the list
    private class Node {

        // Instance variables
        private int value;
        private Node next;


        /**
         * A constructor to create a new Node with a value
         * @param value The value of the new Node
         */

        public Node(int value) {
            this.value = value;
            this.next = null;
        }


        /**
         * A method to get the value of the Node
         * @param next The value of the Node
         */

        public void setNext(Node next) {
            this.next = next;
        }


        /**
         * A toString method to represent the Node as a string
         * @return A string representation of the Node
         */

        @Override
        public String toString() {
            return String.valueOf(value);
            // return value + "";
        }
    }
}
