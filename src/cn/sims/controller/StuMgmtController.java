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
import cn.sims.model.Student;
import cn.sims.model.StudentExample;


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
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//查询第几页，每页4条记录
		
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		modelAndView.addObject("mapname", "/");//传回映射名
		modelAndView.addObject("studentlist", page);//传回插件生成的页面信息PageInfo
		modelAndView.addObject("studentlist", list);
		//modelAndView.addObject("attributeType","");//返回变量类型，本方法为selectAll不需要参数，所以两个都为空
		//modelAndView.addObject("arributeValue","");//返回变量值
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
		modelAndView.addObject("controllerMsg", "增加了"+num+"条学生信息");
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
		modelAndView.addObject("controllerMsg", "更新了"+num+"条学生信息");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}

	
}
