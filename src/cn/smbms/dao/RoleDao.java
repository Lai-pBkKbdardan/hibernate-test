package cn.smbms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

/**
 * ��ɫ�ӿ�
 * */
public class RoleDao {

	/**
	 * ��ѯָ����ɫ�û�
	 * @param id
	 * */
	public List<User> getRoleList(Role role){
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//����hql���
		String hql = "from Role where id=id";
		//����Qquery����
		Query query = session.createQuery(hql);
		query.setProperties(query);
		return query.list();
	}
	
	/**
	 * �����û���ɫ��ѯ�û�
	 * */
	public List<User> getUserListById(int id){
		return (List<User>)HibernateUtil.getSession().get(Role.class,id);
	}
	
}
