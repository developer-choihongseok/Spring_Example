package t_tok04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/*
 Bean Life Cycle 관리 방법
  1. 인터페이스 구현 -> 지정 되어있는 이름의 메서드로만 사용해야 한다.
  2. Bean 정의 시 메서드 지정 -> 메서드 이름을 만들어서 지정할 수 있다. 
  3. 어노테이션 지정 -> xml에서 추가적인 설정 몇 가지 해주어야 한다!
  
   이 3가지 방법 중에서, 어플리케이션 설계와 프로젝트 특성에 맞게 사용하면 된다.
  
  1번과 2번은 오직 스프링에서만 사용 가능!! -> 스프링에 종속.
  3번은 스프링에 종속 되지 않고,
    만약에) IOC 컨테이너 또는 Bean Life Cycle를 관리할 수 있는 다른 프레임워크가 있다면, 똑같은 방식으로 사용 가능!
    
    특정한 경우에 따라서 3가지 방법이 동시에 들어가게 된다면, 실행 순서?
  	1.어노테이션 지정 -> 2.인터페이스 구현 -> 3.Bean 정의 시 메서드 지정
*/
public class Student implements InitializingBean, DisposableBean{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 2번째 방법
	// 초기화 메서드
	public void init() {
		System.out.println(name + "은 학생인가요?");
	}
	
	// 소멸 메서드
	public void cleanUp() {
		System.out.println(name + "은 학생이 아니었습니다.");
	}
	
	// 3번째 방법
	// 초기화 메서드
	@PostConstruct
	public void postConstruct() {
		if("스프링".equals(name)) {
			System.out.println(name + "을 정말 열심히 하네요.");
		}else {
			System.out.println(name + "은 몇 살인가요?");
		}
	}
	
	// 소멸 메서드
	@PreDestroy
	public void preDestory() {
		if("스프링".equals(name)) {
			System.out.println("감사합니다. 열심히 하겠습니다.");
		}else {
			System.out.println("나이는 비밀입니다.");
		}
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Bean이 소멸될 때 호출된다. 자원을 반납할 부분이 있다면, 여기서 진행한다.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean이 생성될 때 호출된다. Bean 생성과 DI 이후에 초기화 부분이 있다면, 여기서 진행한다.");
	}
}
