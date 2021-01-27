package thread0127;

import java.awt.Toolkit;

public class Thread2 {

	public static void main(String[] args) throws InterruptedException {
		//InterruptedException 예외처리
		BeepThread beep = new BeepThread();
		//작업쓰레드 시작
		beep.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 쓰레드 동작: " +i);
			Thread.sleep(500);
		}

	}

}
//쓰레드를 사용하기 위해서는 run()를
//반드시 오버라이딩 필요
//부모 클래스인 Thread 상속.
class BeepThread extends Thread {

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