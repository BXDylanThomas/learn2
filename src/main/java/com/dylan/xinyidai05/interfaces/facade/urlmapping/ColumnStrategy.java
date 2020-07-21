package com.dylan.xinyidai05.interfaces.facade.urlmapping;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.style.column.AbstractHeadColumnWidthStyleStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baoxiang
 * @create 2020-06-22 17:30
 */
public class ColumnStrategy extends AbstractHeadColumnWidthStyleStrategy {

    private Map<Integer, Integer> map = new HashMap<>();

    public ColumnStrategy(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    protected Integer columnWidth(Head head, Integer columnIndex) {
        Integer integer = map.get(columnIndex);
        if (integer == null){
            integer = 20;
        }
        return integer;
    }

}
 