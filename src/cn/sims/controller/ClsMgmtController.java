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
import cn.sims.model.Class;
import cn.sims.model.ClassExample;
import cn.sims.model.Student;
import cn.sims.model.StudentExample;




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
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//��ѯ�ڼ�ҳ��ÿҳ4����¼
		
		sqlSession = MyBatisUtil.getSqlSession();
		classDao = sqlSession.getMapper(ClassMapper.class);
		ClassExample se = new ClassExample();
		list = classDao.selectByExample(se);
		PageInfo<Class> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("mapname", "/");//����ӳ����
		modelAndView.addObject("classlist", page);//���ز�����ɵ�ҳ����ϢPageInfo
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
		modelAndView.addObject("num", num);
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
		ModelAndView modelAndView = new ModelAndView("clsMgmt");
		modelAndView.addObject("num", num);
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}
	
}