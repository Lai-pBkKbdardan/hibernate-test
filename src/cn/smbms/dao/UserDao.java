package cn.smbms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * �û�DAO
 * */
public class UserDao {

	/**
	 * get���������������ض���
	 * 
	 * @param id
	 * @return user
	 * */
	public User get(Serializable id){
		return (User) HibernateUtil.getSession().get(User.class, id);
	}
	
	/**
	 * ���ݶ�������ֵ��ѯ�û���Ϣ
	 * @param user
	 * */
	public List<User> findByUser(User user){
		//���session
		Session session = HibernateUtil.getSession();
		//��дhql���
		String sql = "from User where userName=:userName";
		//����Query����
		Query query = session.createQuery(sql);
		query.setProperties(user);
		
		return query.list();
	}
	
	/**
	 * �����û����Բ�ѯ�û���Ϣ(��ҳ)
	 * @param user
	 * */
	public List<User> getUserListPage(User user,Integer pageIndex,Integer pageSize){
		//���session
		Session session = HibernateUtil.getSession();
		//����hql���
		String hql = "from User where id>:id";
		//����Query����
		/*Query query = session.createQuery(hql);
		query.setProperties(user);
		query.setFirstResult(pageIndex);
		query.setMaxResults(pageSize);
		return query.list();*/
		return session.createQuery(hql).setProperties(user).setFirstResult(pageIndex).setMaxResults(pageSize).list();
	}
	
	/**
	 * ˫��һ�Զ�
	 * */
	
}
