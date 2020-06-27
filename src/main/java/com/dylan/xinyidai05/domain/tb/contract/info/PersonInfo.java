package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.Person;
import com.dylan.xinyidai05.domain.common.Assert;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.PersonDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:09
 */
public class PersonInfo extends AbstractContractInfoQuery<PersonDO, Person> {

	@Autowired
	private PersonService personService;

	private String customerNo;

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	@Override
	public Person query() {
		this.check();
		PersonDO personDO = personService.getOne(getQueryCondition());
		return (Person) transDOToEntity(personDO,Person.class);
	}

	@Override
	public void check() {
		super.check();
		Assert.isNotBank(customerNo,"保单信息构建，客户信息查询，客户号不能为空");
	}

	@Override
	public QueryWrapper<PersonDO> getQueryCondition() {
		QueryWrapper<PersonDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(PersonDO::getApplicationformNo,condition.getPrtNo()).eq(PersonDO::getCustomerNo,customerNo);
		return queryWrapper;
	}
}
