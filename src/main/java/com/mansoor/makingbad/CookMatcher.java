package com.mansoor.makingbad;

import com.google.common.base.Predicate;
import com.jayway.jsonpath.Criteria;

import java.util.Map;

/**
 * @author Muhammad Ashraf
 * @since 1/25/13
 */
public class CookMatcher implements Predicate<Map<String, Object>> {
    private final Criteria criteria;

    public CookMatcher(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean apply(Map<String, Object> cooks) {
        validate();
        return criteria.matches(cooks);
    }

    private void validate() {
        if ((criteria == null)) {
            throw new IllegalArgumentException("Criteria is required");
        }
    }
}