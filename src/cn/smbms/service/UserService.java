package cn.smbms.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * 用户SERVICE
 * */
public class UserService {

	private UserDao userDao = new UserDao();
	
	/**
	 * get方法按照主键加载对象
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
	 * 根据对象属性值查询用户信息
	 * @param user
	 * */
	public List<User> findByUser(User user){
		Transaction tx = null;
		List<User> us = null;
		try{
			//开始事务
			tx = HibernateUtil.getSession().beginTransaction();
			//持久化操作
			us = userDao.findByUser(user);
			//开启事务
			tx.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			//异常回滚
			if(tx != null){
				tx.rollback();
			}
		}
		return us;
	}
	
	/**
	 * 根据用户属性查询用户信息(分页)
	 * @param user
	 * */
	public List<User> getUserListPage(User user,Integer pageIndex,Integer pageSize){
		Transaction tx = null;
		List<User> userList = null;
		try{
			//开启事务
			tx = HibernateUtil.getSession().beginTransaction();
			//持久化操作
			userList = userDao.getUserListPage(user,pageIndex,pageSize);
			//开启事务
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
