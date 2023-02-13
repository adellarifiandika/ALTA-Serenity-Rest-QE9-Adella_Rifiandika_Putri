package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUser {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 1 positive case
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }
    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File (Constant.JSON_SCHEMA+"/ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    //Negative case invalid page
    @Given("Get list users with invalid page {string}")
    public void getListUsersWithInvalidPage(String page) {
        reqresAPI.getListUsersInvalidId(page);
    }
}
