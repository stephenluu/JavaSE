package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class UrlIO {

	/**
	 * 从url获取文件
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			String fileUrl = "http://www.77music.com/yuepuku.php?ypop=all&sortby=createtime";
			
			File file = new File("c:/foo.html");
			OutputStream os = new FileOutputStream(file);

			java.net.URL url = new java.net.URL(fileUrl);
			HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.connect();
			java.io.InputStream  inputStream = connection.getInputStream();

			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) > 0) {
				os.write(b, 0, i);
			}
			System.out.println(file);

			inputStream.close();
			os.flush();
			os.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
