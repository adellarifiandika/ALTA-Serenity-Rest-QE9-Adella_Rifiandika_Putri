package starter.Reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list user invalid page")
    public void getListUsersInvalidId(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single user invalid id")
    public void getSingleUserInvalidId(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user not found")
    public void getSingleUserNotFound(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    public static String GET_LIST_RESOURCE = Constant.BASE_URL+"/api/users/{id}";
    @Step("Get list resource user")
    public void getListResource(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }


    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login Successful")
    public void postLoginSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String POST_REGISTER_USER = Constant.BASE_URL+"/api/register";
    @Step("Post register new user success")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    public static String PATCH_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }


}