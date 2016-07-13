package org.community.core.dao.impl;

import java.util.List;

import org.community.core.dao.FileUploadDao;
import org.community.core.model.mapper.FileUploadMapper;
import org.community.core.model.pojo.FileUpload;
import org.community.core.model.pojo.FileUploadExample;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by frodo on 2015/4/8.
 */
public class FileUploadDaoImpl extends BaseDaoImpl<FileUpload> implements FileUploadDao {

    @Autowired
    public FileUploadMapper fileUploadMapper;

    @Override
    public int create(FileUpload fileUpload) {
        return fileUploadMapper.insertSelective(fileUpload);
    }

    @Override
    public int update(FileUpload entity) {
        return fileUploadMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public FileUpload getByMD5(String md5) {
        FileUploadExample example = new FileUploadExample();
        FileUploadExample.Criteria criteria = example.createCriteria();
        criteria.andMd5EqualTo(md5);

        List<FileUpload> fileUploads = fileUploadMapper.selectByExample(example);
        if (fileUploads == null || fileUploads.isEmpty()) {
            return null;
        } else {
            return fileUploads.get(0);
        }
    }

    @Override
    public FileUpload getByName(String name) {
        FileUploadExample example = new FileUploadExample();
        FileUploadExample.Criteria criteria = example.createCriteria();
        criteria.andFileNameEqualTo(name);

        List<FileUpload> fileUploads = fileUploadMapper.selectByExample(example);
        if (fileUploads == null || fileUploads.isEmpty()) {
            return null;
        } else {
            return fileUploads.get(0);
        }
    }

    @Override
    public int insertAndGetId(FileUpload fileUpload) {
        return 0;
    }

}
