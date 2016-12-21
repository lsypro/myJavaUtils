package lsy.test.common;

import java.io.File;

public class FileUtils {
	/***
	 * 此方法应用场景在某个文件夹下有多个文件夹，在这些文件夹下需要创建相同结构的文件夹
	 * @param appointFloder  指定路径（某个文件夹）eg : D:\\eg\\appointFloder
	 * @param needToCreate  需要创建的文件夹 eg : \\needToCreate
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
