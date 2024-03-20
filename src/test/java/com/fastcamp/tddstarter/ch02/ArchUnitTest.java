package com.fastcamp.tddstarter.ch02;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.fastcamp.tddstarter")
public class ArchUnitTest {
    @ArchTest
    public static final ArchRule controllerNamingRuleTest =
        classes().that().resideInAPackage("..controller..")
            .should().haveSimpleNameEndingWith("Controller")
            .allowEmptyShould(true);
    @ArchTest
    public static final ArchRule controllerPackageRuleTest =
        classes().that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("com.fastcamp.tddstarter.ch04_1.controller");

    @ArchTest
    public static final ArchRule controllerRuleTest =
        classes().that().resideInAnyPackage("..controller..")
            .should().accessClassesThat().resideInAnyPackage("..service..");

    @ArchTest
    public static final ArchRule controllerRuleTest2 =
        noClasses().that().resideInAnyPackage("..controller..")
            .should().accessClassesThat().resideInAnyPackage("..repository..");

    @ArchTest
    public static final ArchRule serviceRuleTest =
        noClasses().that().resideInAnyPackage("..service..")
            .should().accessClassesThat().resideInAnyPackage("..controller.."); // service 패키지에 있는 어떤 클래스도 controller 패키지에 의존하면 안된다.

/*    @ArchTest
    public static final ArchRule layerTest = layeredArchitecture().consideringAllDependencies()
        .layer("post-layer").definedBy("com.example.post..")
        .layer("user-layer").definedBy("com.example.user..")

        // user-layer는 user-layer와 post-layer에서만 접근할 수 있다.
        .whereLayer("user-layer").mayOnlyBeAccessedByLayers("user-layer", "post-layer")
        // post-layer는 post-layer에서만 접근할 수 있다.
        .whereLayer("post-layer").mayOnlyBeAccessedByLayers("post-layer");*/
}