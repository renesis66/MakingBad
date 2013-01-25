package com.mansoor.makingbad;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static sun.nio.cs.Surrogate.is;

/**
 * @author Muhammad Ashraf
 * @since 1/25/13
 */
public class CookFinderTest {
    SuperLabFinder cookFinder;

    @Before
    public void setUp() throws Exception {
        cookFinder = new SuperLabFinder();
    }

    @Test
    public void testFindCook() throws Exception {
        final List<Map<String, Object>> labs = cookFinder.findCook("Jessy");
        assertTrue(labs.size() == 2);
        for (Map<String, Object> lab : labs) {
            System.out.println("lab = " + lab);
        }
    }
}
