package t_tok02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 배터리 일체형
		WhitePhone wp = new WhitePhone();
		wp.show();
		
		// 배터리 분리형 - DI 디자인 패턴 : IOC를 구현할 수 있는 디자인 패턴.
		BlackPhone bp = new BlackPhone();
		bp.show();
		
		// DI를 구현할 수 있는 방법 2가지 -> 배터리를 기준으로.
		// 1. 생성자 주입방법
		Battery newBattery = new Battery("새로 산 배터리 - 생성자");
		bp.setBattery(newBattery);
		bp.show();
		
		// 2. 세터 주입방법
		newBattery.setName("새로 산 배터리 - 세터");
		bp.setBattery(newBattery);
		bp.show();
		
		// ★ 스프링을 이용한 DI 디자인 패턴 구현 방법
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BlackPhone newBp = (BlackPhone) context.getBean("blackPhone");
		newBp.show();
	}
}