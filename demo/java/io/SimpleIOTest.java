package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符写入
 * @author luliuyu
 *
 */
public class SimpleIOTest {

	public static void main(String[] args) throws IOException {

		File file = new File("c:/hello3.txt"); 
		OutputStream os = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)); //一层一层装饰
		
		
		InputStreamReader isr = new InputStreamReader(System.in);//控制台输入流，用其他也行
		
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		while((line = br.readLine()) != null  ){
			
			bw.write(line);  //写入
			break;
			//os.write(line.getBytes());
		}
		
		br.close();
		bw.close();
		
	}

}
