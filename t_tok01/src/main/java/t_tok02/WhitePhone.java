package t_tok02;

// 일체형 스마트폰
public class WhitePhone implements Phone{
	private Battery battery;
	
	public WhitePhone() {
		this.battery = new Battery();	// 배터리가 내장되어 있다!!
	}
	
	@Override
	public void show() {
		// 현재 클래스의 이름과 배터리의 이름을 보여준다.
		System.out.println(this.getClass().getSimpleName() + ": " + battery.getName());
	}
}