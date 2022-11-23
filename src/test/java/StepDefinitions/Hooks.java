package StepDefinitions;


import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        System.out.println("Seneryo basladi");
    }

    @After
    public void after(){
        System.out.println("Seneryo bitti");
    //    GWD.quitDriver();
    }
}
