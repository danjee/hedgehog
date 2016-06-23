package ro.fortsoft.hedgedog.spring;

import java.lang.reflect.Field;

import org.springframework.context.ApplicationContext;

import ro.fortsoft.hedgehog.AnnotationBeanFinder;
import ro.fortsoft.hedgehog.Sting;

public class SpringAnnotationBeanFinder extends AnnotationBeanFinder {

	private ApplicationContext applicationContext;

	public SpringAnnotationBeanFinder(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	protected Object getBean(Sting sting, Field field, Object fieldOwner) {
		Object value = null;
		if (sting.name() != null && sting.name().length() > 0){
			value = applicationContext.getBean(sting.name());
		}
		if (value == null){
			value = applicationContext.getBean(field.getType());
		}
		return value;
	}

}
