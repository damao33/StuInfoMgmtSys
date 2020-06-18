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
	
	//静态块加载mybatis配置文件
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
	 * 禁止外界通过new方法创建
	 */
	private MyBatisUtil() {}
	
	/*
	 * 获取sqlsession
	 */
	public static SqlSession getSqlSession()
	{
		//从当前线程获取SqlSession对象
		SqlSession sqlSession = threadLocal.get();
		//判断SqlSession对象是否为空
		if(sqlSession == null)
		{
			//在SqlSessionFactory对象非空的情况下，获取SqlSession对象
			sqlSession = sqlSessionFactory.openSession();
			//将SqlSession对象与当前线程绑定在一起
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	
	/*
	 * 关闭sqlsession与当前线程分开
	 */
	public static void closeSqlSession()
	{
		//从当前线程中获取SqlSession对象
		SqlSession sqlSession = threadLocal.get();
		
		if(sqlSession != null)
		{
			//关闭SqlSession对象
			sqlSession.close();
			//分开当前线程与SqlSession对象的关系，目的是尽早进行垃圾回收
			threadLocal.remove();
		}
	}
}

