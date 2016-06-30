package ro.fortsoft.hedgehog;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by daniel on 23.06.2016.
 */
public abstract class AnnotationBeanFinder implements BeanFinder {
	@Override
	public Object getFieldValue(Field field, Object fieldOwner) {
		if (supportsField(field)) {
			if (!Modifier.isStatic(field.getModifiers())) {
				Sting sting = field.getAnnotation(Sting.class);
				Object value = getBean(sting, field, fieldOwner);
				if (sting.required() && value == null){
					throw new RuntimeException("Required bean not found: " + field.getType());
				}
				return value;
			}
		}
		return null;
	}

	protected abstract Object getBean(Sting sting, Field field, Object fieldOwner);

	@Override
	public boolean supportsField(Field field) {
		return field.isAnnotationPresent(Sting.class);
	}
}
