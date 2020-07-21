package com.dylan.xinyidai05.interfaces.facade.urlmapping;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.merge.AbstractMergeStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author baoxiang
 * @create 2020-06-22 9:42
 */
public class MergeStrategy  extends AbstractMergeStrategy {
    private int rowStart;
    private int rowEnd ;
    private int colStart;
    private int colEnd;

    public MergeStrategy(int rowStart, int rowEnd, int colStart, int colEnd) {
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.colStart = colStart;
        this.colEnd = colEnd;
    }

    @Override
    protected void merge(Sheet sheet, Cell cell, Head head, Integer integer) {
        int row =cell.getRow().getRowNum() +1;
        if (cell.getColumnIndex() == 0  &&  row == rowEnd){
            sheet.addMergedRegion(new CellRangeAddress(rowStart, rowEnd, colStart, colEnd));
        }
        if (cell.getColumnIndex() == 1  &&  row == rowEnd){
            sheet.addMergedRegion(new CellRangeAddress(rowStart, rowEnd, 1, 1));
        }
    }
}
 