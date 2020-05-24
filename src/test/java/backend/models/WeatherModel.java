package backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
//{"speedOfWind(mps)":"1","provider":"weatherbit","city":"Paris","temp(C)":"17,8","time":"Thu May 21 10:23:04 GMT+05:00 2020"}
public class WeatherModel {
    @JsonProperty(value = "speedOfWind(mps)")
    private String speed;
    @JsonProperty(value = "provider")
    private String provider;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "temp(C)")
    private String temp;
    @JsonProperty(value = "time")
    private String time;

    public String getSpeed() {return speed;}
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getProvider() {return provider;}
    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCity() {return city;}
    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {return temp;}
    public void setTemp(String temp) { this.temp = temp; }

    public String getTime() {return time;}
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "WeatherModel{" +
                ", speed='" + speed + '\'' +
                ", provider='" + provider + '\'' +
                ", city='" + city + '\'' +
                ", temp='" + temp + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
