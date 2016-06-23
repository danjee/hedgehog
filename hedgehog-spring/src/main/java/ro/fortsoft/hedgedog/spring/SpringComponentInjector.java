package ro.fortsoft.hedgedog.spring;

import org.springframework.context.ApplicationContext;

import ro.fortsoft.hedgehog.Injector;

public class SpringComponentInjector extends Injector {

	private SpringAnnotationBeanFinder beanFinder;

	public SpringComponentInjector(ApplicationContext applicationContext) {
		beanFinder = new SpringAnnotationBeanFinder(applicationContext);
	}

	@Override
	public void inject(Object object) {
		inject(object, beanFinder);
	}
}
