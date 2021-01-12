package t_tok04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 스프링 컨테이너 생명주기 -> 이 방식으로 할려면, 꼭 refresh()를 해주기!
		// 1. 스프링 컨테이너 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		// 2. 스프링 컨테이너 설정 -> 컨텍스트를 한번 초기화 해주어야 한다. 해주지 않으면 에러 발생!!
		context.load("beans.xml");
		context.refresh();
		
		// 3. 스프링 컨테이너 사용
		Student student = (Student) context.getBean("student");
		System.out.println(student.getName());
		
		// 4. 스프링 컨테이너 종료
		context.close();
	}
}
