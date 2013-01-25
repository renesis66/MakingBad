package com.mansoor.makingbad;

import com.google.common.collect.FluentIterable;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;

import java.util.List;
import java.util.Map;

/**
 * @author Muhammad Ashraf
 * @since 1/25/13
 */
public class HankLabLocator extends Filter.FilterAdapter<Map<String, Object>> {
    Criteria criteria;

    @Override
    @SuppressWarnings("unchecked")
    public boolean accept(final Map<String, Object> map) {
        final List<Map<String, Object>> cooks = (List<Map<String, Object>>) map.get("cooks");
        return cooks != null && FluentIterable.from(cooks).anyMatch(new CookMatcher(criteria));
    }

    @Override
    public Filter addCriteria(Criteria criteria) {
        validateCriteria();
        this.criteria = criteria;
        return this;
    }

    private void validateCriteria() {
        if (this.criteria != null) {
            throw new UnsupportedOperationException("This filter only supports one criteria");
        }
    }
}
