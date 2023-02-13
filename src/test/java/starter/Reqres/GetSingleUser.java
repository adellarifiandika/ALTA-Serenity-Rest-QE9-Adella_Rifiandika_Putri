package starter.Reqres;


//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetSingleUser {

    @Steps
    ReqresAPI reqresAPI;

    //Scenario 3 positive case
    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    //Scenario 3 negative case (invalid id)
    @Given("Get single user with invalid parameter id {string}")
    public void getSingleUserWithInvalidParameterId(String id) {
        reqresAPI.getSingleUserInvalidId(id);
    }

    @When("Send request get invalid single user")
    public void sendRequestGetInvalidSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }


}
