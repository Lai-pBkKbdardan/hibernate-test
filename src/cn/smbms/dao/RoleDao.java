package cn.smbms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * 角色接口
 * */
public class RoleDao {

	/**
	 * 查询指定角色用户
	 * @param id
	 * */
	public List<User> getRoleList(Role role){
		//获取session
		Session session = HibernateUtil.getSession();
		//创建hql语句
		String hql = "from Role where id=id";
		//创建Qquery对象
		Query query = session.createQuery(hql);
		query.setProperties(query);
		return query.list();
	}
	
	/**
	 * 根据用户角色查询用户
	 * */
	public List<User> getUserListById(int id){
		return (List<User>)HibernateUtil.getSession().get(Role.class,id);
	}
	
}
