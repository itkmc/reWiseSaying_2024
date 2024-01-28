package com.ws.wiseSaying.controller;

import java.util.ArrayList;
import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingController {

	private int lastId; // int 타입의 lastId를 WiseSayingController에서만 쓰게 해주었다.
	private List<WiseSaying> wiseSayings; // List형식의  WiseSaying 타입의 wiseSayings를 WiseSayingController에서만 쓰게 해주었다.

	public WiseSayingController() { // WiseSayingController 메서드를 실행하면
		lastId = 0; // lastId에 0을 담아준다.
		wiseSayings = new ArrayList<>(); // wiseSayings에 새로운 ArrayList을 담아준다.
	}

	private WiseSaying findById(int id) { // WiseSaying 타입의 findById 메서드를 실행하면 정수만 담을 수 있는 id를 매개변수로 받는다. 
		for (WiseSaying wiseSaying : wiseSayings) {
			// wiseSayings의 배열에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀져 WiseSaying 타입의 변수 wiseSaying에 저장된다.
			if (wiseSaying.getId() == id) { // 만약 저장된 변수 wiseSaying의 id가 매개변수로 가져온 id랑 같으면 if문 안쪽이 실행된다.
				return wiseSaying; // wiseSaying 변수를 리턴한다.
			}
		}

		return null; // null 값을 리턴해준다.
	}

	public void write() { // write 메소드를 실행하면 아래의 있는 것을 실행한다.
		int id = lastId + 1; // 정수만 담을 수 있는 변수 id에 lastId에 1를 더한 값을 담아준다.
		System.out.print("명언 : "); // 명언 :를 콘솔에 보여주게 된다.
		String content = Container.getScanner().nextLine().trim();
		// 문자를 담을 수 있는 변수 content에 Container에 있는 Scanner를 가지고 입력한 문자열 한줄을 좌우공백 제거를 한 후에 담는다. 
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();
		// 문자를 담을 수 있는 변수 author에 Container에 있는 Scanner를 가지고 입력한 문자열 한줄을 좌우공백 제거를 한 후에 담는다. 
		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		// WiseSaying만 담을 수 있는 변수 wiseSaying에 
		wiseSayings.add(wiseSaying); // 리스트 형식인 wiseSayings에 위에서 담은 wiseSaying를 추가를 해준다.

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); // 위에 있는 id를 %d자리에 넣어 "번 명언이 등록되었습니다"를 콘솔에 출력을 한다.  
		lastId++; // lastId를 1 증가를 해준다. 

	}

	public void list() { // list 메소드를 실행하면 아래의 있는 것을 실행한다.
		if (wiseSayings.size() == 0) { // 만약 wiseSayings의 사이즈가 0이랑 같으면 if문 안쪽이 실행이 된다.
			System.out.println("등록 된 명언이 없어"); // 등록 된 명언이 없어를 콘솔에 출력을 한다.
		} else { // 위에 if문이 아니라면 아래에 있는 것이 실행된다.
			System.out.println("번호  /  작가  /  명언  "); // 번호  /  작가  /  명언를 콘솔에 출력을 한다. 
			System.out.println("=============================="); // ==============================를 콘솔에 출력을 한다.

			for (int i = wiseSayings.size() - 1; i >= 0; i--) { 
				// 정수만 담을 수 있는 변수 i에 wiseSayings.size() - 1한 값을 담아주고, i가 0보다 크거나 같을때까지 i를 하나씩 감소해주면서 반복을 한다.
				WiseSaying ws = wiseSayings.get(i);
				// WiseSaying만 담을 수 있는 변수 ws에 위에 반복문을 통해 가져온 wiseSayings의 i값을 담아준다.
				System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
				// i값을 담은 ws의 id, author, content를 가져와 콘솔에 출력을 한다.
			}

		}

	}

	public void remove(Rq rq) { // remove를 실행하면 매개변수로 Rq클래스에 있는 rq를 매개변수로 받고 아래에 있는 걸 실행한다. 
		int id = rq.getIntParam("id", -1); // 정수만 담을 수 있는 변수 id에 rq에 있는 IntParam을 실행해서 가져온 id랑 -1를 담아준다.

		if (id == -1) { // 만약 id가 -1이랑 같으면 아래를 실행해준다.
			System.out.println("id(정수)를 제대로 입력해주세요"); // id(정수)를 제대로 입력해주세요를 콘솔에 출력해서 보여준다.
			return; // 리턴을 해준다.
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = findById(id);
		// WiseSaying만 담을 수 있는 변수 wiseSaying에 findById를 실행해서 가져온 id 값을 담아준다.
		if (wiseSaying == null) { // 만약 wiseSaying값이 null이랑 같으면 아래에 있는 것을 실행한다.
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			// id를 %d자리 넣어 콘솔에 출력하여 보여준다.
			return; // 리턴을 해준다.
		}

		
		wiseSayings.remove(wiseSaying);
		// 찾은 명언 객체를 object기반으로 삭제를 한다.
		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
		// 찾은 명언 객체의 id를 %d에 넣어 콘솔에 출력하여 보여준다.
	}

	public void modify(Rq rq) { // modify 메소드를 실행하면 Rq 크래스에 있는 rq를 매개변수로 받고 아래에 있는 것을 실행한다.
		int id = rq.getIntParam("id", -1);
		// 정수만 담을 수 있는 변수 id에 rq에 있는 IntParam를 실행해서 가져온 id와 -1를 담아준다. 
		if (id == -1) { // 만약 위에서 가져온 id가 -1이랑 같으면 if문 안쪽이 실행된다.
			System.out.println("id(정수)를 제대로 입력해주세요");
			// id(정수)를 제대로 입력해주세요를 콘솔에 보여주게 된다.
			return; // 리턴을 해준다.
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = findById(id);
		// WiseSaying만 담을 수 있는 변수 wiseSaying에 findById를 실행해서 가져온 id값을 담아준다.
		if (wiseSaying == null) { // 만약 위에 있는 wiseSaying이 null이랑 같으면 if문 안쪽이 실행된다.
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id); // 입력된 id를 가져와 %d에 넣어 콘솔에 출력을 한다.
			return; // 리턴을 해준다.
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent()); 
		// 찾은 명언 객체에 있는 Content를 콘솔에 보여준다. 
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());
		// 찾은 명언 객체에 있는 Author를 콘솔에 보여준다.
		System.out.print("명언 : "); // 입력할 수 있게 명언 :를 콘솔에 보여준다.
		String content = Container.getScanner().nextLine().trim();
		// 문자만 담을 수 있는 변수 content에 Container에 있는 Scanner를 가지고 입력한 문자열 한줄을 좌우공백을 제거해서 담아준다.
		System.out.print("작가 : "); // 입력할 수 있게 작가 :를 콘솔에 보여준다.
		String author = Container.getScanner().nextLine().trim();
		// 문자만 담을 수 있는 변수 author에 Container에 있는 Scanner를 가지고 입력한 문자열 한줄을 좌우공백을 제거해서 담아준다.
		wiseSaying.setContent(content); // 찾은 객체 wiseSaying에 위에 다시 입력해서 담은 content를 다시 저장해준다.   
		wiseSaying.setAuthor(author); // 찾은 객체 wiseSaying에 위에 다시 입력해서 담은 author를 다시 저장해준다.

		System.out.printf("%d번 명언이 수정되었습니다.\n", id); // 찾은 객체의 id를 가지고 %d에 넣어서 콘솔에 출력하게 된다.
	}

}