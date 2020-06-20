package cn.sims.dao;

import cn.sims.model.Class;
import cn.sims.model.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(String clno);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);
    
    Class selectAll();

    Class selectByPrimaryKey(String clno);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}