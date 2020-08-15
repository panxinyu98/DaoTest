package com.neusoft;

import java.util.List;

import com.neusoft.dao.EmpDao;
import com.neusoft.dao.impl.EmpDaoImpl;
import com.neusoft.po.Emp;

public class Test {

	public static void main(String[] args) {
		EmpDao dao = new EmpDaoImpl();
		    //全查询
		/*
		 * 
		List<Emp> list = dao.selectEmpAll();
		if(list.size()==0) {
			System.out.println("没有数据");
		}else {
			for(Emp emp : list) {
				System.out.println(emp);
			}
		}
		*/
		//根据Id查询
		/*Emp emp = dao.selectEmpById(7369);
		if(emp!=null) {
			System.out.println(emp);
		}else {
			System.out.println("查无此人");
		}*/
		
		//添加insert into 
		/*
		Emp emp = new Emp();
		emp.setEname("习近平");
		emp.setJob("国家主席");
		emp.setSal(9000.32);
		emp.setDeptno(10);
		int result = dao.insertEmp(emp);
		if(result>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		*/
		
		//更新update set
		/*
		Emp emp = new Emp();
		emp.setEmpno(8001);
		emp.setJob("国家主席1");
		emp.setSal(9000.33);
		int result = dao.updateEmp(emp);
		if(result>0) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		*/
		
		
		//删除delete from
		/*int result = dao.deleteEmpById(8001);
		if(result>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}*/
		
		//提交事务commit 
		int result = dao.zhuanzhang(8, 9);
		if(result>0) {
			System.out.println("转账成功");
		}else {
			System.out.println("转账失败");
		}
		
		
		
	
		
	}

}
