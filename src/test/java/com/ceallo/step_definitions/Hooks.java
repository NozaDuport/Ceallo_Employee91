package com.ceallo.step_definitions;

import com.ceallo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){
        Driver.closeDriver();
    }

}
