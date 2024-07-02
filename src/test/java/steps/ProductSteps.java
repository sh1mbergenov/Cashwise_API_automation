package steps;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.CashWiseAuthorization;

import static org.hamcrest.Matchers.equalTo;

public class ProductSteps {
    RequestSpecification request;
    Response response;
    String token = CashWiseAuthorization.getToken();
    JSONObject requestBody = new JSONObject();

    @Given("base url {string}")
    public void base_url(String baseUrl) {
       request = RestAssured.given().baseUri(baseUrl).contentType(ContentType.JSON);
    }
    @Given("I have access")
    public void i_have_access() {
     request = request.auth().oauth2(token);
    }
    @Given("I have the endpoint {string}")
    public void i_have_the_endpoint(String endpoint) {
         request = request.basePath(endpoint);
    }
    @Given("I have a {string} with {string} in request body")
    public void i_have_a_with_in_request_body(String key, String value) {
        requestBody.put(key,value);

    }
    @When("I send POST request")
    public void i_send_post_request() {
        response = request.body(requestBody.toString()).post();
    }
    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer statusCode) {
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),statusCode);
    }
    @Then("verify I have {string} with {string} in response body")
    public void verify_i_have_with_in_response_body(String key, String value) {
       response.then().body(key,equalTo(value));
        Assert.assertEquals(value,response.jsonPath().getString("product_title"));

    }
    @Then("I delete the product")
    public void i_delete_the_product() {
       String id = response.jsonPath().getString("product_id");
       Response response1 = RestAssured.given()
               .baseUri("https://backend.cashwise.us/api/myaccount/")
               .auth().oauth2(token).
               when().delete("products/"+id);
       int statusCode = response1.statusCode();
       Assert.assertEquals(statusCode,200);

    }
    @Given("I have {string} with {string} as query param")
    public void i_have_with_as_query_param(String key, String value) {
        request = request.queryParam(key,value);
    }
    @When("I send GET request")
    public void i_send_get_request() {
        response = request.get();
    }
    @Then("verify the invoice details in the response match the database")
    public void verify_the_invoice_details_in_the_response_match_the_database() {

    }


}
