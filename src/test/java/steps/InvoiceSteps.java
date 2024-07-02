package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import utilities.CashWiseAuthorization;

public class InvoiceSteps {
    RequestSpecification request;
    Response response;
    String token = CashWiseAuthorization.getToken();
    JSONObject requestBody = new JSONObject();

}
