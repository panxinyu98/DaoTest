package com.neusoft.dao;

import java.util.List;

import com.neusoft.po.Emp;

public interface EmpDao {

	public List<Emp> selectEmpAll();
	public Emp selectEmpById(int empno);
	public int insertEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int deleteEmpById(int empno);
	//ÑÝÊ¾ÊÂÎñ
	public int zhuanzhang(int empno1,int empno2);
}
