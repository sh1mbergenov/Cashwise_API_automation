import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class IntroToAPI {
    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MTg1NDgzMzcsImlhdCI6MTcxNTk1NjMzNywidXNlcm5hbWUiOiJ5cnlza2" +
                "VsZGkwOTIwQGdtYWlsLmNvbSJ9.ktCTVC4SEL9i6cBB_dDhzEc45aDE9fBaf4ijwr" +
                "C0ahAoyd1YEbPDGWu3i3Um31JoI4lVocXVqhwocjw2CB9-QQ";

        RestAssured.given().auth().oauth2(token)
                .baseUri("https://backend.cashwise.us")
                .when().get("api/myaccount/sellers/all")
                .then().statusCode(200);

        RestAssured.given().auth().oauth2(token)
                .baseUri("https://backend.cashwise.us").and()
                .queryParam("page","1").
                queryParam("size",4)
                .when().get("api/myaccount/reminder/requests")
                .then().statusCode(200);

        RestAssured.given().auth().oauth2(token)
                .baseUri("https://backend.cashwise.us").and()
                .queryParam("page","1").
                queryParam("size",4)
                .when().get("api/myaccount/reminder/requests")
                .then().statusCode(200);


    }
}
