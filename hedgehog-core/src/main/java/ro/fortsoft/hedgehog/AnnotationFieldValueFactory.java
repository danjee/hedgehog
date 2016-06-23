package ro.fortsoft.hedgehog;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by daniel on 23.06.2016.
 */
public abstract class AnnotationFieldValueFactory implements FieldValueFactory{
    @Override
    public Object getFieldValue(Field field, Object fieldOwner) {
        if (supportsField(field)){
            if (!Modifier.isStatic(field.getModifiers())){

            }
            Named named = field.getAnnotation(Named.class);
            String name = named != null ? named.value() : "";
        }
        return null;
    }

    @Override
    public boolean supportsField(Field field) {
        return field.isAnnotationPresent(Inject.class);
    }
}
