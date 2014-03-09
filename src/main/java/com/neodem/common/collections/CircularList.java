package com.neodem.common.collections;

import java.util.List;

/**
 * Created by vfumo on 3/9/14.
 */
public interface CircularList<T> extends Iterable<T> {

    /**
     * add an element to the list. This
     * will be ordered.
     *
     * @param element
     */
    public void add(T element);

    /**
     * add an ordered list of elements
     * @param elements
     */
    public void addElements(List<T> elements);

    /**
     * clear the list
     */
    public void clearList();

    public int size();

    /**
     * get an ordered list of elements
     *
     * @return
     */
    public List<T> getElements();

    /**
     * get an ordered list of elements with the given element first and
     * the others following in order. This is circular until we get to the
     * starting element. If the element is not in the list an empty list is returned
     *
     * @return
     */
    public List<T> getElements(T startingWith);
}
