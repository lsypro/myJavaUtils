package lsy.test.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/***
 * 用于ping网络状态的公共方法类
 * @author liusy
 *
 */
public class PingServerUtils {
	
	/***
	 * 只有成功与否的ping服务器的方法
	 * @param targetIp 目标服务器的IP 
	 * @return status  true,成功;false,失败
	 */
	public boolean isPing(String targetIp) {
	   int timeOut = 1500; // 超时应该在3钞以上
		boolean status = false;
		if (targetIp != null) {
			try {
				status = InetAddress.getByName(targetIp).isReachable(timeOut);
			} catch (UnknownHostException e) {
			} catch (IOException e) {
			}
		}
		return status;
	}
	/***
	 * 有返回字符串的ping服务器方法
	 * @param targetIp 目标机器的ip
	 * @return result 返回的字符串结果
	 */
	public String isCmdPing(String targetIp) {
		String result = null;//返回结果
		Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行对象
		Process process = null; // 声明处理类对象
		String line = null; // 返回行信息
		InputStream is = null; // 输入流
		InputStreamReader isr = null; // 字节流
		BufferedReader br = null;
		String ip = targetIp;
		StringBuffer sb = new StringBuffer(); // 返回结果
		try {
			process = runtime.exec("ping " + ip); // PING
			is = process.getInputStream(); // 实例化输入流
			isr = new InputStreamReader(is, "GBK");// 把输入流转换成字节流
			br = new BufferedReader(isr);// 从字节中读取文本
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			result = sb.toString();
			is.close();
			isr.close();
			br.close();
		} catch (IOException e) {
			runtime.exit(1);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		PingServerUtils netStatusUtils = new PingServerUtils();
		String qaq = netStatusUtils.isCmdPing("www.baidu.com");
	}
}
