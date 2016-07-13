package org.community.api.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frodo on 2016/5/26.
 */
@Controller
@RequestMapping("dynamicUpdate")
public class DynamicUpdateController {
    private static final Logger logger = LoggerFactory.getLogger(DynamicUpdateController.class);

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "mcf/list")
    @ResponseBody
    public List<ResultBean> list() {
        return dataList();
    }

    @RequestMapping(value = "modules")
    @ResponseBody
    public List<Module> modules() {
        return modules0();
    }

    @RequestMapping(value = "mcf/upload", method = RequestMethod.POST)
    @ResponseBody
    public List<ResultBean> uploadFile(@RequestParam("username") String username,
                                       @RequestParam("terminalType") String terminalType,
                                       @RequestParam("mcfVersion") int mcfVersion,
                                       @RequestParam("engineMinVersion") int engineMinVersion,
                                       @RequestParam("engineMaxVersion") int engineMaxVersion,
                                       @RequestParam("file") CommonsMultipartFile file) throws IOException {

        String path = getUploadFileRoot() + file.getOriginalFilename();

        logger.info("obtainMcfConfig >> [username:" + username
                + ", terminalType:" + terminalType
                + ", mcfVersion:" + mcfVersion
                + ", engineMinVersion:" + engineMinVersion
                + ", file:" + file.getOriginalFilename()
                + ", engineMaxVersion:" + engineMaxVersion + " ]");

        File newFile = new File(path);
        file.transferTo(newFile);

        List<ResultBean> list = new ArrayList<ResultBean>();

        int version = engineMinVersion;
        while (version < engineMaxVersion) {
            ResultBean resultBean = new ResultBean(version, mcfVersion, terminalType, path);
            list.add(resultBean);
            version++;
        }

        return list;
    }

    @RequestMapping(value = "mcf/check")
    @ResponseBody
    public ResultFileInfoBean check(@RequestParam("engineVersion") int engineVersion,
                                    @RequestParam("terminalType") String terminalType,
                                    @RequestParam("curMcfVersion") int curMcfVersion) {
        logger.info("downloadFile >> [ engineVersion" + engineVersion
                + ", terminalType:" + terminalType
                + ", curMcfVersion:" + curMcfVersion + " ]");

        List<ResultBean> list = dataList();
        ResultBean resultBean = null;
        for (ResultBean bean : list) {
            if (terminalType.toLowerCase().equals(bean.terminalType.toLowerCase())) {
                if (engineVersion == bean.engineVersion && curMcfVersion <= bean.mcfVersion) {
                    if (resultBean == null) {
                        resultBean = bean;
                    } else {
                        if (resultBean.mcfVersion < bean.mcfVersion) {
                            resultBean = bean;
                        }
                    }
                }
            }
        }
        if (resultBean != null) {
            return new ResultFileInfoBean(resultBean.mcfVersion, resultBean.loadAddress, "94EE927D2F8784DE01784FA1478FADD1");
        } else {
            return new ResultFileInfoBean(curMcfVersion, "", "");
        }
    }

    @ResponseBody
    @RequestMapping(value = "stream/file")
    public ResponseEntity<byte[]> downloadFileStream(@RequestParam(value = "fileName") String fileName) throws IOException {
        final String path = getUploadFileRoot() + fileName;
        logger.info("download >> [ path: " + path + " ]");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", path);

        return new ResponseEntity(FileUtils.readFileToByteArray(new File(path)), headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "file")
    @ResponseBody
    public FileSystemResource downloadFile(@RequestParam("fileName") String fileName) {
        final String path = getUploadFileRoot() + fileName;
        logger.info("getFile >> [ path: " + path + " ]");
        return new FileSystemResource(path);
    }

    private String getUploadFileRoot() {
        return request.getSession().getServletContext().getRealPath("/") + "/files/";
    }


    public static List<Module> modules0() {
        List<Module> list = new ArrayList<Module>();
        list.add(createModule(1));
        list.add(createModule(2));
        list.add(createModule(3));
        list.add(createModule(4));
        return list;
    }

    private static Module createModule(int index) {
        Module module = new Module();
        module.setModuleId(1 << index);
        module.setModuleName("TestModule");
        module.setModuleVersion((1 << index) / 3);
        module.setChannel("kuang");
        final List<String> fileList = new ArrayList<String>();
        fileList.add("main.js");
        module.setFileList(fileList);
        module.setSupport(new Module.Support(index, index << 2, index << 4, index << 5));
        module.setPackageUrl("/api/dynamicUpdate/stream/file?fileName=main.lua.zip");
        module.setCheckSum(3 << index);
        module.setMainFunction("main.js");
        return module;
    }

    private static List<ResultBean> dataList() {
        List<ResultBean> list = new ArrayList<ResultBean>();
        list.add(createResultBean(3, "Android"));
        list.add(createResultBean(2, "Android"));
        list.add(createResultBean(4, "IOS"));
        list.add(createResultBean(5, "Android"));
        list.add(createResultBean(7, "IOS"));
        return list;
    }

    private static ResultBean createResultBean(int index, String device) {
        return new ResultBean(1 << index, 2 << index / 3, device, "/api/dynamicUpdate/stream/file?fileName=main.lua.zip");
    }

    private static class Module {
        private int moduleId;
        private String moduleName;
        private int moduleVersion;
        private String channel;
        private String packageUrl;
        private int checkSum;
        private String mainFunction;
        private Support support;
        private List<String> fileList;

        public int getModuleId() {
            return moduleId;
        }

        public void setModuleId(int moduleId) {
            this.moduleId = moduleId;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public int getModuleVersion() {
            return moduleVersion;
        }

        public void setModuleVersion(int moduleVersion) {
            this.moduleVersion = moduleVersion;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getPackageUrl() {
            return packageUrl;
        }

        public void setPackageUrl(String packageUrl) {
            this.packageUrl = packageUrl;
        }

        public int getCheckSum() {
            return checkSum;
        }

        public void setCheckSum(int checkSum) {
            this.checkSum = checkSum;
        }

        public String getMainFunction() {
            return mainFunction;
        }

        public void setMainFunction(String mainFunction) {
            this.mainFunction = mainFunction;
        }

        public Support getSupport() {
            return support;
        }

        public void setSupport(Support support) {
            this.support = support;
        }

        public List<String> getFileList() {
            return fileList;
        }

        public void setFileList(List<String> fileList) {
            this.fileList = fileList;
        }

        private static class Support {
            private int engineMinVersion;
            private int engineMaxVersion;
            private int osMinVersion;
            private int osMaxVersion;

            protected Support(int engineMinVersion, int engineMaxVersion, int osMinVersion, int osMaxVersion) {
                this.engineMinVersion = engineMinVersion;
                this.engineMaxVersion = engineMaxVersion;
                this.osMinVersion = osMinVersion;
                this.osMaxVersion = osMaxVersion;
            }

            public int getEngineMinVersion() {
                return engineMinVersion;
            }

            public void setEngineMinVersion(int engineMinVersion) {
                this.engineMinVersion = engineMinVersion;
            }

            public int getEngineMaxVersion() {
                return engineMaxVersion;
            }

            public void setEngineMaxVersion(int engineMaxVersion) {
                this.engineMaxVersion = engineMaxVersion;
            }

            public int getOsMinVersion() {
                return osMinVersion;
            }

            public void setOsMinVersion(int osMinVersion) {
                this.osMinVersion = osMinVersion;
            }

            public int getOsMaxVersion() {
                return osMaxVersion;
            }

            public void setOsMaxVersion(int osMaxVersion) {
                this.osMaxVersion = osMaxVersion;
            }
        }
    }


    private static class ResultBean implements Serializable {
        private int engineVersion;
        private int mcfVersion;
        private String terminalType;
        private String loadAddress;

        private ResultBean(int engineVersion, int mcfVersion, String terminalType, String loadAddress) {
            this.engineVersion = engineVersion;
            this.mcfVersion = mcfVersion;
            this.terminalType = terminalType;
            this.loadAddress = loadAddress;
        }


        public int getEngineVersion() {
            return engineVersion;
        }

        public void setEngineVersion(int engineVersion) {
            this.engineVersion = engineVersion;
        }

        public int getMcfVersion() {
            return mcfVersion;
        }

        public void setMcfVersion(int mcfVersion) {
            this.mcfVersion = mcfVersion;
        }

        public String getLoadAddress() {
            return loadAddress;
        }

        public void setLoadAddress(String loadAddress) {
            this.loadAddress = loadAddress;
        }

        public String getTerminalType() {
            return terminalType;
        }

        public void setTerminalType(String terminalType) {
            this.terminalType = terminalType;
        }
    }

    private static class ResultFileInfoBean implements Serializable {
        private int mcfVersion;
        private String loadAddress;
        private String checkNumber;

        private ResultFileInfoBean(int mcfVersion, String loadAddress, String checkNumber) {
            this.mcfVersion = mcfVersion;
            this.loadAddress = loadAddress;
            this.checkNumber = checkNumber;
        }

        public int getMcfVersion() {
            return mcfVersion;
        }

        public void setMcfVersion(int mcfVersion) {
            this.mcfVersion = mcfVersion;
        }

        public String getLoadAddress() {
            return loadAddress;
        }

        public void setLoadAddress(String loadAddress) {
            this.loadAddress = loadAddress;
        }

        public String getCheckNumber() {
            return checkNumber;
        }

        public void setCheckNumber(String checkNumber) {
            this.checkNumber = checkNumber;
        }
    }
}
