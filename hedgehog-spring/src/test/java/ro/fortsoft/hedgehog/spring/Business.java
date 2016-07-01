package ro.fortsoft.hedgehog.spring;

import ro.fortsoft.hedgehog.Sting;
import ro.fortsoft.hedgehog.Stinger;

public class Business {
	
	@Sting
	private SpringBean bean;
	
	public Business(){
		Stinger.get().sting(this);
	}
	
	public SpringBean getBean(){
		return bean;
	}
}
