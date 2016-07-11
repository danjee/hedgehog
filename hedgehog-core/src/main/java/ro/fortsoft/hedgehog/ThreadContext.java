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
 * Created by daniel on 22.06.2016.
 */
public class ThreadContext {

	/** The application. */
	private StingAwareApplication application;

	/** The Constant threadLocal. */
	private static final ThreadLocal<ThreadContext> threadLocal = new ThreadLocal<>();

	/**
	 * Gets the inject aware behavior.
	 *
	 * @return the inject aware behavior
	 */
	public static StingAwareApplication getInjectAwareBehavior() {
		ThreadContext context = get(false);
		return context != null ? context.application : null;
	}

	/**
	 * Sets the inject aware behavior.
	 *
	 * @param behavior the new inject aware behavior
	 */
	public static void setInjectAwareBehavior(StingAwareApplication behavior) {
		ThreadContext context = get(true);
		context.application = behavior;
	}

	/**
	 * Gets the.
	 *
	 * @param createIfDoesNotExist the create if does not exist
	 * @return the thread context
	 */
	private static ThreadContext get(boolean createIfDoesNotExist) {
		ThreadContext context = threadLocal.get();
		if (context == null) {
			if (createIfDoesNotExist) {
				context = new ThreadContext();
				threadLocal.set(context);
			} else {
				/*
				 * There is no ThreadContext set, but the threadLocal.get()
				 * operation has registered the threadLocal in this Thread's
				 * ThreadLocal map. We must now remove it.
				 */
				threadLocal.remove();
			}
		}
		return context;
	}

	/**
	 * Cleans the {@link ThreadContext} and returns previous context.
	 *
	 * @return old {@link ThreadContext}
	 */
	public static ThreadContext detach() {
		ThreadContext value = threadLocal.get();
		threadLocal.remove();
		return value;
	}

	/**
	 * Restores the context.
	 *
	 * @param threadContext the thread context
	 * @see #detach()
	 */
	public static void restore(ThreadContext threadContext) {
		if (threadContext == null) {
			threadLocal.remove();
		} else {
			threadLocal.set(threadContext);
		}
	}

	/**
	 * Construct.
	 */
	private ThreadContext() {
	}
}
