package poemgenerator.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class SizeValidator implements ConstraintValidator<itec.source.validations.ValidSize, String> {

    private static final List<String> validSizes = Arrays.asList("1024x1024", "512x512", "256x256");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return validSizes.contains(value);
    }

}
