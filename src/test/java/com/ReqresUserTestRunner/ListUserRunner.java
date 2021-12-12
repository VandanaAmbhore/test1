package com.ReqresUserTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
glue="com.ReqresUserStepDef",
dryRun=false,
monochrome = true,
plugin={"pretty"},
tags="@getJson")

public class ListUserRunner {

}
