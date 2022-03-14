package com.epam.demoproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.regex.Pattern;

public class ItemConstraintValidator implements ConstraintValidator<ItemsWrittenInSnakeCase, Set<String>> {
    private static final Pattern PATTERN = Pattern.compile("^[a-z]+(?:_[a-z]+)*$");

    @Override
    public boolean isValid(Set<String> set, ConstraintValidatorContext constraintValidatorContext) {
        if (set != null && !set.isEmpty()) {
            return set.stream().allMatch(s -> PATTERN.matcher(s).matches());
        }
        return false;
    }
}
