package org.community.api.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frodo on 2016/11/7.
 */
@Controller
@RequestMapping("fileSystem")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        String path = getUploadFileRoot() + file.getOriginalFilename();

        File newFile = new File(path);
        if (newFile.isFile() && newFile.exists()) {
            newFile.delete();
        }
        file.transferTo(newFile);

        return "/api/fileSystem/file/" + file.getOriginalFilename();
    }

    @ResponseBody
    @RequestMapping("list")
    public List<String> files() throws IOException {
        List<String> filePathArray = new ArrayList<String>();
        File dir = new File(getUploadFileRoot());
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                filePathArray.add(file.getName());
            }
        }

        return filePathArray;
    }

    @ResponseBody
    @RequestMapping("file/{fileName:.+}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable(value = "fileName") String fileName) throws IOException {
        final String path = getUploadFileRoot() + fileName;
        logger.info("download >> [ path: " + path + " ]");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path)), headers, HttpStatus.CREATED);
    }

    private String getUploadFileRoot() {
        return request.getSession().getServletContext().getRealPath("/") + "/files/";
    }
}
