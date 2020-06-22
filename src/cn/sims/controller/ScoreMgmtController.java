package cn.sims.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sims.util.MyBatisUtil;

import cn.sims.dao.ScoreMapper;
import cn.sims.model.Score;
import cn.sims.model.ScoreExample;




@Controller
@RequestMapping("/scoreMgmt")
public class ScoreMgmtController {
	private SqlSession sqlSession;
	private ScoreMapper scoreDao;
	List<Score> list;
	
	
	@RequestMapping("/")
	public ModelAndView toscoreMgmt()
	{
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		return modelAndView;		
	}
	@RequestMapping("/select")
	public ModelAndView selectAllScore()
	{
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("scorelist", list);
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteScoreBySno(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		ScoreExample scoreexample = new ScoreExample();
		int num=scoreDao.deleteByExample(scoreexample);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("num", num);
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
		if(sno == null)sno="";
		if(degrees == null||degrees =="")degrees="0";
		Score score=new Score();
		score.setSno(sno);
		score.setSname(sname);
		score.setCno(cno);
		score.setCname(cname);
		BigDecimal degree=new BigDecimal(degrees);
		score.setDegrees(degree);
		int num = scoreDao.insert(score);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("num", num);
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateScoreByExample(HttpServletRequest request)
	{
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String degrees = request.getParameter("degrees");
		if(sno == null)sno="";
		if(degrees == null||degrees =="")degrees="0";
		Score score = new Score();
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		score.setSno(sno);
		score.setSname(sname);
		score.setCno(cno);
		score.setCname(cname);
		BigDecimal degree=new BigDecimal(degrees);
		score.setDegrees(degree);
		int num = scoreDao.updateByExample(score,se);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("num", num);
		return modelAndView;
	}
	
}