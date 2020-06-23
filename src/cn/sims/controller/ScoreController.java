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
	
	@RequestMapping("/")//��ѯ����
	public ModelAndView toscoreMgmt(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//��ѯ�ڼ�ҳ��ÿҳ7����¼
		
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		ScoreExample se = new ScoreExample();
		list = scoreDao.selectByExample(se);
		PageInfo<Score> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		ModelAndView modelAndView = new ModelAndView("scoreInfo");
		modelAndView.addObject("mapname", "/");//����ӳ����
		modelAndView.addObject("scorelist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/cno")
	public ModelAndView selectScoreByCno(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//��ѯ�ڼ�ҳ��ÿҳ7����¼
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String  cno = request.getParameter("cno");
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andCnoEqualTo(cno);
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreInfo");
		PageInfo<Score> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		modelAndView.addObject("mapname", "/cno");//����ӳ����
		modelAndView.addObject("scorelist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		modelAndView.addObject("attributeType","&cno=");
		modelAndView.addObject("attributeValue", cno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	@RequestMapping("/sno")
	public ModelAndView selectScoreBySno(HttpServletRequest request)
	{
		int currentPage;
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 7);//��ѯ�ڼ�ҳ��ÿҳ7����¼
		sqlSession = MyBatisUtil.getSqlSession();
		scoreDao = sqlSession.getMapper(ScoreMapper.class);
		String  sno = request.getParameter("sno");
		ScoreExample se = new ScoreExample();
		ScoreExample.Criteria c = se.createCriteria();
		c.andSnoEqualTo(sno);
		list = scoreDao.selectByExample(se);
		ModelAndView modelAndView = new ModelAndView("scoreInfo");
		PageInfo<Score> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		modelAndView.addObject("mapname", "/sno");//����ӳ����
		modelAndView.addObject("scorelist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		modelAndView.addObject("attributeType","&sno=");
		modelAndView.addObject("attributeValue", sno);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
}
