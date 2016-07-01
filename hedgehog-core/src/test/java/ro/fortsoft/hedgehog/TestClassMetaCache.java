package ro.fortsoft.hedgehog;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;


public class TestClassMetaCache {

	private final ClassMetaCache<Field[]> cache = new ClassMetaCache<>();
	
	@Test
	public void testPut(){
		Assert.assertNotNull(cache);
		Field[] fields = String.class.getDeclaredFields();
		cache.put(String.class, fields);
		Assert.assertArrayEquals(fields, cache.get(String.class));
	}
}
