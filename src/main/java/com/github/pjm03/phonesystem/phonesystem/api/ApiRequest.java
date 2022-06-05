package com.github.pjm03.phonesystem.phonesystem.api;

import com.github.pjm03.phonesystem.phonesystem.exception.ApiRequestException;
import com.github.pjm03.phonesystem.phonesystem.human.Human;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiRequest {
    @Value("${universe-url.human-system}")
    private String humanSystemUrl;

    private final Gson gson;

    public Human getHuman(String humanSerial) {
        RestTemplate template = new RestTemplate();
        try {
            String jsonString = template.getForObject(humanSystemUrl + "/human/deserialize/" + humanSerial, String.class);
            JsonObject json = gson.fromJson(jsonString, JsonElement.class).getAsJsonObject();

            String status = json.get("status").getAsString();
            if (status.equals(HttpStatus.OK.name())) {
                return gson.fromJson(json.get("data").getAsJsonObject(), Human.class);
            } else {
                throw new ApiRequestException(HttpStatus.valueOf(status), json.get("message").getAsString(), "API 요청 중 에러 발생");
            }
        } catch (HttpServerErrorException e) {
            throw new ApiRequestException(e.getStatusCode(), e.getMessage(), "요청 중 서버 에러(5xx) 발생.");
        }
    }
}
