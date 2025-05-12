package stepdefs;

import io.cucumber.java.en.Given;

public class HelloSteps {
    @Given("I print Hello Cucumber")
    public void i_print_hello_cucumber() {
        System.out.println("Hello Cucumber");
        
              
    }
} 