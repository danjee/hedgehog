package ro.fortsoft.hedgehog;

/**
 * Class used for holding meta data entries.
 *
 * @param <T> The meta data key type
 * @author Jonathan Locke
 */
public final class MetaDataEntry<T> {
    
    final MetaDataKey<T> key;

    Object object;

    /**
     * Construct.
     *
     * @param key    meta data key
     * @param object
     */
    public MetaDataEntry(MetaDataKey<T> key, Object object) {
        this.key = key;
        this.object = object;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return key + "=" + object.getClass().getName() + "@" +
                Integer.toHexString(object.hashCode());
    }
}