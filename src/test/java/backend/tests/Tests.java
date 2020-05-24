package backend.tests;


import backend.models.WeatherModel;
import backend.services.WeatherService;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests extends BaseTest {

    @Test(groups = "test")
    public void PositiveWeatherBit() {
        WeatherService weatherService = new WeatherService(properties);
        checkRightData(weatherService, "bit", "Paris", "weatherbit");
    }

    @Test(groups = "test")
    public void NegativeWeatherBit() {
        WeatherService weatherService = new WeatherService(properties);
        checkError(weatherService, "wefewf", "Paris", "wrong provider");
    }


    @Test(groups = "test")
    private void CheckModel() {
        WeatherService weatherService = new WeatherService(properties);
        RequestSpecification requestSpecification = weatherService.requestBuilder()
                .serviceName("bit")
                .city("Paris")
                .build();
        WeatherModel data = weatherService.getWeather(requestSpecification);

        assertThat(data.getCity(), equalTo("Paris"));
    }

    private void checkRightData(WeatherService weatherService, String provider, String city, String providerResponce) {
        RequestSpecification requestSpecification = weatherService.requestBuilder()
                .serviceName(provider)
                .city(city)
                .build();
        ValidatableResponse response = weatherService.executeGetWeather(requestSpecification)
                .then()
                .assertThat()
                .body("provider",  equalTo(providerResponce))
                .body("city", equalTo(city));
    }

    private void checkError(WeatherService weatherService, String provider, String city, String error) {
        RequestSpecification requestSpecification = weatherService.requestBuilder()
                .serviceName(provider)
                .city(city)
                .build();
        ValidatableResponse response = weatherService.executeGetWeather(requestSpecification)
                .then()
                .assertThat()
                .body("error",  equalTo(error));
    }
}
