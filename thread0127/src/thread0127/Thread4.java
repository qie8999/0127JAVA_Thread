package thread0127;

public class Thread4 {

	public static void main(String[] args) {
		Thread th = new MovieThread();
		th.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 쓰레드 동작: " +i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("메인쓰레드 종료");
		th.interrupt();

	}

}
class MovieThread extends Thread {
	public void run() { //안에 원하는 기능 집어넣기
		while (true) {
			//무한루프
			System.err.println("동영상 재생");
//			if(isInterrupted()) {
//				System.out.println("인터럽트 신호 받음");
//				break;
//			}
			try {
				Thread.sleep(500);//try/catch 1순위 > while 2순위로 읽음
			} catch (InterruptedException e) {//예외처리
				System.out.println("인터럽트 신호 받음2");
				e.printStackTrace();//trace는 디버깅 용
				break;
			}
			
		}
//		System.out.println("작업 쓰레드 종료"); 무한루프가 끝나지 않으므로 실행 안되는 코드
	}
}
