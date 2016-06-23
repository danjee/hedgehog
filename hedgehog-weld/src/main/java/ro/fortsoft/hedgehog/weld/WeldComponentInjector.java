package ro.fortsoft.hedgehog.weld;

import org.jboss.weld.environment.se.WeldContainer;

import ro.fortsoft.hedgehog.Injector;

public class WeldComponentInjector extends Injector {

	private WeldAnnotationBeanFinder beanFinder;

	public WeldComponentInjector(WeldContainer weldContaineri) {
		beanFinder = new WeldAnnotationBeanFinder(weldContaineri);
	}

	@Override
	public void inject(Object object) {
		inject(object, beanFinder);
	}
}
