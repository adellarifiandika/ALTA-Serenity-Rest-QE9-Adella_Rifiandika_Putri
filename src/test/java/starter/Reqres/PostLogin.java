package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class PostLogin {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Login user with valid json file")
    public void loginUserWithValidJsonFile() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/LoginSuccessReqBody.json");
        reqresAPI.postLoginSuccess(jsonReq);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Validate post login successful json schema")
    public void validatePostLoginSuccessfulJsonSchema() {
        File jsonSchemaLoginSucces = new File (Constant.JSON_SCHEMA+"/LoginSuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaLoginSucces));
    }

    //Negative Case
    @Given("Login user with invalid json file")
    public void loginUserWithInvalidJsonFile() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/LoginUnsuccessReqBody.json");
        reqresAPI.postLoginSuccess(jsonReq);
    }

    @And("Validate post login unsuccessful json schema")
    public void validatePostLoginUnsuccessfulJsonSchema() {
        File jsonSchemaLoginUnsucces = new File (Constant.JSON_SCHEMA+"/LoginUnsuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaLoginUnsucces));
    }
}
