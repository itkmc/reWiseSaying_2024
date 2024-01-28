package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App { // App 클래스

	private byte system_status = 1; // byte만 담을 수 있는 변수 system_status에 1를 담는다.

	public App() { // App 메소드를 실행한다.

	}

	public void run() {
		System.out.println("== 명언 앱 실행 =="); // 명언 앱 실행 이라는 문장이 콘솔에 보여진다.

		SystemController systemController = new SystemController();
		// SystemController를 담을 수 있는 변수 systemController에 새로운 SystemController메소드를 생성해서 담는다.
		WiseSayingController wiseSayingController = new WiseSayingController();
		// WiseSayingController를 담을 수 있는 변수 wiseSayingController에 새로운 WiseSayingController메소드를 생성해서 담는다.
		while (system_status == 1) {
			System.out.print("명령어 ) "); // 명령어 )이 콘솔에 보여진다.
			String cmd = Container.getScanner().nextLine().trim();
			// 컨테이너에 있는 스캐너를 가져와 콘솔에서 입력할 수 있게 하고 입력한 명령어의 좌우 공백을 제거를 해서
			// 스트링 타입의 cmd 변수에 담겨진다.
			Rq rq = new Rq(cmd);
			// Rq 타입의 rq라는 변수에 Rq 클래스에 있는 Rq메소드에 인자로 cmd를 주고 리턴한 값을 담아준다 

			switch (rq.getActionCode()) { //Rq에서 쪼개서 담은 ActionCode를 가져와 밑에 있는 case별로 비교를 한다. 
			case "종료": // ActionCode가 종료라는 단어이면
				systemController.exit();// systemController에 있는 exit 메소드가 실행이 된다.
				system_status = 0; // system_status 변수에 0를 담아준다.
				break; // 현재 반복문을 탈출한다. 
			case "등록": // ActionCode가 등록이라는 단어이면
				wiseSayingController.write(); // wiseSayingController에 있는 write 메소드가 실행이 된다
				break; // 현재 반복문을 탈출한다. 
			case "목록": //  ActionCode가 목록이라는 단어이면
				wiseSayingController.list(); // wiseSayingController에 있는 list 메소드가 실행이 된다
				break; // 현재 반복문을 탈출한다. 
			case "삭제": //  ActionCode가 삭제이라는 단어이면
				wiseSayingController.remove(rq); // wiseSayingController에 있는 remove 메소드가 실행이 된다
				break; // 현재 반복문을 탈출한다. 
			case "수정": //  ActionCode가 수정이라는 단어이면
				wiseSayingController.modify(rq); // wiseSayingController에 있는 modify 메소드가 실행이 된다
				break; // 현재 반복문을 탈출한다. 
			default: // 위에 case에 해당하지 않는 다른 명령어를 입력하면 
				System.out.println("존재하지 않는 명령어입니다"); // 존재하지 않는 명령어입니다를 콘솔에 보여주게 된다.
				break; // 현재 반복문을 탈출한다. 
			}
		}

	}
}