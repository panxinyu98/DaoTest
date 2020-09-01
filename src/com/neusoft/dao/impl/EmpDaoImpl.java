package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.EmpDao;
import com.neusoft.po.Emp;
import com.neusoft.util.CommonUtil;
import com.neusoft.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	// 全查询
	@Override
	public List<Emp> selectEmpAll() {
		List<Emp> list = new ArrayList<>();
		String sql = "select * from emp order by empno";
		try {
		
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHireDate(rs.getString("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return list;
	}
	@Override
	// 根据ID查询
	public Emp selectEmpById(int empno) {
		Emp emp = null;
		String sql = "select * from emp where empno=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, empno);
			rs = pst.executeQuery();
			if (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHireDate(rs.getString("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return emp;
	}
	@Override
	// 添加
	public int insertEmp(Emp emp) {
		int result = 0;
		String sql = "insert into emp values(null,?,?,?,?,?)";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, emp.getEname());
			pst.setString(2, emp.getJob());
			pst.setString(3, CommonUtil.getCurDate());
			pst.setDouble(4, emp.getSal());
			pst.setInt(5, emp.getDeptno());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return result;
	}
	@Override
	// 更新
	public int updateEmp(Emp emp) {
		int result = 0;
		String sql = "update emp set job=?,sal=? where empno=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, emp.getJob());
			pst.setDouble(2, emp.getSal());
			pst.setInt(3, emp.getEmpno());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return result;
	}
	@Override
	// 删除
	public int deleteEmpById(int empno) {
		int result = 0;
		String sql = "delete from emp where empno=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, empno);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return result;
	}
	@Override
	public int zhuanzhang(int empno1,int empno2){
		int result = 1;
		String sql1 = "Update emp set sal= sal-500 where empno=?";
		String sql2 = "Update emp set sal= sal+500 where empno=?";
		try {
			con = DBUtil.getConnection();
			//在mysql，默认自动提交；那么，如果需要自己管理事务，就不能自动提交。

			//1、设置不自动提交（开启一个事务）
			con.setAutoCommit(false);
			
			pst = con.prepareStatement(sql1);
			pst.setInt(1, empno1);	
			pst.executeUpdate();
			
			pst = con.prepareStatement(sql2);
			pst.setInt(1, empno2);	
			pst.executeUpdate();
			
			//2、提交一个事务
			con.commit();
			
		} catch (Exception e) {
			result=0;
			try {
				//3、回滚一个事务
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return result;
	}
}
