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
import cn.sims.dao.CourseMapper;
import cn.sims.dao.ScoreMapper;
import cn.sims.model.Course;
import cn.sims.model.CourseExample;
import cn.sims.model.Score;
import cn.sims.model.ScoreExample;





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
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//��ѯ�ڼ�ҳ��ÿҳ4����¼
		
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("mapname", "/");//����ӳ����
		modelAndView.addObject("scorelist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/select")
	public ModelAndView selectAllScore(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//��ѯ�ڼ�ҳ��ÿҳ4����¼
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		PageInfo<Score> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		modelAndView.addObject("mapname", "/select");//����ӳ����
		modelAndView.addObject("scorelist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		//modelAndView.addObject("attributeType","");//���ر������ͣ�������ΪselectAll����Ҫ����������������Ϊ��
		//modelAndView.addObject("arributeValue","");//���ر���ֵ
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/sno")
	public ModelAndView selectScoreBySno(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String sno = request.getParameter("sno");
		if(sno == null)sno="";
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("scorelist", page);
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
		if(sno == null)sno="";
		ScoreExample scoreexample = new ScoreExample();
		int num=scoreDao.deleteByExample(scoreexample);
		sqlSession.commit();
		ModelAndView modelAndView = new ModelAndView("scoreMgmt");
		modelAndView.addObject("controllerMsg", "ɾ����"+num+"����¼");

		PageHelper.startPage(1, 4);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		modelAndView.addObject("scorelist",page);
		modelAndView.addObject("mapname","/");
		
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
		modelAndView.addObject("controllerMsg", "������"+num+"���û���Ϣ");

		PageHelper.startPage(1, 4);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);
		modelAndView.addObject("scorelist",page);
		modelAndView.addObject("mapname","/");
		
		MyBatisUtil.closeSqlSession();
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
		ModelAndView modelAndView = new ModelAndView("alterScore");
		modelAndView.addObject("num", num);

		PageHelper.startPage(1, 4);
		ScoreExample s = new ScoreExample();
		list = scoreDao.selectByExample(s);
		PageInfo<Score> page = new PageInfo<>(list);
		modelAndView.addObject("scorelist",page);
		modelAndView.addObject("mapname","/update");
		
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}