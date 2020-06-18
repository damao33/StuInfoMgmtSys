package cn.sims.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.StudentMapper;
import cn.sims.model.Student;
import cn.sims.model.StudentExample;


@Controller
@RequestMapping("/student")
public class StudentInfoController {
	
	private SqlSession sqlSession;
	private StudentMapper studentDao;
	List<Student> list;
	
	@RequestMapping("/")
	public ModelAndView studentinfo()
	{
		
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		StudentExample.Criteria c = se.createCriteria();
		c.andSsexEqualTo("ÄÐ");
		list = studentDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("view");
		modelAndView.addObject("studentlist", list);
		return modelAndView;
	}

}
