package com.neusoft;

import java.util.List;

import com.neusoft.dao.EmpDao;
import com.neusoft.dao.impl.EmpDaoImpl;
import com.neusoft.po.Emp;

public class Test {

	public static void main(String[] args) {
		EmpDao dao = new EmpDaoImpl();
		    //ȫ��ѯ
		/*
		 * 
		List<Emp> list = dao.selectEmpAll();
		if(list.size()==0) {
			System.out.println("û������");
		}else {
			for(Emp emp : list) {
				System.out.println(emp);
			}
		}
		*/
		//����Id��ѯ
		/*Emp emp = dao.selectEmpById(7369);
		if(emp!=null) {
			System.out.println(emp);
		}else {
			System.out.println("���޴���");
		}*/
		
		//���insert into 
		/*
		Emp emp = new Emp();
		emp.setEname("ϰ��ƽ");
		emp.setJob("������ϯ");
		emp.setSal(9000.32);
		emp.setDeptno(10);
		int result = dao.insertEmp(emp);
		if(result>0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
		*/
		
		//����update set
		/*
		Emp emp = new Emp();
		emp.setEmpno(8001);
		emp.setJob("������ϯ1");
		emp.setSal(9000.33);
		int result = dao.updateEmp(emp);
		if(result>0) {
			System.out.println("���³ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
		*/
		
		
		//ɾ��delete from
		/*int result = dao.deleteEmpById(8001);
		if(result>0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}*/
		
		//�ύ����commit 
		int result = dao.zhuanzhang(8, 9);
		if(result>0) {
			System.out.println("ת�˳ɹ�");
		}else {
			System.out.println("ת��ʧ��");
		}
		
		
		
	
		
	}

}
