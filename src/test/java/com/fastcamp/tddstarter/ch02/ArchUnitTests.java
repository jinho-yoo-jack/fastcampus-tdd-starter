package com.fastcamp.tddstarter.ch02;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.fastcamp.tddstarter")
public class ArchUnitTests {
//    @ArchTest
//    public static final ArchRule controller접미사_붙은_클래스는_controller패키지_안에_있어야한다=
//        classes().that().haveSimpleNameEndingWith("Controller")
//            .should().resideInAPackage("com.fastcamp.tddstarter.ch04_1.controller");
//            .should().resideInAnyPackage("..controller..");

    @ArchTest
    public static final ArchRule 컨트롤러는_서비스패키지만_접근가능하다=
        classes().that().resideInAnyPackage("..controller..")
            .should().accessClassesThat().resideInAnyPackage("..service..")
            .orShould().accessClassesThat().resideInAnyPackage("..http..");

    @ArchTest
    public static final ArchRule 컨트롤러는_레파지토리패키지에_접근불가하다=
        noClasses().that().resideInAnyPackage("..controller..")
            .should().accessClassesThat().resideInAnyPackage("..repository..");
}
