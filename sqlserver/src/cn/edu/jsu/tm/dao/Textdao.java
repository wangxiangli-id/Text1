package cn.edu.jsu.tm.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Textdao {
	public static void In(String str) throws IOException {
		File file =new File("F:"+File.separator+"Text"+File.separator+"1.txt");
		FileOutputStream fo =new FileOutputStream(file,true);
		SimpleDateFormat ds= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ans=str+"ÓÚ"+ds.format(new Date())+"³É¹¦µÇÂ½\r\n";
		fo.write(ans.getBytes());
		fo.close();
	}
}
