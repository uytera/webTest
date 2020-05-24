package backend.services;

import backend.builders.WeatherRequestBuilder;
import backend.models.WeatherModel;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.util.Properties;

public class WeatherService extends BaseService {
    private static final String ENDPOINT = "datasets";

    public WeatherService(Properties properties) {
        super(properties);
    }

    public WeatherRequestBuilder requestBuilder() {
        return new WeatherRequestBuilder(baseRequest());
    }

    public WeatherModel getWeather(RequestSpecification requestSpecification) {
        return executeGetWeather(requestSpecification).then()
                .extract()
                .body().as(WeatherModel.class);
    }

    public Response executeGetWeather(RequestSpecification requestSpecification) {
        return requestSpecification.get();
    }
}
