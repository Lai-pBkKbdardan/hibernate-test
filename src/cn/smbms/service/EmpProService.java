package cn.smbms.service;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.smbms.dao.EmpProDao;
import cn.smbms.pojo.Pro;
import cn.smbms.tools.HibernateUtil;

/**
 * 双向多对多
 * */
public class EmpProService {

	EmpProDao empPro = new EmpProDao();
	/**
	 * 根据员工查询项目
	 * */
	public Pro getProByEmp(int id){
		Transaction tx = null;
		Pro pro = null;
		try{
			tx = HibernateUtil.getSession().beginTransaction();
			Iterator<Pro> it = empPro.getProByEmp(id).getPros().iterator();
			while(it.hasNext()){
				pro = it.next();
				System.out.println("==项目名："+pro.getProName());
			}
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return pro;
	}
}
