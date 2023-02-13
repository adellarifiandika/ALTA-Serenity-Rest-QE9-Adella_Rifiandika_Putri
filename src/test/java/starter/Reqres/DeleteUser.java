package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUser {

    @Steps
    ReqresAPI reqresAPI;

    // Scenario 5 DELETE USER
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id ) {
        reqresAPI.deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    //Negative case
    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        reqresAPI.deleteUser(id);
    }
}
