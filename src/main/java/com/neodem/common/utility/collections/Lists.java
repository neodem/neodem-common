package com.neodem.common.utility.collections;

import java.util.List;

/**
 * Created by vfumo on 3/9/14.
 */
public class Lists {

    /**
     * return a reordered List starting with the given element or return an
     * empty list if the element isn't part of the original list or
     * the original list is null
     *
     * @param theList
     * @param startingWith
     * @param <T>
     * @return
     */
    public static <T> List<T> reorder(List<T> theList, T startingWith) {
        if(theList == null) return com.google.common.collect.Lists.newArrayList();

        int startIndex = theList.lastIndexOf(startingWith);
        if (startIndex == -1) return com.google.common.collect.Lists.newArrayList();

        List<T> newList = com.google.common.collect.Lists.newArrayList();
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
