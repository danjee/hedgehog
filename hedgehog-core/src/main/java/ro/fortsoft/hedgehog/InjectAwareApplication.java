package ro.fortsoft.hedgehog;

/**
 * Created by daniel on 22.06.2016.
 */
public interface InjectAwareApplication {

    static InjectAwareApplication get(){
        InjectAwareApplication behavior = ThreadContext.getInjectAwareBehavior();
        return behavior;
    }


    Injector getMetaData(MetaDataKey<Injector> key);
}
