# Inventory module

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `order-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/order-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/order-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## sample input

category:
[{
"categoryName":"WOMEN'S CLOTHING",
"categoryDescription":"Women's clothing"
},
{
"categoryName":"MEN'S CLOTHING",
"categoryDescription":"men's clothing"
},
{
"categoryName":"GAMING",
"categoryDescription":"Gaming accessory"
}
]

category ids to be replaced
items:
[
{
"categoryID":"16b1ab90-6692-433b-a9b8-bff6a30b10c6",
"itemName":"PEPE Jeans for women",
"itemDescription":"Short jeans",
"price":6500,
"itemQuantity":100,
"address":"xyz",
"manufacturingCompany":"PEPE",
"vendorName":"PEPE"
},
{
"categoryID":"16b1ab90-6692-433b-a9b8-bff6a30b10c6",
"itemName":"PEPE shirt for women",
"itemDescription":"shirt",
"price":1500,
"itemQuantity":100,
"address":"xyz",
"manufacturingCompany":"PEPE",
"vendorName":"PEPE"
},
{
"categoryID":"499b5914-62ee-4368-a8ad-b09c61837709",
"itemName":"Prince of persia",
"itemDescription":"Prince of persia",
"price":6500,
"itemQuantity":100,
"address":"xyz",
"manufacturingCompany":"UBISOFT",
"vendorName":"UBISOFT"
},
{
"categoryID":"16b1ab90-6692-433b-a9b8-bff6a30b10c6",
"itemName":"PEPE Jeans for men",
"itemDescription":"men jeans",
"price":6500,
"itemQuantity":100,
"address":"xyz",
"manufacturingCompany":"PEPE",
"vendorName":"PEPE"
},
{
"categoryID":"16b1ab90-6692-433b-a9b8-bff6a30b10c6",
"itemName":"PEPE shirts for men",
"itemDescription":"men shirts",
"price":6500,
"itemQuantity":100,
"address":"xyz",
"manufacturingCompany":"PEPE",
"vendorName":"PEPE"
}
]
