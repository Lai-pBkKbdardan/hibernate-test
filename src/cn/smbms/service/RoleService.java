package cn.smbms.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cn.smbms.dao.RoleDao;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * 角色业务层
 * */
public class RoleService {

	RoleDao roleDao = new RoleDao();
	
	/**
	 * 查询指定角色用户
	 * @param id
	 * */
	/*public List<Role> getRoleList(Role role){ 
		Transaction tx = null;
		List<Role> roleList = null;
		try{
			//开始事务
			tx = HibernateUtil.getSession().beginTransaction();
			//持久化操作
			roleList = roleDao.getRoleList(role);
			//开启事务
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
	 * 根据角色查询用户
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
