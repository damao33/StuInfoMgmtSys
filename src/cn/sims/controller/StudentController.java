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
	public ModelAndView selectAllStudent(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//查询第几页，每页4条记录
		
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		ModelAndView modelAndView = new ModelAndView("stuInfo");
		modelAndView.addObject("mapname", "/");//传回映射名
		modelAndView.addObject("studentlist", page);//传回插件生成的页面信息PageInfo
		modelAndView.addObject("studentlist", list);
		//modelAndView.addObject("attributeType","");//返回变量类型，本方法为selectAll不需要参数，所以两个都为空
		//modelAndView.addObject("arributeValue","");//返回变量值
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/sno")
	public ModelAndView selectStudentBySno(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		StudentExample se = new StudentExample();
		StudentExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("stuInfo");
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("studentlist", list);
		modelAndView.addObject("mapname", "/sno");
		modelAndView.addObject("attributeType","&sno=");
		modelAndView.addObject("attributeValue", sno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/cls")
	public ModelAndView selectStudentByClass(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		String cls = request.getParameter("cls");
		if(cls == null)cls="0";
		StudentExample se = new StudentExample();
		StudentExample.Criteria c = se.createCriteria();
		c.andClnoEqualTo(cls);
		list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("stuInfo");
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("studentlist", list);
		modelAndView.addObject("mapname", "/cls");
		modelAndView.addObject("attributeType","&cls=");
		modelAndView.addObject("attributeValue", cls);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}

}
