package com.mansoor.makingbad;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.Criteria.where;

/**
 * @author Muhammad Ashraf
 * @since 1/25/13
 */
public class SuperLabFinder {


    public List<Map<String, Object>> findCook(final String name) throws IOException {
        final InputStream inputStream = getClass().getResourceAsStream("/labs.json");
        final HankLabLocator hankLabLocator = new HankLabLocator();
        hankLabLocator.addCriteria(where("name").is(name));
        return JsonPath.read(inputStream, "$.superlabs[?]", hankLabLocator);
    }


}
