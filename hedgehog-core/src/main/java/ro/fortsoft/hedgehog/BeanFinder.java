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

/**
 * Created by daniel on 22.06.2016.
 */
public interface BeanFinder {
    
    /**
     * Returns the value the field will be set to.
     *
     * @param field            field being injected
     * @param fieldOwner            instance of object being injected
     * @return new field value
     */
    Object getFieldValue(Field field, Object fieldOwner);

    /**
     * Returns true if the factory can generate a value for the field, false otherwise.
     *
     * If this method returns false, getFieldValue() will not be called on this factory
     *
     * @param field
     *            field
     * @return true if the factory can generate a value for the field, false otherwise
     */
    boolean supportsField(Field field);
}
