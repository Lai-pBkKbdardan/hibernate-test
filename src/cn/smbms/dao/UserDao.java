package cn.smbms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * 用户DAO
 * */
public class UserDao {

	/**
	 * get方法按照主键加载对象
	 * 
	 * @param id
	 * @return user
	 * */
	public User get(Serializable id){
		return (User) HibernateUtil.getSession().get(User.class, id);
	}
	
	/**
	 * 根据对象属性值查询用户信息
	 * @param user
	 * */
	public List<User> findByUser(User user){
		//获得session
		Session session = HibernateUtil.getSession();
		//编写hql语句
		String sql = "from User where userName=:userName";
		//创建Query对象
		Query query = session.createQuery(sql);
		query.setProperties(user);
		
		return query.list();
	}
	
	/**
	 * 根据用户属性查询用户信息(分页)
	 * @param user
	 * */
	public List<User> getUserListPage(User user,Integer pageIndex,Integer pageSize){
		//获得session
		Session session = HibernateUtil.getSession();
		//创建hql语句
		String hql = "from User where id>:id";
		//创建Query对象
		/*Query query = session.createQuery(hql);
		query.setProperties(user);
		query.setFirstResult(pageIndex);
		query.setMaxResults(pageSize);
		return query.list();*/
		return session.createQuery(hql).setProperties(user).setFirstResult(pageIndex).setMaxResults(pageSize).list();
	}
	
	/**
	 * 双向一对多
	 * */
	
}
