package cn.smbms.dao;

import cn.smbms.pojo.Emp;
import cn.smbms.tools.HibernateUtil;

/**
 * ˫���Զ�
 * */
public class EmpProDao {

	/**
	 * ����Ա����ѯ��Ŀ
	 * */
	public Emp getProByEmp(int id){
		return (Emp)HibernateUtil.getSession().get(Emp.class, id);
	}
}
