package org.community.api.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by frodoking on 2014/12/23.
 */
public class GZipUtils {
    private static final String encoding = "utf-8";

    public static String decompressToString(byte[] b) throws IOException {
        return decompressToString(b, encoding);
    }

    public static byte[] compressToByte(String data) throws IOException {
        return compressToByte(data, encoding);
    }

    public static byte[] compressToByte(String str, String encoding) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes(encoding));
        gzip.close();
        return out.toByteArray();
    }

    public static String decompressToString(byte[] b, String encoding) throws IOException {
        if (b == null || b.length == 0) {
            return null;
        }
        GZIPInputStream gzip = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(b);
            gzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                }
            }
        }
    }

    // 压缩
    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString("ISO-8859-1");
    }

    // 解压缩
    public static String decompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        GZIPInputStream gzip = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(str
                    .getBytes("ISO-8859-1"));
            gzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString();// toString()使用平台默认编码，也可以显式的指定如toString("GBK")
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                }
            }

        }
    }
}

