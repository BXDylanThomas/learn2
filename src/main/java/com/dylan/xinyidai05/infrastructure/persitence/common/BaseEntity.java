package com.dylan.xinyidai05.infrastructure.persitence.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 19:31
 */
@Data
public class BaseEntity implements Serializable {

	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime makeDate;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime modifyDate;
	private String operator;

}
