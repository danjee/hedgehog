package ro.fortsoft.hedgehog;

import org.junit.Assert;
import org.junit.Test;

public class TestThreadContext {

	@Test
	public void testGet(){
		App app = new App();
		ThreadContext.setInjectAwareBehavior(app);
		Assert.assertNotNull(ThreadContext.getInjectAwareBehavior());
	}
}
