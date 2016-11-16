package org.community.core.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.community.core.model.pojo.AssignedRole;
import org.community.core.model.pojo.AssignedRoleExample;

public interface AssignedRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    int countByExample(AssignedRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    int deleteByExample(AssignedRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    int insert(AssignedRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    int insertSelective(AssignedRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    List<AssignedRole> selectByExample(AssignedRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AssignedRole record, @Param("example") AssignedRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assigned_role
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AssignedRole record, @Param("example") AssignedRoleExample example);
}