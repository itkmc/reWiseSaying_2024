package com.ws;
import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq { // Rq 클래스
	private String actionCode; // String 타입의 actionCode를 Rq클래스에서만 쓸 수 있게 해 놓았다.
	private Map<String, String> params; // String,String을 넣을 수 있는 Map형식의 params를 Rq클래스에서만 쓸 수 있게 해 놓았다.

	public Rq(String cmd) { // cmd를 매개변수로 받고 Rq 메소드를 실행한다. 
		String[] cmdBits = cmd.split("\\?", 2);
		// String 타입의 배열을 cmdBits 변수에 매개변수로 가져온 cmd를 ?로 기준으로 2개 쪼개준 뒤에 담는다.
		actionCode = cmdBits[0];
		// 쪼개서 담은 cmdBits의 인덱스 번호 0번을 actionCode에 담는다.
		params = new HashMap<>();
		// Map 형식인 params에 HashMap 생성해서 담아준다.
		if (cmdBits.length == 1) {
			return;
		}
		// 만약 cmdBits의 길이가 1이랑 같으면 리턴을 한다.
		String[] paramBits = cmdBits[1].split("&");
		// String 타입의 배열에 paramBits 변수에다가 cmdBits의 인덱스 번호 1번을 &를 기준으로 쪼개서 담아준다.
		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);
			// 배열에 저장된 값의 타입 String 반복문에서 사용할 변수명 paramStr : 배열객체 이름인 paramBits
			// 문자열과 연결될 변수 paramStrBits에다가 반복한 변수 paramStr 
			if (paramStrBits.length == 1) {
				continue;
			}
			// 만약 paramStrBits의 길이가 1이랑 같으면 반복문의 현재 단계를 중단을 한다.
			String key = paramStrBits[0]; // String 타입의 변수 key에다가 paramStrBits의 인덱스 번호 0번을 담아준다.
			String value = paramStrBits[1]; // String 타입의 변수 key에다가 paramStrBits의 인덱스 번호 1번을 담아준다.
			params.put(key, value); // Map형식의 params에 위에서 담은 key, value를 넣어준다.
		}

	}

	public String getActionCode() {
		return actionCode;
	}
	// 위에서 ActionCode는 private이기 때문에 다른 클래스에서 쓸려고 하면은 getter를 이용해서 만들어주고 actionCode에 담겨있는 값을 리턴해준다. 
	public String getParam(String name) {
		return params.get(name);
	}
	// 위에서 params는 private이기 때문에 다른 클래스에서 쓸려고 하면은 getter를 이용해서 만들어주고 params에 있는 name를 get해서 리턴해준다.
	public int getIntParam(String name, int defaultValue) { 
		// 정수만 담을 수 있는 getIntParam를 실행하면 문자만 담을 수 있는 name과 정수만 담을 수 있는 defaultValue를 배개변수로 받는다.
		try {
			return Integer.parseInt(getParam(name));
			// 정수화를 해서 리턴하는 과정에 에러가 생기면은
		} catch (NumberFormatException e) {
			// 숫자타입으로 변경할 수 없는 문자를 치환시키려고 하면 발생하는 에러로 잡고 에러 내용을 보여준다.
		}
		return defaultValue; // defaultValue를 리턴해준다.
	}

}