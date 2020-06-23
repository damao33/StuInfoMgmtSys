package cn.sims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sims.dao.ScoreMapper;
import cn.sims.model.Score;
import cn.sims.model.ScoreExample;
import cn.sims.util.MyBatisUtil;

@Controller
@RequestMapping("/scoreInfo")
public class ScoreController {
	
	private SqlSession sqlSession;
	private ScoreMapper scoreDao;
	List<Score> list;
	
	@RequestMapping("/")//查询所有
	public ModelAndView toscoreMgmt(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//查询第几页，每页7条记录
		
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		ModelAndView modelAndView = new ModelAndView("scoreInfo");
		modelAndView.addObject("mapname", "/");//传回映射名
		modelAndView.addObject("scorelist", page);//传回插件生成的页面信息PageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/cno")
	public ModelAndView selectScoreByCno(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//查询第几页，每页7条记录
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String  cno = request.getParameter("cno");
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andCnoEqualTo(cno);
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreInfo");
		PageInfo<Score> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		modelAndView.addObject("mapname", "/cno");//传回映射名
		modelAndView.addObject("scorelist", page);//传回插件生成的页面信息PageInfo
		modelAndView.addObject("attributeType","&cno=");
		modelAndView.addObject("attributeValue", cno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/sno")
	public ModelAndView selectScoreBySno(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//获取request传来的当前页面
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//如果当前页面不合法则设为1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//查询第几页，每页7条记录
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String  sno = request.getParameter("sno");
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreInfo");
		PageInfo<Score> page = new PageInfo<>(list);//根据查询得到的list来用插件生成PageInfo页面信息
		modelAndView.addObject("mapname", "/sno");//传回映射名
		modelAndView.addObject("scorelist", page);//传回插件生成的页面信息PageInfo
		modelAndView.addObject("attributeType","&sno=");
		modelAndView.addObject("attributeValue", sno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
}
