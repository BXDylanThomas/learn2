package com.dylan.xinyidai05.domain.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 19:31
 */
@Data
public class Entity implements Serializable {

	private LocalDateTime makeDate;
	private LocalDateTime modifyDate;
	private String operator;

}
