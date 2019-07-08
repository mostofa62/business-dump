package bd.com.maestro.businessdump.validators;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import bd.com.maestro.businessdump.validators.annotations.ManyToOneRequired;



public class ManyToOneValidator implements ConstraintValidator<ManyToOneRequired, Object> {

	@Override
	public void initialize(ManyToOneRequired manyToOneRequired) {}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext ctx) {
		try {
								
			Method getNameMethod = object.getClass().getMethod("getId");
			Long id = (Long) getNameMethod.invoke(object);
			if(id == null) {
				return false;
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println("Error is"+e.toString());
			return false;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("Error is"+e.toString());
			return false;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Error is"+e.toString());
			return false;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("Error is"+e.toString());
			return false;
		}
		//return false;
		return true;
	}
}
