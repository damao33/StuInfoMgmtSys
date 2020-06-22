package cn.sims.dao;

import cn.sims.model.CollegeExample;
import cn.sims.model.CollegeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(CollegeKey key);

    int insert(CollegeKey record);

    int insertSelective(CollegeKey record);

    List<CollegeKey> selectByExample(CollegeExample example);

    int updateByExampleSelective(@Param("record") CollegeKey record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") CollegeKey record, @Param("example") CollegeExample example);
}