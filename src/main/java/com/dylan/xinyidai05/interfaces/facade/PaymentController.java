package com.dylan.xinyidai05.interfaces.facade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dylan.xinyidai05.infrastructure.persitence.entity.finace.PaymentDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.finace.PaymentMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.finace.PaymentService;
import com.dylan.xinyidai05.interfaces.dto.PaymentReq;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 23:22
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentMapper paymentMapper;

	@GetMapping("/get")
	public Object get(){
		return paymentService.list();
	}

	@PostMapping("/save")
	public Object save(@RequestBody @Validated() PaymentDO paymentDO){
		return paymentService.save(paymentDO);
	}

	/**
	 * 指定序列化字段
	 * @param paymentDO
	 * @return
	 */
	@JsonView(PaymentReq.payCodeAndIdView.class)
	@PostMapping("/json")
	public Object json(@RequestBody PaymentReq paymentDO){
		return paymentDO;
	}

	@PostMapping("/update")
	public Object update(@RequestBody PaymentDO paymentDO){
		return paymentService.updateById(paymentDO);
	}

	@GetMapping("/page")
	public Object page(){
		IPage<PaymentDO> iPage = new Page<>(1,1);
		return paymentService.page(iPage);
	}
	@GetMapping("/select")
	public Object select(){
		return  paymentMapper.select(Wrappers.<PaymentDO>query().lambda().eq(PaymentDO::getId,3).last("limit 1"));
	}


}
