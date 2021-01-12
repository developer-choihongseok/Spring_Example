package t_tok01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	/*
	// 기본적인 방식 -> 개발자가 객체 생성을 하고, 값도 자바 클래스 안에서 만들어 주고 있다.
	public static void main2(String[] args) {
		HelloWorld hw = new HelloWorld();
		hw.setMessage("Hello Korea");	// class파일을 직접 수정해야 한다.
		System.out.println(hw.getMessage());
	}
	*/
	
	// ★ 스프링을 이용한 방법
	public static void main(String[] args) {
		// ApplicationContext를 이용해서, 만들어 놓은 beans.xml을 읽어 온다.
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld hw = (HelloWorld)context.getBean("helloWorld");	// 객체화
		System.out.println(hw.getMessage());
	}
}

/*
 ApplicationContext : 스프링에서 핵심적인 인터페이스 => 스프링에 핵심적인 기능을 담당하는 인터페이스!!
 	역할)
 		1) 객체 생성
 		2) 객체들 간의 관계 설정
 		3) 객체 만드는 방식들
 		4) 자동 생성하고, 객체 만들어진 이후에 처리하는 등
*/