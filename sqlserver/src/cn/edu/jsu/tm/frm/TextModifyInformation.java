package cn.edu.jsu.tm.frm;

	import junit.framework.TestCase;
	import cn.edu.jsu.tm.frm.ModifyInformation;
	public class TextModifyInformation extends TestCase{
		 public  void testfind() {
			 String sql="select * from Ordersheet";
			 boolean bl=ModifyInformation.find(sql);
			 assertTrue(bl==true);
		 }
		 public static void main(String[] args) {
			 TextModifyInformation tm=new TextModifyInformation();
			 tm.testfind();
		 }

	}

