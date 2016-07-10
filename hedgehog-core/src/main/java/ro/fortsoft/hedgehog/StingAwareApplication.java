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

// TODO: Auto-generated Javadoc
/**
 * Created by daniel on 22.06.2016.
 */
public interface StingAwareApplication {

    /**
     * Gets the.
     *
     * @return the sting aware application
     */
    static StingAwareApplication get(){
        StingAwareApplication behavior = ThreadContext.getInjectAwareBehavior();
        return behavior;
    }

    /**
     * Sets the meta data.
     *
     * @param key the key
     * @param object the object
     */
    void setMetaData(final MetaDataKey<Stinger> key, final Stinger object);

    /**
     * Gets the meta data.
     *
     * @param key the key
     * @return the meta data
     */
    Stinger getMetaData(MetaDataKey<Stinger> key);
}
