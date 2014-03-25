package com.neodem.common.utility.collections;

import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by vfumo on 3/9/14.
 */
public class Lists {

    /**
     * return a reordered List starting with the given element or return an
     * empty list if the element isn't part of the original list or
     * the original list is null
     *
     * @param theList      the list we are using as the source of the reorder
     * @param startingWith the element we want the new list to start with (must be part of the source list)
     * @param <T>          the Type of the operation
     * @return a reordered List starting with the given element or return an
     *         empty list if the element isn't part of the original list or
     *         the original list is null
     */
    public static <T> List<T> reorder(List<T> theList, T startingWith) {
        if (theList == null) return com.google.common.collect.Lists.newArrayList();

        int startIndex = theList.lastIndexOf(startingWith);
        if (startIndex == -1) return com.google.common.collect.Lists.newArrayList();

        List<T> newList = com.google.common.collect.Lists.newArrayList();
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

    /**
     * return a random element from the collection. If notThisOne is specified
     * we sholdn't return it.
     *
     * @param theCollection the source collection
     * @param notThisOne    if not null, don't return this one
     * @param <T>           the type of this operation
     * @return a random element from the collection. If notThisOne is specified
     *         we sholdn't return it.
     */
    public static <T> T getRandomElement(Collection<T> theCollection, T notThisOne) {
        if (theCollection == null) return null;

        Random r = new Random(System.currentTimeMillis());

        T found = null;
        do {
            int index = r.nextInt(theCollection.size());
            int counter = 0;

            for (T obj : theCollection) {
                if (counter == index) {
                    found = obj;
                    break;
                }
                counter++;
            }
        } while (found == notThisOne);

        return found;
    }
}
