package ro.fortsoft.hedgehog.weld;

import ro.fortsoft.hedgehog.DefaultStinged;
import ro.fortsoft.hedgehog.Sting;

public class BusinessPanel extends DefaultStinged{

    @Sting
    private Child child;

    public BusinessPanel(){
    	sting();
    }

    public Child testChild() {
       return child;
    }
}
