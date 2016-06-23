package ro.fortsoft.hedgehog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 22.06.2016.
 */
public abstract class Injector {

    private static final MetaDataKey<Injector> KEY = new MetaDataKey<Injector>() {
        
    };

    private final ClassMetaCache<Field[]> cache = new ClassMetaCache<>();

    public static Injector get() {
        return InjectAwareApplication.get().getMetaData(KEY);
    }

    public abstract void inject(Object object);

    /**
     * traverse fields in the class hierarchy of the object and set their value with a locator
     * provided by the locator factory.
     *
     * @param object
     * @param factory
     */
    protected void inject(final Object object, final FieldValueFactory factory)
    {
        final Class<?> clazz = object.getClass();

        Field[] fields = null;

        // try cache
        fields = cache.get(clazz);

        if (fields == null)
        {
            // cache miss, discover fields
            fields = findFields(clazz, factory);

            // write to cache
            cache.put(clazz, fields);
        }

        for (final Field field : fields)
        {
            if (!field.isAccessible())
            {
                field.setAccessible(true);
            }
            try
            {

                if (field.get(object) == null)
                {

                    Object value = factory.getFieldValue(field, object);

                    if (value != null)
                    {
                        field.set(object, value);
                    }
                }
            }
            catch (IllegalArgumentException e)
            {
                throw new RuntimeException("error while injecting object [" + object.toString() +
                        "] of type [" + object.getClass().getName() + "]", e);
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException("error while injecting object [" + object.toString() +
                        "] of type [" + object.getClass().getName() + "]", e);
            }
        }
    }

    /**
     * Returns an array of fields that can be injected using the given field value factory
     *
     * @param clazz
     * @param factory
     * @return an array of fields that can be injected using the given field value factory
     */
    private Field[] findFields(Class<?> clazz, final FieldValueFactory factory)
    {
        List<Field> matched = new ArrayList<>();

        while (clazz != null)
        {
            Field[] fields = clazz.getDeclaredFields();
            for (final Field field : fields)
            {
                if (factory.supportsField(field))
                {
                    matched.add(field);
                }
            }
            clazz = clazz.getSuperclass();
        }

        return matched.toArray(new Field[matched.size()]);
    }
}
