package org.community.core.dao;

import org.community.core.model.pojo.LocalFile;

/**
 * Created by frodo on 2015/4/8.
 */
public interface FileUploadDao extends BaseDao<LocalFile> {
    LocalFile getByMD5(String md5);
    LocalFile getByName(String name);
    int insertAndGetId(LocalFile fileUpload);
}
