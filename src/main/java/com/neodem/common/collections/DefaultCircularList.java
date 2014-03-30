package com.neodem.common.collections;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vfumo on 3/9/14.
 */
public class DefaultCircularList<T> implements CircularList<T> {
    private final List<T> theList = Lists.newArrayList();

    @Override
    public void add(T element) {
        theList.add(element);
    }

    @Override
    public void addElements(List<T> elements) {
        theList.addAll(elements);
    }

    @Override
    public void clearList() {
        theList.clear();
    }

    @Override
    public int size() {
        return theList.size();
    }

    @Override
    public List<T> getElements() {
        return Lists.newArrayList(theList);
    }

    @Override
    public List<T> getElements(T startingWith) {
        int startIndex = theList.lastIndexOf(startingWith);
        if (startIndex == -1) return Lists.newArrayList();

        List<T> newList = Lists.newArrayList();
        for (int i = startIndex; i < theList.size(); i++) {
            newList.add(theList.get(i));
        }

        for (T element : theList) {
            if (element.equals(startingWith)) {
                break;
            }
            newList.add(element);
        }

        return newList;
    }

    @Override
    public Iterator<T> iterator() {
        return theList.iterator();
    }
}
