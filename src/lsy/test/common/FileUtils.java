package lsy.test.common;

import java.io.File;

public class FileUtils {
	/***
	 * �˷���Ӧ�ó�����ĳ���ļ������ж���ļ��У�����Щ�ļ�������Ҫ������ͬ�ṹ���ļ���
	 * @param appointFloder  ָ��·����ĳ���ļ��У�eg : D:\\eg\\appointFloder
	 * @param needToCreate  ��Ҫ�������ļ��� eg : \\needToCreate
	 */
	public void mkDirInAppointFloder(String appointFloder , String needToCreate){
		File file = new File(appointFloder);
		String [] fileName = file.list();
		for(String fileNames : fileName){
			File file2 = new File(appointFloder+fileNames+needToCreate);
			file2.mkdirs();
		}
	}
}
