package ro.fortsoft.hedgehog.weld;

import org.jboss.weld.environment.se.WeldContainer;

import ro.fortsoft.hedgehog.Stinger;

public class WeldComponentStinger extends Stinger {

	private WeldAnnotationBeanFinder beanFinder;

	public WeldComponentStinger(WeldContainer weldContaineri) {
		beanFinder = new WeldAnnotationBeanFinder(weldContaineri);
	}

	@Override
	public void sting(Object object) {
		sting(object, beanFinder);
	}
}
