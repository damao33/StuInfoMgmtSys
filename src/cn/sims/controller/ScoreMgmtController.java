package cn.sims.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.util.MyBatisUtil;
import cn.sims.dao.ScoreMapper;
import cn.sims.model.CourseExample;
import cn.sims.model.Score;
import cn.sims.model.ScoreExample;
import cn.sims.model.Sysuser;
import cn.sims.model.SysuserExample;

@Controller
@RequestMapping("/scoreMgmt")
public class ScoreMgmtController {
	private SqlSession sqlSession;
	private ScoreMapper scoreDao;
	List<Score> list;
	
	
	@RequestMapping("/")
	public ModelAndView toscoreMgmt(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//查询第几页，每页4条记录
		
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("mapname", "/");//传回映射名
		modelAndView.addObject("scorelist", page);//传回插件生成的页面信息PageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/select")
	public ModelAndView selectAllScore(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//查询第几页，每页4条记录
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		PageInfo<Score> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		modelAndView.addObject("mapname", "/select");//传回映射名
		modelAndView.addObject("scorelist", page);//传回插件生成的页面信息PageInfo
		//modelAndView.addObject("attributeType","");//返回变量类型，本方法为selectAll不需要参数，所以两个都为空
		//modelAndView.addObject("arributeValue","");//返回变量值
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/sno")
	public ModelAndView selectScoreBySno1(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("alterScore");      
		modelAndView.addObject("scorelist", page);
		modelAndView.addObject("sno", sno);
		modelAndView.addObject("mapname", "/sno");
		modelAndView.addObject("attributeType","&sno=");
		modelAndView.addObject("attributeValue", sno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/sno2")
	public ModelAndView selectScoreBySno2(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("delScore");
		modelAndView.addObject("scorelist", page);
		modelAndView.addObject("sno", sno);
		modelAndView.addObject("mapname", "/sno");
		modelAndView.addObject("attributeType","&sno=");
		modelAndView.addObject("attributeValue", sno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteScoreBySno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		String cno = request.getParameter("cno");
		if(sno == null)sno="";
		ScoreExample scoreexample = new ScoreExample();
		ScoreExample.Criteria c = scoreexample.createCriteria();
		c.andCnoEqualTo(cno);
		c.andSnoEqualTo(sno);
		System.out.println(cno);
		System.out.println(sno);
		int num=scoreDao.deleteByExample(scoreexample);   
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("delScore");
		modelAndView.addObject("controllerMsg", "删除了"+num+"条记录");

		PageHelper.startPage(1, 7);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		modelAndView.addObject("scorelist",page);
		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/insert")
	public ModelAndView insertScoreBySno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String degrees = request.getParameter("degrees");
		
		ScoreExample es =new ScoreExample();
		ScoreExample.Criteria c = es.createCriteria();
		c.andSnoEqualTo(sno);
		c.andCnoEqualTo(cno);
		list=scoreDao.selectByExample(es);
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		if(sno == null)sno="";
		if(degrees == null||degrees =="")degrees="0";
		System.out.println("0");
		if(list.size()>0)
		{
			System.out.println("1");
			PageInfo<Score> page = new PageInfo<>(list);
			modelAndView.addObject("controllerMsg", "分数已存在！");
			modelAndView.addObject("mapname", "/");
			modelAndView.addObject("scorelist", page);
			return modelAndView;
		}
		

		Score score=new Score();
		score.setSno(sno);
		score.setSname(sname);
		score.setCno(cno);
		score.setCname(cname);
		BigDecimal degree=new BigDecimal(degrees);
		score.setDegrees(degree);
		int num = scoreDao.insert(score);
		sqlSession.commit();
		//ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("controllerMsg", "增加了"+num+"条用户信息");

		PageHelper.startPage(1, 7);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		modelAndView.addObject("scorelist",page);
		modelAndView.addObject("mapname","/insert");
		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateScoreByExample(HttpServletRequest request)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String cno = request.getParameter("cno");
		System.out.println(cno);
		System.out.println(sno);
		String cname = request.getParameter("cname");
		String degrees = request.getParameter("degrees");
		if(sno == null)sno="";
		if(degrees == null||degrees =="")degrees="0"; 
		if(sname==null)sname="";
		if(cno==null)cno="";
		if(cname==null)cname="";               
		Score score = new Score();
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		c.andCnoEqualTo(cno);   
		BigDecimal degree=new BigDecimal(degrees);                 
		if(sno!=null)score.setSno(sno);
		if(sname!=null)score.setSname(sname);
		if(cno!=null)score.setCno(cno);
		if(cname!=null)score.setCname(cname);
		if(degree!=null)score.setDegrees(degree);
		System.out.println(degree);
		System.out.println(degrees);
		scoreDao.updateBySnoCno(score);  
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("alterScore");         
		PageHelper.startPage(1, 7);
		ScoreExample s = new ScoreExample();  
		ScoreExample.Criteria ce = s.createCriteria();  
		ce.andSnoEqualTo(sno); 
	
		list = scoreDao.selectByExample(s);
		PageInfo<Score> page = new PageInfo<>(list);    
		modelAndView.addObject("scorelist",page);

		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}