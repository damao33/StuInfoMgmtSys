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
import cn.sims.model.Sysuser;
import cn.sims.model.SysuserExample;


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
		String cPage = request.getParameter("currentPage");//��ȡrequest�����ĵ�ǰҳ��
		if(cPage==null||cPage.equals("")||cPage.equals("0"))currentPage=1;//�����ǰҳ�治�Ϸ�����Ϊ1
		else currentPage = Integer.parseInt(cPage);
		PageHelper.startPage(currentPage, 4);//��ѯ�ڼ�ҳ��ÿҳ4����¼
		
		sqlSession = MyBatisUtil.getSqlSession();
		studentDao = sqlSession.getMapper(StudentMapper.class);
		StudentExample se = new StudentExample();
		list = studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);//���ݲ�ѯ�õ���list���ò������PageInfoҳ����Ϣ
		ModelAndView modelAndView = new ModelAndView("stuMgmt");
		modelAndView.addObject("mapname", "/");//����ӳ����
		modelAndView.addObject("studentlist", page);//���ز�����ɵ�ҳ����ϢPageInfo
		//modelAndView.addObject("attributeType","");//���ر������ͣ�������ΪselectAll����Ҫ����������������Ϊ��
		//modelAndView.addObject("arributeValue","");//���ر���ֵ
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
		modelAndView.addObject("controllerMsg", "������"+num+"��ѧ����Ϣ");
		PageHelper.startPage(1,4);
		StudentExample se =new StudentExample();
		list=studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("mapname", "/");
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
		modelAndView.addObject("controllerMsg", "������"+num+"��ѧ����Ϣ");
		PageHelper.startPage(1,4);
		StudentExample se =new StudentExample();
		list=studentDao.selectByExample(se);
		PageInfo<Student> page = new PageInfo<>(list);
		modelAndView.addObject("studentlist", page);
		modelAndView.addObject("mapname", "/");
		MyBatisUtil.closeSqlSession();
		return modelAndView;
	}

	
}
