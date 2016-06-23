package ro.fortsoft.hedgehog;

import java.lang.reflect.Field;

/**
 * Created by daniel on 22.06.2016.
 */
public interface BeanFinder {
    /**
     * Returns the value the field will be set to
     *
     * @param field
     *            field being injected
     * @param fieldOwner
     *            instance of object being injected
     *
     * @return new field value
     */
    Object getFieldValue(Field field, Object fieldOwner);

    /**
     * Returns true if the factory can generate a value for the field, false otherwise.
     *
     * If this method returns false, getFieldValue() will not be called on this factory
     *
     * @param field
     *            field
     * @return true if the factory can generate a value for the field, false otherwise
     */
    boolean supportsField(Field field);
}
