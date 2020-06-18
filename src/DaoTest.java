import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.dao.*;
import cn.sims.model.*;
import cn.sims.util.*;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MyBatisUtil.getSqlSession().getConnection();
		if(conn == null)System.out.println("conn is null");
		else System.out.println("conn is not null");
		
		PageHelper.startPage(1, 4);
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		StudentExample.Criteria c = se.createCriteria();
		
		
		c.andSsexEqualTo("ÄÐ");
		List<Student> list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		/*c.andClnoEqualTo("95031");
		List<Student> list = studentDao.selectByExample(se);*/
		
		/*c.andSnoEqualTo("109");
		int delStatement = studentDao.deleteByExample(se);*/
		
		/*int delStatement = studentDao.deleteByPrimaryKey("109");
		sqlSession.commit();
		System.out.println("delete:"+delStatement);*/
		
		
		System.out.println(list.size());
		/*for(Student now:list)
		{
			System.out.println(now);
		}*/
		for(Student now:page.getList())
		{
			System.out.println(now);
		}

		sqlSession.close();
	}

}
