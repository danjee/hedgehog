package ro.fortsoft.hedgehog.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ro.fortsoft.hedgedog.spring.SpringComponentStinger;
import ro.fortsoft.hedgehog.MetaDataEntry;
import ro.fortsoft.hedgehog.MetaDataKey;
import ro.fortsoft.hedgehog.StingAwareApplication;
import ro.fortsoft.hedgehog.Stinger;

public class TestHedgehogSpring implements StingAwareApplication {

	private MetaDataEntry<Stinger>[] metaData;
	
	@Before
	public void setup(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        SpringComponentStinger stinger = new SpringComponentStinger(context);
        stinger.bind(this);
	}
	
	@Test
	public void testSpring(){
        Business business = new Business();
        Assert.assertNotNull(business.getBean());
	}

	public Stinger getMetaData(MetaDataKey<Stinger> key) {
        return key.get(metaData);
    }

    public void setMetaData(final MetaDataKey<Stinger> key, final Stinger object) {
        metaData = key.set(metaData, object);
    }
}
