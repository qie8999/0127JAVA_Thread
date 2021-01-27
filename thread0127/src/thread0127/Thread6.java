package thread0127;

import java.io.File;
import java.io.IOException;

public class Thread6 {

	public static void main(String[] args) {
		FileDir fileDir = new FileDir();
		fileDir.start();

	}

}
class FileDir extends Thread {
	public void run() {
		//오버라이딩
		subDirList("C:\\Program Files");
	}
	public void subDirList(String source) {
		File dir = new File(source);
		File[] fileList =dir.listFiles();
		//파일을 배열로 저장
		
		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if(file.isFile()) {
				String name = file.getName();
				System.out.println("\t파일: "+name);
				
			}else if(file.isDirectory()) {
				
				try {
					String name = file.getCanonicalPath().toString();
					System.out.println("폴더: "+name);
					subDirList(file.getCanonicalPath().toString());//절대경로 자기자신 호출
					Thread.sleep(10);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					System.err.println("시스템 폴더 제한");
				}
			}
		}
	}
}
