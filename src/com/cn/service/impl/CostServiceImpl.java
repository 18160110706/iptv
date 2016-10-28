package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.dao.CostDao;
import com.cn.entity.Cost;
import com.cn.service.CostService;

@Service("costService")
@Transactional
public class CostServiceImpl implements CostService {
	@Autowired
	private CostDao costDao;

	@Override
	public List<Cost> costs() {
		// TODO Auto-generated method stub
		return this.costDao.costs();
	}

}
