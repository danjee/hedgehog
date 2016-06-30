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

/**
 * Class used for holding meta data entries.
 *
 * @author Jonathan Locke
 * @param <T> The meta data key type
 */
public final class MetaDataEntry<T> {
    
    /** The key. */
    final MetaDataKey<T> key;

    /** The object. */
    Object object;

    /**
     * Construct.
     *
     * @param key    meta data key
     * @param object the object
     */
    public MetaDataEntry(MetaDataKey<T> key, Object object) {
        this.key = key;
        this.object = object;
    }

    /**
     * To string.
     *
     * @return the string
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return key + "=" + object.getClass().getName() + "@" +
                Integer.toHexString(object.hashCode());
    }
}