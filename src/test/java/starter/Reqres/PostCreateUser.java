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

public class PostCreateUser {

    @Steps
    ReqresAPI reqresAPI;

    //positive case
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }
    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Validate post create new user json schema")
    public void validatePostCreateNewUserJsonSchema() {
        File jsonSchemaNewUser = new File (Constant.JSON_SCHEMA+"/NewUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaNewUser));
    }

    //negative case
    @Given("Post create user with invalid json")
    public void postCreateUserWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/InvalidCreateUserReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }
}
