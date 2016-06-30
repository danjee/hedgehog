package ro.fortsoft.hedgehog;

import org.junit.Test;

import org.junit.Assert;

public class TestMetaData {

	private MetaDataEntry<Stinger>[] metaData;

	@Test
	public void testMetadata() {
		MetaDataKey<Stinger> key = new MetaDataKey<Stinger>() {

		};
		Stinger object = new Stinger() {

			@Override
			public void sting(Object object) {

			}
		};
		metaData = key.set(metaData, object);

		Stinger lookup = key.get(metaData);
		Assert.assertEquals(lookup, object);
	}
}
