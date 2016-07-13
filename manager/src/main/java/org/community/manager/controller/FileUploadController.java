package org.community.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.community.core.model.pojo.LocalFile;
import org.community.manager.service.FileUploadService;
import org.community.manager.utils.DateUtil;
import org.community.manager.utils.FileUtils;
import org.community.manager.utils.ReturnMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by frodo on 2014/12/24.
 */
@Controller
@RequestMapping("file")
public class FileUploadController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private HttpServletRequest request;

    @Resource(name = "fileUploadService")
    private FileUploadService fileUploadService;

    private LocalFile fileUpload;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        return "upload";
    }

    /**
     * 单文件上传
     *
     * @param file
     *
     * @return
     */
    @RequestMapping(value = "uploadSingleFile", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            file.transferTo(new File(getUploadFileRoot() + file.getOriginalFilename()));
            return ReturnMessageUtil.createOKMsg("file upload success!");
        } catch (IOException e) {
            e.printStackTrace();
            return ReturnMessageUtil.createErrorMsg("file upload failure!");
        }
    }

    /**
     * 多文件上传
     *
     * @param files
     *
     * @return
     */
    @RequestMapping(value = "uploadMultiFile", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String filesUpload(@RequestParam("files") MultipartFile[] files) {
        try {
            if (files != null && files.length > 0) {
                for (MultipartFile file : files) {
                    file.transferTo(new File(getUploadFileRoot() + file.getOriginalFilename()));
                }
            }
            return ReturnMessageUtil.createOKMsg("files upload success!");
        } catch (IOException e) {
            e.printStackTrace();
            return ReturnMessageUtil.createErrorMsg("files upload failure!");
        }
    }

    @RequestMapping(value = "upload", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("name") String name,
                         @RequestParam("md5") String md5) {
        logger.info("file:{},md5:{}", file, md5);
        long startTime = System.currentTimeMillis();
        String returnMsg;
        try {
            LocalFile fu = saveFile(name, file);
            long endTime = System.currentTimeMillis();
            logger.info("文件上传success! -costTime:{} ms,fileSize:{} byte", (endTime - startTime), file.getSize());
            returnMsg = ReturnMessageUtil.createOKMsg("文件上传成功!");
            returnMsg = ReturnMessageUtil.createOKMsg(fu);
        } catch (IOException e) {
            logger.error("文件上传失败-file:{},e:{}", file.getOriginalFilename(), e);
            returnMsg = ReturnMessageUtil.createErrorMsg("文件上传失败！");
        } catch (DataAccessException e) {
            logger.error("save fileupload failed! - fileName:{}", file.getOriginalFilename(), e);
            returnMsg = ReturnMessageUtil.createErrorMsg("保存文件信息失败！");
        }
        return returnMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/matchMd5")
    public String checkMD5(@RequestParam("md5") String md5) {
        LocalFile fileUpload = fileUploadService.matchingMD5(md5);
        return ReturnMessageUtil.createOKMsg(fileUpload != null);
    }

    private String getUploadFileRoot() {
        return request.getSession().getServletContext().getRealPath("/") + "/upload/";
    }

    /**
     * 保存文件
     *
     * @param file
     *
     * @return
     */
    private LocalFile saveFile(String name, final MultipartFile file) throws IOException {
        String path = getUploadFileRoot() + DateUtil.date2String(new Date(), "yyyyMMdd");
        String filePath = path + File.separator + file.getOriginalFilename();
        if (name != null && !"".equals(name)) {
            filePath = path + File.separator + name;
        }
        File pathFile = new File(path);
        final File newFile = new File(filePath);
        if (!pathFile.exists()) {
            pathFile.mkdir();
        }

        if (newFile.exists()) {
            newFile.delete();
        }

        if (!file.isEmpty()) {
            logger.info("upload file to " + filePath);
            FileUtils.Progress progress = new FileUtils.Progress() {
                private long currentBytesWritten;

                @Override
                public void onStart() {
                    logger.info("start to transfer file");
                }

                @Override
                public void onProgress(long bytesWritten, long totalSize) {
                    this.currentBytesWritten = bytesWritten;
                    logger.info(
                            "upload file onProgress  bytesWritten:" + bytesWritten + " , totalSize:" + file.getSize());
                }

                @Override
                public void onFinish() {
                    LocalFile record = fileUploadService.getByName(newFile.getName());
                    if (record != null) {
                        updateRecord(fileUpload, currentBytesWritten);
                    } else {
                        fileUpload = writeRecord(newFile, currentBytesWritten, file.getSize());
                    }
                    logger.info("transfer file finished");
                }
            };
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), newFile, progress);
                return fileUpload;
            } catch (IOException e) { //为了发出finish，所以此处捕获
                progress.onFinish();
                throw new IOException(e);
            }
        }
        return null;
    }

    /**
     * 写文件记录到数据库
     *
     * @param saveFile
     * @param fileSize
     * @param totalFileSize
     */
    private LocalFile writeRecord(File saveFile, long fileSize, long totalFileSize) {
        logger.info("start to insert record current operation to mysql!");
        LocalFile fileUpload = new LocalFile();
        fileUpload.setMd5(FileUtils.getMd5ByFile(saveFile));
        fileUpload.setFileName(saveFile.getName());
        fileUpload.setPath(saveFile.getAbsolutePath());
        fileUpload.setUpdateTime(new Date());
        fileUpload.setCreateTime(new Date());
        fileUpload.setFileSize(fileSize);
        fileUpload.setFileTotalSize(totalFileSize);
        fileUpload.setStatus(fileSize != totalFileSize ? 0 : 1);
        fileUpload.setDescription("上传文件" + saveFile.getAbsolutePath());
        fileUploadService.save(fileUpload);
        logger.info("finish insert record current operation to mysql!");
        return fileUpload;
    }

    /**
     * 更新记录
     *
     * @param recordFile
     * @param fileSize
     */
    private void updateRecord(LocalFile recordFile, long fileSize) {
        logger.info("start to update record current operation to mysql!");
        recordFile.setMd5(FileUtils.getMd5ByFile(new File(recordFile.getPath())));
        recordFile.setUpdateTime(new Date());
        recordFile.setFileSize(fileSize);
        recordFile.setStatus(fileSize != recordFile.getFileTotalSize() ? 0 : 1);
        recordFile.setDescription(new Date() + "更新文件");
        fileUploadService.update(recordFile);
        logger.info("finish update record current operation to mysql!");
    }
}
