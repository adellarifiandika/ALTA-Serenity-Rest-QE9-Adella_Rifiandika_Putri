package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.util.SafeExceptionRethrower;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class GetSingleUserNotFound {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user not found with valid paramater id {int}")
    public void getSingleUserNotFoundWithValidParamaterIdId(int id) {
        reqresAPI.getSingleUserNotFound(id);
    }

    @When("Send request get single user not found")
    public void sendRequestGetSingleUserNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Validate get single user not found json schema")
    public void validateGetSingleUserNotFoundJsonSchema() {
        File jsonSchemaUserNotFound = new File (Constant.JSON_SCHEMA+"/UserNotFoundJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaUserNotFound));
    }

    //Negative Case
    @Given("Get single user not found with invalid paramater id {int}")
    public void getSingleUserNotFoundWithInvalidParamaterIdId(int id) {
        reqresAPI.getSingleUserNotFound(id);
    }
}
