package com.ws;

public class Main { // 메인 클래스
	public static void main(String[] args) { // 메인 메소드(프로그램을  시작하는 메소드)
		
		Container.init(); // 컨테이너에 있는 공용자원들을 가지고 와사 사용을 한다.
		
		new App().run(); // 앱에 있는 런이라는 메소드를 실행을 한다

		Container.close(); // 앱에 있는 런 메소드가 끝나면 컨테이니에 있는 공용자원들 사용을 끝낸다.
	}
}