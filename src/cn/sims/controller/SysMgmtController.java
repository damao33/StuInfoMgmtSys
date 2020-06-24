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
import cn.sims.model.Sysuser;
import cn.sims.model.SysuserExample;

@Controller
@RequestMapping("/sysMgmt")
public class SysMgmtController {
	private SqlSession sqlSession;
	private SysuserMapper sysuserDao;
	List<Sysuser> list;
	@RequestMapping("/")
	public ModelAndView selectAllSysusers(HttpServletRequest request)
	{	
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);
		sqlSession = MyBatisUtil.getSqlSession();
		sysuserDao = sqlSession.getMapper(SysuserMapper.class);
		SysuserExample se = new SysuserExample();
		list = sysuserDao.selectByExample(se);
		PageInfo<Sysuser> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("mapname", "/");
		modelAndView.addObject("sysuserlist", page);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/account")
	public ModelAndView selectSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		sysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		if(account == null)account="";
		Sysuser sysuser = sysuserDao.selectByPrimaryKey(account);
		ModelAndView modelAndView = new ModelAndView("alterSysuser");
		modelAndView.addObject("sysuser", sysuser);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		sysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		if(account == null)account="";
		int num=sysuserDao.deleteByPrimaryKey(account);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		modelAndView.addObject("controllerMsg", "删除了"+num+"条记录");
		PageHelper.startPage(1,7);
		SysuserExample se =new SysuserExample();
		list=sysuserDao.selectByExample(se);
		PageInfo<Sysuser> page = new PageInfo<>(list);
		modelAndView.addObject("sysuserlist", page);
		modelAndView.addObject("mapname", "/");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		sysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null)account="";
		PageHelper.startPage(1,7);
		SysuserExample se =new SysuserExample();
		SysuserExample.Criteria c = se.createCriteria();
		c.andAccountEqualTo(account);
		list=sysuserDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("sysMgmt");
		if(list.size()>0)
		{
			PageInfo<Sysuser> page = new PageInfo<>(list);
			modelAndView.addObject("controllerMsg", "账号已存在！");
			modelAndView.addObject("mapname", "/");
			modelAndView.addObject("sysuserlist", page);
			return modelAndView;
		}
		Sysuser sysuser = new Sysuser(account,password);
		int num = sysuserDao.insert(sysuser);
		sqlSession.commit();
		modelAndView.addObject("controllerMsg", "插入了"+num+"条记录");
		SysuserExample se1 =new SysuserExample();
		list=sysuserDao.selectByExample(se1);
		PageInfo<Sysuser> page1 = new PageInfo<>(list);
		modelAndView.addObject("mapname", "/");
		modelAndView.addObject("sysuserlist", page1);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateSysuserByAccount(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		sysuserDao = sqlSession.getMapper(SysuserMapper.class);
		String account = request.getParameter("account");
		String newpassword = request.getParameter("newpassword");
		Sysuser sysuser = new Sysuser(account,newpassword);
		int num = sysuserDao.updateByPrimaryKey(sysuser);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("alterSysuser");
		modelAndView.addObject("controllerMsg", "更新了"+num+"条记录");
		SysuserExample se =new SysuserExample();
		list=sysuserDao.selectByExample(se);
		modelAndView.addObject("sysuser", sysuser);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}
