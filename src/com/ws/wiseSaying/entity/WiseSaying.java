package com.ws.wiseSaying.entity;

public class WiseSaying {
	private int id; // 정수만 담을 수 있는 변수 id를 WiseSaying 클래스에만 쓸 수 있게 해 놓았다. 
	private String content; // 문자만 담을 수 있는 변수 content를 WiseSaying 클래스에만 쓸 수 있게 해 놓았다. 
	private String author; // 문자만 담을 수 있는 변수 author를 WiseSaying 클래스에만 쓸 수 있게 해 놓았다. 

	public WiseSaying(int id, String content, String author) {
		// 매개변수로 정수만 담을 수 있는 id, 문자만 담을 수 있는 content와 author를 받는 WiseSaying 생성자를 생성했다. 
		this.id = id; // 필드에 있는 변수 id에 매개변수 id를 담는다. this.a는 필드 / a는 매개변수를 의미 
		this.content = content; // 필드에 있는 변수 content에 매개변수 content를 담는다.
		this.author = author; // 필드에 있는 변수 author에 매개변수 author를 담는다.
	}

	public int getId() {
		return id;
	}
	// 정수만 담을 수 있는 getId 메소드를 실행하면 외부 클래스에서 쓸 수 있게 해준다.
	// id를 리턴해준다. 
	public void setId(int id) {
		this.id = id;
	}
	// setId 메소드를 실행하면 정수만 담을 수 있는 id를 매개변수로 받는다.
	// 필드에 있는 변수 id에 매개변수 id를 담아 저장한다.
	public String getContent() {
		return content;
	}
	// 문자만 담을 수 있는 getContent 메소드를 실행하면 외부 클래스에서 쓸 수 있게 해준다.
	// content를 리턴해준다.
	public void setContent(String content) {
		this.content = content;
	}
	// setContent 메소드를 실행하면 정수만 담을 수 있는 content를 매개변수에 있는 값을 저장한다.
	// 필드에 있는 변수 id에 매개변수 id를 담아 저장한다.
	public String getAuthor() {
		return author;
	}
	// 문자만 담을 수 있는 getAuthor 메소드를 실행하면 외부 클래스에서 쓸 수 있게 해준다.
	// author를 리턴해준다.
	public void setAuthor(String author) {
		this.author = author;
	}
	// setAuthor 메소드를 실행하면 정수만 담을 수 있는 author를 매개변수에 있는 값을 저장한다.
	// 필드에 있는 변수 id에 매개변수 id를 담아 저장한다.
}