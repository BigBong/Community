package org.community.core.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.community.core.model.pojo.FileUpload;
import org.community.core.model.pojo.FileUploadExample;

public interface FileUploadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int countByExample(FileUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int deleteByExample(FileUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int insert(FileUpload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int insertSelective(FileUpload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    List<FileUpload> selectByExample(FileUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    FileUpload selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FileUpload record, @Param("example") FileUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FileUpload record, @Param("example") FileUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FileUpload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upload
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FileUpload record);
}