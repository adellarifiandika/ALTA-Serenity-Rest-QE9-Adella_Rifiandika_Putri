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

public class PutUpdateUser {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Update users with valid json and parameter id {int}")
    public void updateUsersWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBody.json");
        reqresAPI.putUpdateUser(id, jsonReq);
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate put update user json schema")
    public void validatePutUpdateUserJsonSchema() {
        File jsonSchemaUpdateUser = new File (Constant.JSON_SCHEMA+"/UpdateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaUpdateUser));
    }

    @Given("Put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/InvalidUpdateUserReqBody.json");
        reqresAPI.putUpdateUser(id, jsonReq);
    }
}
