package com.perched.peacock.parkspot.mgmt;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

public class ParkingLotStepDefs extends ParkingLotIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Given("parking lot name Lot{int}")
    public void parking_lot_name_Lot(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I call the service create parking lot")
    public void i_call_the_service_create_parking_lot() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should get response with HTTP status code {int}")
    public void i_should_get_response_with_HTTP_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the response should contain the Lot{int}")
    public void the_response_should_contain_the_Lot(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("parking lot name lot{int}")
    public void parking_lot_name_lot(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the response should contain the Unauthorized")
    public void the_response_should_contain_the_Unauthorized() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
