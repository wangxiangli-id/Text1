package sqlserver;


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
				//产生0到size-1的随机值
				int index = r.nextInt(size);
				//在base字符串中获取下标为index的字符
				char c = base.charAt(index);
				//将c放入到StringBuffer中去
				sb.append(c);
			}
			return sb.toString();
		}
	}



















