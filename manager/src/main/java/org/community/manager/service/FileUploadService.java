package org.community.manager.service;

import org.community.core.model.pojo.LocalFile;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by frodo on 2014/12/30.
 */
public interface FileUploadService {
    LocalFile getByName(String name);

    int save(LocalFile fileUpload) throws DataAccessException;

    int update(LocalFile fileUpload) throws DataAccessException;

    LocalFile matchingMD5(String md5);

    List<LocalFile> list();
}
