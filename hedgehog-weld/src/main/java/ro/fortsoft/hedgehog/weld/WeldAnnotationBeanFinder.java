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
package ro.fortsoft.hedgehog.weld;

import java.lang.reflect.Field;

import org.jboss.weld.bean.builtin.InstanceImpl;
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
		value = weldContainer.instance().select(field.getType());
		InstanceImpl<?> instance = (InstanceImpl<?>)value;
		return instance.get();
	}
}
