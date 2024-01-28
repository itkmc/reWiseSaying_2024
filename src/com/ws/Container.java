package com.ws;
import java.util.Scanner;

public class Container {
	private static Scanner sc;

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() { // init 메소드를 실행하면 안쪽이 실행된다.
		sc = new Scanner(System.in); // sc 변수에 새롭게 만든 Scanner 메소드를 담는다. 
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() { // close 메소드를 실행하면 안쪽이 실행된다.
		sc.close(); // 스캐너 사용이 끝난다.
	}
	
	public static Scanner getScanner() { // Scanner를 담을 수 있는 getScanner 메소드를 실행하면 외부 클래스에서 사용하게 만든다.
		return sc; // Scanner를 담은 변수 sc를 리턴해준다.
	}
}