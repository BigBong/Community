package org.community.manager.test;

import java.util.Date;

import javax.annotation.Resource;

import org.community.core.model.pojo.LocalFile;
import org.community.manager.service.FileUploadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by frodo on 2015/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class FileUploadServiceTest {
    @Resource(name = "fileUploadService")
    private FileUploadService fileUploadService;

    @Before
    public void setup() {
    }

    @Test
    public void testInsert() throws Exception {
        LocalFile fileUpload = new LocalFile();
        fileUpload.setMd5("Md5Md5Md5Md5Md5");
        fileUpload.setFileName("FileNameForTest");
        fileUpload.setPath("c://test.file");
        fileUpload.setUpdateTime(new Date());
        fileUpload.setCreateTime(new Date());
        fileUpload.setFileSize((long) 1024000);
        fileUpload.setFileTotalSize((long) 2048000);
        fileUpload.setStatus(1);
        fileUpload.setDescription("this is for test");
        final int result = fileUploadService.save(fileUpload);
        Assert.assertEquals("exception", result, 1);
    }
}
