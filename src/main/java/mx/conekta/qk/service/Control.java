package mx.conekta.qk.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Stereotype;

@Stereotype
@Dependent // Defines a scoped bean
@Target(ElementType.TYPE) // Defines an injectable object
@Retention(RetentionPolicy.RUNTIME)

public @interface Control {} 