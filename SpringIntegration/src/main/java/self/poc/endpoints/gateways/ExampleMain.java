package self.poc.endpoints.gateways;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleMain {

	public static void main(String[] args) {
		String cfg = "self/poc/endpoints/gateways/context.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(cfg);
		HelloService helloService = context.getBean("helloGateway", HelloService.class);
		
		System.out.println(helloService.doSomething("World"));		
	}

}
