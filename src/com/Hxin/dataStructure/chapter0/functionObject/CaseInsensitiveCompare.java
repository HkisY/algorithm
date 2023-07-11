package com.Hxin.dataStructure.chapter0.functionObject;

import java.util.Comparator;

/**
 * @author Hxin
 * @version 1.0
 * @see
 * @since 2022/4/2
 */
public class CaseInsensitiveCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
