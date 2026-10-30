package org.howard.edu.lsp.assignment5;

import java.util.TreeSet;

/**
 * Represents a mathematical set of integers.
 */
public class IntegerSet {

    private TreeSet<Integer> elements;

    public IntegerSet() {
        elements = new TreeSet<>();
    }
    /**
     * Removes all elements from this set.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of unique integers
     */
    public int length() {
        return elements.size();
    }

    /**
     * Determines whether this set contains the same elements as another set.
     *
     * @param b the set to compare against
     * @return true if both sets contain exactly the same elements
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }

        return elements.equals(b.elements);
    }

    /**
     * Checks whether a specified integer belongs to this set.
     *
     * @param value the integer to search for
     * @return true if the value exists in this set
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Returns the largest integer in this set.
     *
     * @return the largest integer
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }

        return elements.last();
    }

    /**
     * Returns the smallest integer in this set.
     *
     * @return the smallest integer
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }

        return elements.first();
    }

    /**
     * Adds an integer to this set.
     * Duplicate values are ignored.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        elements.add(item);
    }

    /**
     * Removes an integer from this set.
     * Nothing happens if the integer is absent.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        elements.remove(item);
    }

    /**
     * Returns a new set containing all elements from both sets.
     *
     * @param b the second set
     * @return a new set containing the union
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        result.elements.addAll(this.elements);
        result.elements.addAll(b.elements);

        return result;
    }

    /**
     * Returns a new set containing elements shared by both sets.
     *
     * @param b the second set
     * @return a new set containing the intersection
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int item : elements) {
            if (b.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in b.
     *
     * @param b the second set
     * @return a new set containing the difference
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int item : elements) {
            if (!b.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements in b but not in this set.
     *
     * @param b the second set
     * @return a new set containing the reverse difference
     */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int item : b.elements) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Determines whether every element in this set exists in b.
     *
     * @param b the set to compare against
     * @return true if this set is a subset of b
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.elements.containsAll(this.elements);
    }

    /**
     * Determines whether this set and b have no elements in common.
     *
     * @param b the second set
     * @return true if the sets are disjoint
     */
    public boolean isDisjoint(IntegerSet b) {
        for (int item : elements) {
            if (b.contains(item)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a new set containing elements that occur in exactly
     * one of the two sets.
     *
     * @param b the second set
     * @return a new set containing the symmetric difference
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int item : this.elements) {
            if (!b.contains(item)) {
                result.add(item);
            }
        }

        for (int item : b.elements) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Checks whether this set contains no elements.
     *
     * @return true if the set is empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the elements as a comma-separated string in ascending order.
     *
     * @return the formatted set representation
     */
    @Override
    public String toString() {
        return elements.toString();
    }
}
