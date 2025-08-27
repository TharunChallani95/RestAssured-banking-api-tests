package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BankingApiTest {

    private String token;

    @BeforeClass
    public void login() {
        // Using reqres.in as a stand-in for a banking auth service
        token = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body("{\"email\":\"eve.holt@reqres.in\", \"password\":\"cityslicka\"}")
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .extract().path("token");
    }

    @Feature("Balance")
    @Test(description="Get balance with JWT token")
    @Description("Simulates an authenticated call with a bearer token, validates fields & schema-like expectations.")
    public void getBalance() {
        given()
            .filter(new AllureRestAssured())
            .auth().oauth2(token)
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("support.url", containsString("reqres.in"));
    }

    @Feature("Transfer")
    @Test(description="Transfer funds payload validation")
    public void transferFunds() {
        given()
            .filter(new AllureRestAssured())
            .auth().oauth2(token)
            .contentType(ContentType.JSON)
            .body("{\"from\":\"SAVINGS\", \"to\":\"CHECKING\", \"amount\":100.50}")
            .when()
            .post("https://httpbin.org/post")
            .then()
            .statusCode(200)
            .body("json.amount", greaterThan(0f));
    }
}
