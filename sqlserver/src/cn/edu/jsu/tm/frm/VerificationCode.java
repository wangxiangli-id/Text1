package cn.edu.jsu.tm.frm;


	import java.util.Random;
public class VerificationCode {
		public static void main(String[] args) {
			new VerificationCode().getCheckCode();
		}
		public String getCheckCode() {
			String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			int size = base.length();
			Random r = new Random();
			StringBuffer sb = new StringBuffer();
			for(int i=1;i<=5;i++){
				//����0��size-1�����ֵ
				int index = r.nextInt(size);
				//��base�ַ����л�ȡ�±�Ϊindex���ַ�
				char c = base.charAt(index);
				//��c���뵽StringBuffer��ȥ
				sb.append(c);
			}
			return sb.toString();
		}
	}



















