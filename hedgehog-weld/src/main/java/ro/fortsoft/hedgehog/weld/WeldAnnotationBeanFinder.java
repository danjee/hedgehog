package ro.fortsoft.hedgehog.weld;

import java.lang.reflect.Field;

import org.jboss.weld.environment.se.WeldContainer;

import ro.fortsoft.hedgehog.AnnotationBeanFinder;
import ro.fortsoft.hedgehog.Sting;

public class WeldAnnotationBeanFinder extends AnnotationBeanFinder {

	private WeldContainer weldContainer;

	public WeldAnnotationBeanFinder(WeldContainer weldContainer) {
		this.weldContainer = weldContainer;
	}

	@Override
	protected Object getBean(Sting sting, Field field, Object fieldOwner) {
		Object value = null;
		if (sting.name() != null && sting.name().length() > 0) {
			value = weldContainer.instance().select(field.getType());
		}
		return value;
	}
}
