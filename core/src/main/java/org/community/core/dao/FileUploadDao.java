package org.community.core.dao;

import org.community.core.model.pojo.FileUpload;

/**
 * Created by frodo on 2015/4/8.
 */
public interface FileUploadDao extends BaseDao<FileUpload> {
    FileUpload getByMD5(String md5);
    FileUpload getByName(String name);
    int insertAndGetId(FileUpload fileUpload);
}
