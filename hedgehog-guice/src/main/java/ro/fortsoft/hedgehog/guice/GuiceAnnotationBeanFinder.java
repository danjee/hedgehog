package ro.fortsoft.hedgehog.guice;

import java.lang.reflect.Field;

import com.google.inject.Injector;

import ro.fortsoft.hedgehog.AnnotationBeanFinder;
import ro.fortsoft.hedgehog.Sting;

public class GuiceAnnotationBeanFinder  extends AnnotationBeanFinder {
	
	private Injector injector;
	
	public GuiceAnnotationBeanFinder(Injector injector) {
		this.injector = injector;
	}

	@Override
	protected Object getBean(Sting sting, Field field, Object fieldOwner) {
		return injector.getInstance(field.getType());
	}

}
