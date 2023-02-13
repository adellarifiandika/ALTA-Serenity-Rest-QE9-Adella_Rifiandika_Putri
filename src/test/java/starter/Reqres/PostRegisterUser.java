package starter.Reqres;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constant;

import java.io.File;

public class PostRegisterUser {
    @Steps
    ReqresAPI reqresAPI;

    //positive case
    @Given("Register new users with valid json")
    public void registerNewUsersWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/RegisterSuccessReqBody.json");
        reqresAPI.postRegisterUser(jsonReq);
    }

    @When("Send request register users")
    public void sendRequestRegisterUsers() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA+"RegisterUserSuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }

    //negative case
    @Given("Register new users with invalid json")
    public void registerNewUsersWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/RegisterUnsuccessReqBody.json");
        reqresAPI.postRegisterUser(jsonReq);
    }

    @Then("Should return status code {int} Bad Request")
    public void shouldReturnStatusCodeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);

    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String errorMessage) {
        SerenityRest.then()
                .body(Constant.ERROR, CoreMatchers.equalTo(errorMessage));
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA+"RegisterUserUnsuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }
}