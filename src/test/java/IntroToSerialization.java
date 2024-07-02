import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.ResponseParent;
import pojo.Seller;
import pojo.Tag;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;

public class IntroToSerialization {
    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MTg1NDgzMzcsImlhdCI6MTcxNTk1NjMzNywidXNlcm5hbWUiOiJ5cnlza2" +
                "VsZGkwOTIwQGdtYWlsLmNvbSJ9.ktCTVC4SEL9i6cBB_dDhzEc45aDE9fBaf4ijwr" +
                "C0ahAoyd1YEbPDGWu3i3Um31JoI4lVocXVqhwocjw2CB9-QQ";
        /*
        1.create pojo object
         */
//        ResponseParent responseParent = new ResponseParent();
//        Tag tag = new Tag();
//        tag.setName_tag("cls63 ");
//        tag.setDescription("this is cls63 tag");

        /*
        2.serialize pojo object to json object
         */
//        Gson gson = new Gson();
//        String requestBodyInJson = gson.toJson(tag);
//        Response response =  RestAssured.given().contentType(ContentType.JSON)
//               .auth().oauth2(token)
//               .baseUri("https://backend.cashwise.us/")
//               .body(requestBodyInJson).when().post("api/myaccount/tags");
//
//        System.out.println(response.prettyPrint());

        /*
        3. deserialize json to java
         */
//        String responseInJson = response.asString();
//        Gson gson1 = new Gson();
//        Tag tag1 = gson1.fromJson(responseInJson, Tag.class);
//        Assert.assertTrue(tag1.getName_tag().equals(tag.getName_tag()));
//        System.out.println(responseParent.getMessage());
//        System.out.println(Arrays.toString(responseParent.getDetails()));


        Seller seller = new Seller();
        Faker faker = new Faker();
        seller.setCompany_name(faker.company().name());
        seller.setSeller_name(faker.name().fullName());
        seller.setEmail(faker.internet().emailAddress());
        seller.setPhone_number(faker.phoneNumber().cellPhone());
        seller.setAddress(faker.address().fullAddress());
        Gson gson = new Gson();
        String requestBodyInJson = gson.toJson(seller,Seller.class);
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                .baseUri("https://backend.cashwise.us/").body(requestBodyInJson)
                .when().post("api/myaccount/sellers");
        int status = response.statusCode();
        Assert.assertEquals(status,201);
        response.prettyPrint();
        String responseInJson = response.asString();
        Gson gson1 = new Gson();
        Seller responseSeller = gson1.fromJson(responseInJson, Seller.class);
        Assert.assertTrue(responseSeller.getSeller_id() != 0);
        Assert.assertEquals(responseSeller.getCompany_name(),seller.getCompany_name());



    }
}
