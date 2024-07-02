import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class IntroToPostRequest {
    public static void main(String[] args) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("product_title", "grapes");
        requestBody.put("product_price", 5);
        requestBody.put("service_type_id", 2);
        requestBody.put("category_id",1);
        requestBody.put("product_description" ,"fruit");
        requestBody.put("date_of_payment","2024-05-20");
        requestBody.put("remind_before_day", 2);
        requestBody.put("do_remind_every_month","REPEAT_EVERY_MONTH");
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MTg1NDgzMzcsImlhdCI6MTcxNTk1NjMzNywidXNlcm5hbWUiOiJ5cnlza2" +
                "VsZGkwOTIwQGdtYWlsLmNvbSJ9.ktCTVC4SEL9i6cBB_dDhzEc45aDE9fBaf4ijwr" +
                "C0ahAoyd1YEbPDGWu3i3Um31JoI4lVocXVqhwocjw2CB9-QQ";

        RestAssured.given().
                contentType(ContentType.JSON).accept(ContentType.JSON)
                .auth().oauth2(token)
                .baseUri("https://backend.cashwise.us").body(requestBody.toString())
                .when().post("api/myaccount/products")
                .then().statusCode(201);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token).baseUri("")
                .body(requestBody.toString()).when().post("endpoint");

    }
}
