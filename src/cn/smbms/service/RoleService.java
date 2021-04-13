package cn.smbms.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.smbms.dao.RoleDao;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * ��ɫҵ���
 * */
public class RoleService {

	RoleDao roleDao = new RoleDao();
	
	/**
	 * ��ѯָ����ɫ�û�
	 * @param id
	 * */
	/*public List<Role> getRoleList(Role role){ 
		Transaction tx = null;
		List<Role> roleList = null;
		try{
			//��ʼ����
			tx = HibernateUtil.getSession().beginTransaction();
			//�־û�����
			roleList = roleDao.getRoleList(role);
			//��������
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return roleList;
	}*/
	
	/**
	 * ���ݽ�ɫ��ѯ�û�
	 * */
	public List<User> getUserListById(int id){
		Transaction tx = null;
		List<User> userList = null;
		try{
			tx = HibernateUtil.getSession().beginTransaction();
			userList = roleDao.getUserListById(id);
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return userList;
	}
	
}
