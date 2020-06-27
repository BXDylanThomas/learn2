package com.dylan.xinyidai05.interfaces.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dylan.xinyidai05.infrastructure.persitence.entity.finace.PaymentDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.finace.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/get")
	public Object get(){
		return paymentService.list();
	}

	@PostMapping("/save")
	public Object save(@RequestBody PaymentDO paymentDO){
		return paymentService.save(paymentDO);
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

}
