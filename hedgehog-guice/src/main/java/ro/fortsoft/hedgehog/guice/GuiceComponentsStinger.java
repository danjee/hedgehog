package ro.fortsoft.hedgehog.guice;

import com.google.inject.Injector;

import ro.fortsoft.hedgehog.Stinger;

public class GuiceComponentsStinger extends Stinger {

	private GuiceAnnotationBeanFinder beanFinder;

	public GuiceComponentsStinger(Injector injector) {
		beanFinder = new GuiceAnnotationBeanFinder(injector);
	}

	@Override
	public void sting(Object object) {
		sting(object, beanFinder);
	}
}
