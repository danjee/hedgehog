package ro.fortsoft.hedgehog;

/**
 * Created by daniel on 22.06.2016.
 */
public class ThreadContext {

	private StingAwareApplication application;

	private static final ThreadLocal<ThreadContext> threadLocal = new ThreadLocal<>();

	public static StingAwareApplication getInjectAwareBehavior() {
		ThreadContext context = get(false);
		return context != null ? context.application : null;
	}

	public static void setInjectAwareBehavior(StingAwareApplication behavior) {
		ThreadContext context = get(true);
		context.application = behavior;
	}

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
	 * Restores the context
	 *
	 * @param threadContext
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
