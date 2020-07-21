package com.dylan.xinyidai05.interfaces.facade.urlmapping;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.*;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/23 21:17
 */
public class ExcelStyleUtil {

	public static HorizontalCellStyleStrategy globleStyle(){
		// 头的样式
		WriteCellStyle headStyle = new WriteCellStyle();
		headStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
		headStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		WriteFont headFont = new WriteFont();
		headFont.setBold(true);
		headFont.setFontHeightInPoints((short) 16);
		headStyle.setWriteFont(headFont);
		headStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
		headStyle.setWrapped(true);

		// 内容的样式
		WriteCellStyle contentStyle = new WriteCellStyle();
		contentStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
		contentStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		WriteFont contentWriteFont = new WriteFont();
		contentWriteFont.setFontHeightInPoints((short) 12);
		contentStyle.setWriteFont(contentWriteFont);
		contentStyle.setBorderTop(BorderStyle.THIN);
		contentStyle.setBorderBottom(BorderStyle.THIN);
		contentStyle.setBorderLeft(BorderStyle.THIN);
		contentStyle.setBorderRight(BorderStyle.THIN);
		contentStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
		contentStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		contentStyle.setWrapped(true);
		return new HorizontalCellStyleStrategy(headStyle, contentStyle);
	}
}
