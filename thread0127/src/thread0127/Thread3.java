package thread0127;

import java.awt.Toolkit;

public class Thread3 {

	public static void main(String[] args) throws InterruptedException {
//		Runnable task = new BeepTask();
		BeepTask task = new BeepTask();
		Thread th = new Thread(task);
		th.start();
					
				for (int i = 0; i < 5; i++) {
					System.out.println("메인 쓰레드 동작: " +i);
					Thread.sleep(500);
				}

	}

}
//Runnable 인터페이스를 사용
//Interface는 반드시 오버라이딩을 해줘야한다
class BeepTask implements Runnable {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			System.out.println("작업쓰레드 :" +i); //소리나고
			try {
				Thread.sleep(2000);//2초대기
			} catch (InterruptedException e) {
				e.printStackTrace();
				//try/catch 예외처리
			}
		}
		System.out.println("작업 쓰레드 종료");
	}
	
}

