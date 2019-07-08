package bd.com.maestro.businessdump.validators.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import bd.com.maestro.businessdump.validators.ManyToOneValidator;



@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = ManyToOneValidator.class)
public @interface ManyToOneRequired {
	String message() default "";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
