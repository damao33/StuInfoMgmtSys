package cn.sims.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.StudentMapper;
import cn.sims.model.Student;
import cn.sims.model.StudentExample;


@Controller
@RequestMapping("/stuMgmt")
public class StuMgmtController {
	private SqlSession sqlSession;
	private StudentMapper studentDao;
	List<Student> list;
	@RequestMapping("/")
	public ModelAndView toStuMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		return modelAndView;		
	}
	@RequestMapping("/insert")
	public ModelAndView insertStudentByAccount(HttpServletRequest request) 
	{
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		Map<String, ?> map=request.getParameterMap();
		Student student = new Student();
		String sno=(String)map.get("sno");
		String sname=(String)map.get("sname");
		String ssex=(String)map.get("ssex");
		Date sbirthday=(Date)map.get("sbirthday");
		String clno=(String)map.get("clno");
		String sschool=(String)map.get("sschool");
		String sfaculty=(String)map.get("sfaculty");
		student.setSno(sno);
		student.setSname(sname);
		student.setSsex(ssex);
		student.setSbirthday(sbirthday);
		student.setClno(clno);
		student.setSschool(sschool);
		student.setSfaculty(sfaculty);
		int num = studentDao.insert(student);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateStudentByExample(HttpServletRequest request) throws ParseException
	{
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String sbirthday = request.getParameter("sbirthday");
		String clno = request.getParameter("clno");
		String sschool = request.getParameter("sschool");
		String sfaculty = request.getParameter("sfaculty");
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
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}

	
}
