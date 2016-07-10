package ro.fortsoft.hedgehog.weld;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ro.fortsoft.hedgehog.MetaDataEntry;
import ro.fortsoft.hedgehog.MetaDataKey;
import ro.fortsoft.hedgehog.StingAwareApplication;
import ro.fortsoft.hedgehog.Stinger;

public class TestHedgehogWeld implements StingAwareApplication {

	private MetaDataEntry<Stinger>[] metaData;

	@Before
	public void setup() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		WeldComponentStinger stinger = new WeldComponentStinger(container);
		stinger.bind(this);
	}
	
	
	@Test
	public void testSpring(){
        BusinessPanel business = new BusinessPanel();
        Assert.assertNotNull(business.testChild());
	}

	public Stinger getMetaData(MetaDataKey<Stinger> key) {
		return key.get(metaData);
	}

	public void setMetaData(final MetaDataKey<Stinger> key, final Stinger object) {
		metaData = key.set(metaData, object);
	}
}
