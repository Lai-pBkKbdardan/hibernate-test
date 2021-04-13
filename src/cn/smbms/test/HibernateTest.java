package cn.smbms.test;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.smbms.pojo.Emp;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

public class HibernateTest {

	/**
	 * ���ݱ�ʶ�в�ѯ�û�
	 * */
	public User getUserById(Integer id){
		return (User) HibernateUtil.getSession().get(User.class, id);
	}
	
	/**
	 * ��ѯ�û���������Ϣ
	 * @param name
	 * */
	public void getUserList(String name){
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//��дhql���
		String hql = "from User where userName=:userName";
		//����Query����
		Query query = session.createQuery(hql);
		query.setParameter("userName", name);
		//ִ�в���
		List<User> users = query.list();
		//�������󼯺�
		for (User user : users) {
			System.out.println("==="+user.getUserCode());
		}
	}
	
	/**
	 * ���ݶ�������ֵ��ѯ�û���Ϣ
	 * @param user
	 * */
	public void getUserList2(User user){
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//��дhql���
		String hql = "from User where userName=:userName";
		//����Query����
		Query query = session.createQuery(hql);
		query.setProperties(user);
		//ִ�в���
		List<User> users = query.list();
		//�������󼯺�
		for (User user1 : users) {
			System.out.println("==="+user1.getUserCode());
		}
	}
	
	/**
	 * ���ݶ�������ֵ��ѯ�û���Ϣ(��ҳ)
	 * @param user
	 * */
	public void getUserListByIdPage(User user){
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//��дhql���
		String hql = "from User where id>:id";
		//����Query����
		Query query = session.createQuery(hql);
		query.setProperties(user);
		query.setFirstResult(0);
		query.setMaxResults(4);
		//�־û�����
		List<User> userList = query.list();
		for (User user2 : userList) {
			System.out.println("===>"+user2.getId()+user2.getUserName());
		}
	}
	/**
	 * �ܼ�¼��
	 * */
	public void userListCount(User user){
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//��дhql
		String hql = "select count(id) from User where id>:id";
		//����Query����
		Query query = session.createQuery(hql);
		query.setProperties(user);
		//�־û�����
		Long result = (Long) query.uniqueResult();
		System.out.println("====>>>"+result);
	}
	/**
	 * ʹ��ͶӰ��ѯ������Ϣ
	 * */
	public void getUserList(){
		//��ȡsession
		Session session = HibernateUtil.getSession();
		//��дhql���
		String hql = "select new User(id,userName) from User";
		//����Query����
		Query query = session.createQuery(hql);
		//�־û�����
		List<User> users = query.list();
		for (User user : users) {
			System.out.println("==="+user.getId()+"==="+user.getUserName());
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/**
		 * ���ݱ�ʶ�в�ѯ�û�
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		User user = new HibernateTest().getUserById(8);
		tr.commit();
		System.out.println(user.getUserCode()+"=="+user.getUserName());*/
		
		/**
		 * ��ѯ�û���������Ϣ
		 * @param name
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		test.getUserList("����");
		tr.commit();*/
		
		/**
		 * ���ݶ�������ֵ��ѯ�û���Ϣ
		 * @param user
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		User user = new User();
		user.setUserName("����");
		test.getUserList2(user);
		tr.commit();*/
		
		/**
		 * ���ݶ�������ֵ��ѯ�û���Ϣ(��ҳ)
		 * @param user
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		User user = new User();
		user.setId(1);
		test.getUserListByIdPage(user);
		tr.commit();*/
		
		/**
		 * �ܼ�¼��
		 * */
		/*Transaction tx = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		User user = new User();
		user.setId(1);
		test.userListCount(user);*/
		
		/**
		 * ʹ��ͶӰ��ѯ������Ϣ
		 * */
		Transaction tx = HibernateUtil.getSession().beginTransaction();
		HibernateTest test = new HibernateTest();
		test.getUserList();
		tx.commit();
		
	}
}
