package org.community.core.dao.impl;

import java.util.List;

import org.community.core.dao.FileUploadDao;
import org.community.core.model.mapper.LocalFileMapper;
import org.community.core.model.pojo.LocalFile;
import org.community.core.model.pojo.LocalFileExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by frodo on 2015/4/8.
 */
@Repository("fileUploadDao")
public class FileUploadDaoImpl extends BaseDaoImpl<LocalFile> implements FileUploadDao {

    @Autowired
    public LocalFileMapper localFileMapper;

    @Override
    public int create(LocalFile file) {
        return localFileMapper.insertSelective(file);
    }

    @Override
    public int update(LocalFile entity) {
        return localFileMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public LocalFile getByMD5(String md5) {
        LocalFileExample example = new LocalFileExample();
        LocalFileExample.Criteria criteria = example.createCriteria();
        criteria.andMd5EqualTo(md5);

        List<LocalFile> fileUploads = localFileMapper.selectByExample(example);
        if (fileUploads == null || fileUploads.isEmpty()) {
            return null;
        } else {
            return fileUploads.get(0);
        }
    }

    @Override
    public LocalFile getByName(String name) {
        LocalFileExample example = new LocalFileExample();
        LocalFileExample.Criteria criteria = example.createCriteria();
        criteria.andFileNameEqualTo(name);

        List<LocalFile> fileUploads = localFileMapper.selectByExample(example);
        if (fileUploads == null || fileUploads.isEmpty()) {
            return null;
        } else {
            return fileUploads.get(0);
        }
    }

    @Override
    public int insertAndGetId(LocalFile fileUpload) {
        return 0;
    }

    @Override
    public List<LocalFile> list() {
        LocalFileExample example = new LocalFileExample();
        return localFileMapper.selectByExample(example);
    }

}
