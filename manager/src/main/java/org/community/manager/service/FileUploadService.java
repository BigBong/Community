package org.community.manager.service;

import org.community.core.model.pojo.FileUpload;
import org.springframework.dao.DataAccessException;

/**
 * Created by frodo on 2014/12/30.
 */
public interface FileUploadService {
    FileUpload getByName(String name);

    int save(FileUpload fileUpload) throws DataAccessException;

    int update(FileUpload fileUpload) throws DataAccessException;

    FileUpload matchingMD5(String md5);
}
