package cn.sims.controller;

import java.util.List;

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
@RequestMapping("/stuInfo")
public class StudentController {
	
	private SqlSession sqlSession;
	private StudentMapper studentDao;
	List<Student> list;
	
	@RequestMapping("/")
	public ModelAndView selectAllStudent()
	{
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		list = studentDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("stuInfo");
		modelAndView.addObject("studentlist", list);
		return modelAndView;
	}
	@RequestMapping("/sno")
	public ModelAndView selectStudentBySno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		StudentExample se = new StudentExample();
		StudentExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = studentDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("stuInfo");
		modelAndView.addObject("studentlist", list);
		return modelAndView;
	}

}
