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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.StudentMapper;
import cn.sims.dao.SysuserMapper;
import cn.sims.model.Student;
import cn.sims.model.StudentExample;
import cn.sims.model.Sysuser;
import cn.sims.model.SysuserExample;


@Controller
@RequestMapping("/stuMgmt")
public class StuMgmtController {
	private SqlSession sqlSession;
	private StudentMapper studentDao;
	List<Student> list;
	@RequestMapping("/")
	public ModelAndView selectAllStudent(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//锟斤拷取request锟斤拷锟斤拷锟侥碉拷前页锟斤拷
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//锟斤拷锟斤拷锟角耙筹拷娌伙拷戏锟斤拷锟斤拷锟轿�1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//锟斤拷询锟节硷拷页锟斤拷每页4锟斤拷锟斤拷录
		
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);//锟斤拷锟捷诧拷询锟矫碉拷锟斤拷list锟斤拷锟矫诧拷锟斤拷锟斤拷锟�PageInfo页锟斤拷锟斤拷息
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		modelAndView.addObject("mapname", "/");//锟斤拷锟斤拷映锟斤拷锟斤拷
		modelAndView.addObject("studentlist", page);//锟斤拷锟截诧拷锟斤拷锟斤拷傻锟揭筹拷锟斤拷锟较�PageInfo
		//modelAndView.addObject("attributeType","");//锟斤拷锟截憋拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟斤拷为selectAll锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为锟斤拷
		//modelAndView.addObject("arributeValue","");//锟斤拷锟截憋拷锟斤拷值
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertStudentByAccount(HttpServletRequest request) throws ParseException 
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
		int num = studentDao.insert(student);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		modelAndView.addObject("controllerMsg", "插入了"+num+"个学生信息");
		PageHelper.startPage(1,4);
		StudentExample se =new StudentExample();
		list=studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("mapname", "/");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateStudentBySno(HttpServletRequest request) throws ParseException
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
		ModelAndView modelAndView = new ModelAndView("alterStu");
		modelAndView.addObject("controllerMsg", "更新了"+num+"个学生信息");
		PageHelper.startPage(1,4);
		StudentExample se =new StudentExample();
		list=studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("mapname", "/");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		int num=studentDao.deleteByPrimaryKey(sno);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		modelAndView.addObject("controllerMsg", "删除了"+num+"个学生信息");
		PageHelper.startPage(1,4);
		StudentExample se =new StudentExample();
		list=studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("mapname", "/");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}

	
}
