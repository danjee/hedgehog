/*
 * Copyright (C) 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.fortsoft.hedgehog;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// TODO: Auto-generated Javadoc
/**
 * Created by daniel on 23.06.2016.
 */
public abstract class AnnotationBeanFinder implements BeanFinder {
	
	/* (non-Javadoc)
	 * @see ro.fortsoft.hedgehog.BeanFinder#getFieldValue(java.lang.reflect.Field, java.lang.Object)
	 */
	@Override
	public Object getFieldValue(Field field, Object fieldOwner) {
		if (supportsField(field)) {
			if (!Modifier.isStatic(field.getModifiers())) {
				Sting sting = field.getAnnotation(Sting.class);
				Object value = getBean(sting, field, fieldOwner);
				if (sting.required() && value == null){
					throw new RuntimeException(String.format("Required injection object %s not found", field.getType()));
				}
				return value;
			}
		}
		return null;
	}

	/**
	 * Gets the bean.
	 *
	 * @param sting the sting
	 * @param field the field
	 * @param fieldOwner the field owner
	 * @return the bean
	 */
	protected abstract Object getBean(Sting sting, Field field, Object fieldOwner);

	/* (non-Javadoc)
	 * @see ro.fortsoft.hedgehog.BeanFinder#supportsField(java.lang.reflect.Field)
	 */
	@Override
	public boolean supportsField(Field field) {
		return field.isAnnotationPresent(Sting.class);
	}
}
