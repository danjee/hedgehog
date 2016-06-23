package ro.fortsoft.hedgedog.spring;

import org.springframework.context.ApplicationContext;

import ro.fortsoft.hedgehog.Stinger;

public class SpringComponentStinger extends Stinger {

	private SpringAnnotationBeanFinder beanFinder;

	public SpringComponentStinger(ApplicationContext applicationContext) {
		beanFinder = new SpringAnnotationBeanFinder(applicationContext);
	}

	@Override
	public void sting(Object object) {
		sting(object, beanFinder);
	}
}
