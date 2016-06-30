package ro.fortsoft.hedgehog;

public class App implements StingAwareApplication {

	private MetaDataEntry<Stinger>[] metaData;

	public Stinger getMetaData(MetaDataKey<Stinger> key) {
        return key.get(metaData);
    }

    public void setMetaData(final MetaDataKey<Stinger> key, final Stinger object) {
        metaData = key.set(metaData, object);
    }

}
