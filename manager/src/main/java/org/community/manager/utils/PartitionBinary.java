package org.community.manager.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 二进制文件分割
 * Created by frodo on 2015/4/9.
 */
public class PartitionBinary {
    /**
     * 单个文件设置的字节数
     */
    public static int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public void copyInputStreamToFile(FileInputStream in, String newFile) throws IOException {
        DataInputStream dis = null;
        FileOutputStream fos = null;
        DataOutputStream out = null;
        try {
            fos = new FileOutputStream(newFile);
            out = new DataOutputStream(fos);
            dis = new DataInputStream(in);
            byte[] b = new byte[DEFAULT_BUFFER_SIZE];
            while ((dis.read(b)) != -1) {
                fos.write(b);
            }
            out.flush();
            fos.flush();
            dis.close();
        } catch (FileNotFoundException ex) {
            throw ex;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
