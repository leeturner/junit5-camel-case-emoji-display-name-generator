package com.leeturner;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

@DisplayNameGeneration(CustomDisplayNameGeneratorReplaceCamelCaseUnitTest.ReplaceCamelCase.class)
public class CustomDisplayNameGeneratorReplaceCamelCaseUnitTest {

    @Nested
    class AYearIsNotSupported {

        @Test
        void ifItIsZero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = { -1, -4 })
        void ifItIsNegative(int year) {
        }
    }

    @Nested
    class AYearIsALeapYear {

        @Test
        void ifItIsDivisibleBy4ButNotBy100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = { 2016, 2020, 2048 })
        void ifItIsOneOfTheFollowingYears(int year) {
        }
    }

    static class ReplaceCamelCase extends DisplayNameGenerator.Standard {
        public ReplaceCamelCase() {
        }

        public String generateDisplayNameForClass(Class<?> testClass) {
            return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
        }

        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
        }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return this.replaceCapitals(testMethod.getName());
        }

        private String replaceCapitals(String name) {
            name = name.replaceAll("([A-Z])", " $1");
            name = name.replaceAll("([0-9].)", " $1");
            return name;
        }
    }
}
