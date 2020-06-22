import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.dao.*;
import cn.sims.model.*;
import cn.sims.util.*;

public class DaoTest {

	public static void main(String[] args) throws ParseException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		String sno = "101";
		String sname = "asd";
		String ssex = "男";
		String sbirthday = "2020-10-10";
		String clno = "95033";
		String sschool = "理学院";
		String sfaculty = "应用物理学";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday =  sdf.parse(sbirthday);
		Student student = new Student();
		student.setSno(sno);
		student.setSname(sname);
		student.setSsex(ssex);
		student.setSbirthday(birthday);
		student.setClno(clno);
		student.setSschool(sschool);
		student.setSfaculty(sfaculty);
		int num = studentDao.updateByPrimaryKey(student);
		System.out.println("num："+num);
		sqlSession.commit();
		MyBatisUtil.closeSqlSession();
	}

}
