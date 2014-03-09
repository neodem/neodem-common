package com.neodem.common.collections;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by vfumo on 3/9/14.
 */
public class DefaultCircularList<T> implements CircularList<T> {
    private List<T> theList = Lists.newArrayList();

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

        for(T element : theList) {
            if(element.equals(startingWith)) {
                break;
            }
            newList.add(element);
        }

        return newList;
    }

}
