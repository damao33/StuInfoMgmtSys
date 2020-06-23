package cn.sims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.ClassMapper;
import cn.sims.dao.CourseMapper;
import cn.sims.model.Class;
import cn.sims.model.Course;
import cn.sims.model.CourseExample;



@Controller
@RequestMapping("/cozMgmt")
public class CozMgmtController {
	private SqlSession sqlSession;
	private CourseMapper courseDao;
	List<Course> list;
	
	
	@RequestMapping("/")
	public ModelAndView tocozMgmt(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//��ѯ�ڼ�ҳ��ÿҳ4����¼
		
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		CourseExample se = new CourseExample();
		list = courseDao.selectByExample(se);
		PageInfo<Course> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("mapname", "/");//����ӳ����
		modelAndView.addObject("courselist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/cno")
	public ModelAndView selectCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		if(cno == null)cno="";
		Course course = courseDao.selectByPrimaryKey(cno);
		ModelAndView modelAndView = new ModelAndView("alterCoz");
		modelAndView.addObject("course", course);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		if(cno == null||cno.equals(""))cno="";
		int num=courseDao.deleteByPrimaryKey(cno);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("controllerMsg", "ɾ����"+num+"����¼");
		PageHelper.startPage(1, 4);
		CourseExample se = new CourseExample();
		list = courseDao.selectByExample(se);
		PageInfo<Course> page = new PageInfo<>(list);
		modelAndView.addObject("courselist",page);
		modelAndView.addObject("mapname","/");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertCourseByCno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String tno = request.getParameter("tno");
		String tname = request.getParameter("tname");
		if(cno == null)cno="";
		Course course=new Course();
		course.setCno(cno);
		course.setCname(cname);
		course.setTno(tno);
		course.setTname(tname);
		int num = courseDao.insert(course);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("cozMgmt");
		modelAndView.addObject("controllerMsg", "������"+num+"���û���Ϣ");

		PageHelper.startPage(1, 4);
		CourseExample se = new CourseExample();
		list = courseDao.selectByExample(se);
		PageInfo<Course> page = new PageInfo<>(list);
		modelAndView.addObject("courselist",page);
		modelAndView.addObject("mapname", "/insert");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateCourseByExample(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		courseDao = sqlSession.getMapper(CourseMapper.class);
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String tno = request.getParameter("tno");
		String tname = request.getParameter("tname");
		if(cno == null)cno="";
		Course course = new Course();
		CourseExample se = new CourseExample();
		CourseExample.Criteria c = se.createCriteria();
		c.andCnoEqualTo(cno);
		course.setCno(cno);
		course.setCname(cname);
		course.setTno(tno);
		course.setTname(tname);
		int num = courseDao.updateByExample(course,se);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("alterCoz");
		modelAndView.addObject("num", num);

		PageHelper.startPage(1, 4);
		CourseExample s = new CourseExample();
		list = courseDao.selectByExample(s);
		PageInfo<Course> page = new PageInfo<>(list);
		modelAndView.addObject("courselist",page);
		modelAndView.addObject("mapname","/update");		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}