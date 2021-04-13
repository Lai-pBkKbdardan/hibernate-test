package cn.smbms.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * �û�SERVICE
 * */
public class UserService {

	private UserDao userDao = new UserDao();
	
	/**
	 * get���������������ض���
	 * 
	 * @param i
	 * @return user
	 * */
	public User findUserById(Integer i){
		
		Transaction tx = null;
		User user = null;
		try{
			tx = HibernateUtil.getSession().beginTransaction();
			user = userDao.get(i);
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return user;
	}
	
	/**
	 * ���ݶ�������ֵ��ѯ�û���Ϣ
	 * @param user
	 * */
	public List<User> findByUser(User user){
		Transaction tx = null;
		List<User> us = null;
		try{
			//��ʼ����
			tx = HibernateUtil.getSession().beginTransaction();
			//�־û�����
			us = userDao.findByUser(user);
			//��������
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			//�쳣�ع�
			if(tx != null){
				tx.rollback();
			}
		}
		return us;
	}
	
	/**
	 * �����û����Բ�ѯ�û���Ϣ(��ҳ)
	 * @param user
	 * */
	public List<User> getUserListPage(User user,Integer pageIndex,Integer pageSize){
		Transaction tx = null;
		List<User> userList = null;
		try{
			//��������
			tx = HibernateUtil.getSession().beginTransaction();
			//�־û�����
			userList = userDao.getUserListPage(user,pageIndex,pageSize);
			//��������
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
