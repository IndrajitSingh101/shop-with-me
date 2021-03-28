package com.ienliven.resource;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import com.ienliven.containers.MongoDBContainer;
import com.ienliven.data.Item;
import com.ienliven.enumeration.InventoryOperationStatus;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import javax.inject.Inject;
import static com.ienliven.containers.MongoDBContainer.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@Testcontainers
@QuarkusTest
public class InventoryResourceTest {
    @Inject
    InventoryService inventoryService;

    @BeforeAll
    static void initAll() {
        RestAssured.defaultParser = Parser.JSON;
    }

    @Container
    static GenericContainer MONGO_DB_CONTAINER=new MongoDBContainer()
            .withCreateContainerCmdModifier(cmd->cmd.withHostName(MONGODB_HOST)
                    .withPortBindings(new PortBinding(Ports.Binding.bindPort(MONGODB_PORT),new ExposedPort(MONGODB_PORT))));

    private final String jsonPayload=  "{\"categoryID\":\"XYZ\",\n" +
            "    \"itemName\":\"PEPE JEANS\",\n" +
            "    \"itemDescription\":\"JEANS\",\n" +
            "    \"price\":1500.0,\n" +
            "    \"itemQuantity\":2,\n" +
            "    \"address\":\"xyz\",\n" +
            "    \"manufacturingCompany\":\"manu\",\n" +
            "    \"vendorName\":\"ven\"}";


    @Test
    public void test(){
        //Mockito.doNothing().when(inventoryService).persistItemDetails(new Item());
        given().contentType(ContentType.JSON).body(jsonPayload)
                .when()
                .post("/inventory/publishItem")
                .then()
                .statusCode(200)
                .body(is(InventoryOperationStatus.ITEM_PERSISTED.name()));
        Item[] items=given().when()
                .get("/inventory/itemList")
                .then()
                .statusCode(200).extract().body().as(Item[].class);
        Assertions.assertThat(items.length).isEqualTo(1);
        Item[] itemArray=given().when().pathParam("category","XYZ")
                .get("/inventory/itemByCategory/{category}")
                .then()
                .statusCode(200).extract().body().as(Item[].class);
        Assertions.assertThat(itemArray.length).isGreaterThan(0);
    }

}
