package com.neodem.common.collections;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

/**
 * Created by vfumo on 3/9/14.
 */
public class DefaultCircularListTest {
    private DefaultCircularList cl;

    @Before
    public void before() {
        cl = new DefaultCircularList();
    }

    @After
    public void after() {
        cl = null;
    }

    @Test
    public void getElementsShouldWorkWithStartingPlayerAtStart() {
        List<String> testList = Lists.newArrayList("start", "middle", "last");
        cl.addElements(testList);
        List<String> result = cl.getElements("start");

        assertThat(result.size(), is(3));
        assertThat(result.get(0), is("start"));
        assertThat(result.get(1), is("middle"));
        assertThat(result.get(2), is("last"));
    }

    @Test
    public void getElementsShouldWorkWithStartingPlayerAtEnd() {
        List<String> testList = Lists.newArrayList("start", "middle", "last");
        cl.addElements(testList);
        List<String> result = cl.getElements("last");

        assertThat(result.size(), is(3));
        assertThat(result.get(0), is("last"));
        assertThat(result.get(1), is("start"));
        assertThat(result.get(2), is("middle"));
    }

    @Test
    public void getElementssShouldWorkWithStartingPlayerInMiddle() {
        List<String> testList = Lists.newArrayList("start", "middle", "last");
        cl.addElements(testList);
        List<String> result = cl.getElements("middle");

        assertThat(result.size(), is(3));
        assertThat(result.get(0), is("middle"));
        assertThat(result.get(1), is("last"));
        assertThat(result.get(2), is("start"));
    }
}