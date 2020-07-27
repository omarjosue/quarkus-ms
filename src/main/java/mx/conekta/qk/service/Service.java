package mx.conekta.qk.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;

@Stereotype
@Transactional // Defines a enterprise behaviour
@RequestScoped // Defines a stateless enterprise object
@Target(ElementType.TYPE) // Defines an injectable object
@Retention(RetentionPolicy.RUNTIME)

public @interface Service {} 