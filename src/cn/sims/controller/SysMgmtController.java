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
import cn.sims.dao.SysuserMapper;
import cn.sims.model.Student;
import cn.sims.model.Sysuser;
import cn.sims.model.SysuserExample;

@Controller
@RequestMapping("/sysMgmt")
public class SysMgmtController {
	private SqlSession sqlSession;
	private SysuserMapper SysuserDao;
	List<Sysuser> list;
	@RequestMapping("/")
	public ModelAndView selectAllSysusers(HttpServletRequest request)
	{	
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);
		sqlSession = MyBatisUtil.getSqlSession();
		SysuserDao = sqlSession.getMapper(SysuserMapper.class);
		SysuserExample se = new SysuserExample();
		list = SysuserDao.selectByExample(se);
		PageInfo<Sysuser> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("mapname", "/");
		modelAndView.addObject("studentlist", page);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/account")
	public ModelAndView selectSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		SysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		if(account == null)account="";
		Sysuser sysuser = SysuserDao.selectByPrimaryKey(account);
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("Sysuser", sysuser);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		SysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		if(account == null)account="";
		int num=SysuserDao.deleteByPrimaryKey(account);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		SysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null)account="";
		Sysuser sysuser = new Sysuser(account,password);
		int num = SysuserDao.insert(sysuser);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		SysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null)account="";
		Sysuser sysuser = new Sysuser(account,password);
		int num = SysuserDao.updateByPrimaryKey(sysuser);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}
