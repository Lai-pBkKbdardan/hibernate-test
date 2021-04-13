package cn.smbms.service;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.smbms.dao.EmpProDao;
import cn.smbms.pojo.Pro;
import cn.smbms.tools.HibernateUtil;

/**
 * ˫���Զ�
 * */
public class EmpProService {

	EmpProDao empPro = new EmpProDao();
	/**
	 * ����Ա����ѯ��Ŀ
	 * */
	public Pro getProByEmp(int id){
		Transaction tx = null;
		Pro pro = null;
		try{
			tx = HibernateUtil.getSession().beginTransaction();
			Iterator<Pro> it = empPro.getProByEmp(id).getPros().iterator();
			while(it.hasNext()){
				pro = it.next();
				System.out.println("==��Ŀ����"+pro.getProName());
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
