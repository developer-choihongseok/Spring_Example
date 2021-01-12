package t_tok03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 스프링 컨테이너의 생성과 설정을 같이 하고 있다.
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ItemTarget itemTarget = (ItemTarget) context.getBean("itemTarget");
		itemTarget.selectItem();
		System.out.println();
		itemTarget.buyItem();
		System.out.println();
		itemTarget.buyItems();
		
		System.out.println();
		
		GoodsTarget goodsTarget = (GoodsTarget) context.getBean("goodsTarget");
		goodsTarget.buyGoods();
	}
}
