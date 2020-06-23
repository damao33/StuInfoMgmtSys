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
import cn.sims.dao.StudentMapper;
import cn.sims.dao.SysuserMapper;
import cn.sims.model.Class;
import cn.sims.model.ClassExample;
import cn.sims.model.Student;
import cn.sims.model.StudentExample;
import cn.sims.model.Sysuser;




@Controller
@RequestMapping("/clsMgmt")
public class ClsMgmtController {
	private SqlSession sqlSession;
	private ClassMapper classDao;
	List<Class> list;
	
	
	@RequestMapping("/")
	public ModelAndView toclsMgmt(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//查询第几页，每页4条记录
		
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		ClassExample se = new ClassExample();
		list = classDao.selectByExample(se);
		PageInfo<Class> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("mapname", "/");//传回映射名
		modelAndView.addObject("classlist", page);//传回插件生成的页面信息PageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/clno")
	public ModelAndView selectClassByClno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		if(clno == null)clno="";
		Class cls = classDao.selectByPrimaryKey(clno);
		ModelAndView modelAndView = new ModelAndView("alterClass");
		modelAndView.addObject("cls", cls);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteClassByClno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		if(clno == null)clno="";
		int num=classDao.deleteByPrimaryKey(clno);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("num", num);
		
		PageHelper.startPage(1, 4);
		ClassExample se = new ClassExample();
		list = classDao.selectByExample(se);
		PageInfo<Class> page = new PageInfo<>(list);
		modelAndView.addObject("classlist",page);
		modelAndView.addObject("mapname","/");
		modelAndView.addObject("controllerMsg","删除了"+num+"条记录");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertClassByClno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		String clname = request.getParameter("clname");
		String htname  = request.getParameter("htname");
		String htno = request.getParameter("htno");
		if(clno == null)clno="";
		Class cls=new Class();
		cls.setClno(clno);
		cls.setClname(clname);
		cls.setHtno(htno);
		cls.setHtname(htname);
		int num = classDao.insert(cls);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("controllerMsg", "增加了"+num+"条用户信息");
		
		PageHelper.startPage(1, 4);
		ClassExample se = new ClassExample();
		list = classDao.selectByExample(se);
		PageInfo<Class> page = new PageInfo<>(list);
		modelAndView.addObject("classlist",page);
		modelAndView.addObject("mapname","/");
		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateClassByExample(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		String clno = request.getParameter("clno");
		String clname = request.getParameter("clname");
		String htname  = request.getParameter("htname");
		String htno = request.getParameter("htno");
		if(clno == null)clno="";
		Class cls = new Class();
		ClassExample se = new ClassExample();
		ClassExample.Criteria c = se.createCriteria();
		c.andClnoEqualTo(clno);
		cls.setClno(clno);
		cls.setClname(clname);
		cls.setHtno(htno);
		cls.setHtname(htname);
		int num = classDao.updateByExample(cls,se);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("alterClass");
		modelAndView.addObject("controllerMsg", "更新了"+num+"条记录");

		PageHelper.startPage(1, 4);
		ClassExample s = new ClassExample();
		list = classDao.selectByExample(s);
		PageInfo<Class> page = new PageInfo<>(list);
		modelAndView.addObject("classlist",page);
		modelAndView.addObject("mapname","/update");
		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}