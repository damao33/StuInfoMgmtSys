package cn.sims.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static ThreadLocal<SqlSession> threadLocal = new
			ThreadLocal<>();
	private static SqlSessionFactory sqlSessionFactory;
	
	//��̬�����mybatis�����ļ�
	static
	{
		try
		{
			Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ֹ���ͨ��new��������
	 */
	private MyBatisUtil() {}
	
	/*
	 * ��ȡsqlsession
	 */
	public static SqlSession getSqlSession()
	{
		//�ӵ�ǰ�̻߳�ȡSqlSession����
		SqlSession sqlSession = threadLocal.get();
		//�ж�SqlSession�����Ƿ�Ϊ��
		if(sqlSession == null)
		{
			//��SqlSessionFactory����ǿյ�����£���ȡSqlSession����
			sqlSession = sqlSessionFactory.openSession();
			//��SqlSession�����뵱ǰ�̰߳���һ��
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	
	/*
	 * �ر�sqlsession�뵱ǰ�̷ֿ߳�
	 */
	public static void closeSqlSession()
	{
		//�ӵ�ǰ�߳��л�ȡSqlSession����
		SqlSession sqlSession = threadLocal.get();
		
		if(sqlSession != null)
		{
			//�ر�SqlSession����
			sqlSession.close();
			//�ֿ���ǰ�߳���SqlSession����Ĺ�ϵ��Ŀ���Ǿ��������������
			threadLocal.remove();
		}
	}
}

