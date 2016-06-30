package ro.fortsoft.hedgehog;

/**
 * Created by daniel on 22.06.2016.
 */
public interface StingAwareApplication {

    static StingAwareApplication get(){
        StingAwareApplication behavior = ThreadContext.getInjectAwareBehavior();
        return behavior;
    }

    void setMetaData(final MetaDataKey<Stinger> key, final Stinger object);

    Stinger getMetaData(MetaDataKey<Stinger> key);
}
