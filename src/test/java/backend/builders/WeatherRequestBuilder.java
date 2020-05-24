package backend.builders;

import io.restassured.specification.RequestSpecification;
//http://localhost:8080/weatherService/getWeather?serviceName=bit&city=Paris
public class WeatherRequestBuilder {

    private RequestSpecification requestSpecification;

    public WeatherRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public WeatherRequestBuilder serviceName(String top) {
        requestSpecification.queryParams("serviceName", top);
        return this;
    }

    public WeatherRequestBuilder city(String city) {
        requestSpecification.queryParams("city", city);
        return this;
    }

    public WeatherRequestBuilder getFields(String... fields) {
        requestSpecification.body(fields);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }

}
