package org.community.manager.service.impl;

import org.community.core.dao.FileUploadDao;
import org.community.core.model.pojo.LocalFile;
import org.community.manager.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by frodo on 2014/12/30.
 */
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Resource
    private FileUploadDao fileUploadDao;

    @Override
    public LocalFile getByName(String name) {
        return fileUploadDao.getByName(name);
    }

    @Override
    public int save(LocalFile fileUpload) throws DataAccessException {
        return fileUploadDao.create(fileUpload);
    }

    @Override
    public int update(LocalFile fileUpload) throws DataAccessException {
        return fileUploadDao.update(fileUpload);
    }

    @Override
    public LocalFile matchingMD5(String md5) {
        LocalFile fileUpload;
        try {
            fileUpload = fileUploadDao.getByMD5(md5);
        } catch (IncorrectResultSizeDataAccessException e) {
            fileUpload = null;
            logger.info("无匹配文件,md5:{}", md5);
        }
        return fileUpload;
    }

    @Override
    public List<LocalFile> list() {
        return fileUploadDao.list();
    }

}
