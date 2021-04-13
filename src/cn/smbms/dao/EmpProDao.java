package cn.smbms.dao;

import cn.smbms.pojo.Emp;
import cn.smbms.tools.HibernateUtil;

/**
 * 双向多对多
 * */
public class EmpProDao {

	/**
	 * 根据员工查询项目
	 * */
	public Emp getProByEmp(int id){
		return (Emp)HibernateUtil.getSession().get(Emp.class, id);
	}
}
