package starter.Reqres;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 3 GET single users (-)



    //SCENARIO 6 PATCH UPDATE USER
    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate patch update user json schema")
    public void validatePatchUpdateUserJsonSchema() {
        File jsonSchemaUpdateUser = new File (Constant.JSON_SCHEMA+"/UpdateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaUpdateUser));
    }


    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
    }

    @Given("Get single user not found with valid paramater id <id>")
    public void getSingleUserNotFoundWithValidParamaterIdId() {
    }


}