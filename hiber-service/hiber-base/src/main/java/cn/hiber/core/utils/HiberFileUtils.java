package cn.hiber.core.utils;

import java.io.*;

/**
 * @author hiber
 */
public class HiberFileUtils {

	public static String addPath(String... paths) {
		StringBuffer ret = new StringBuffer();
		if(paths != null && paths.length>=1) {
			for(int i=0,len=paths.length; i<len; i++) {
				ret.append(paths[i]).append(i==len-1?"":File.separator);
			}
		}
		return ret.toString();
 	}

	public static void close(Closeable... cs) {
		if(cs != null && cs.length > 0) {
			for(Closeable c:cs) {
				close(c);
			}
		}
	}

	public static void close(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException e) {
				System.err.println(e);
			}
			c = null;
		}
	}

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{
		FileOutputStream out = null;
		try {
			File targetFile = new File(filePath);
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			out = new FileOutputStream(filePath+fileName);
			out.write(file);
			out.flush();
		} finally {
			close(out);
		}
	}
}
