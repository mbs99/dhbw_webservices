package de.dhbw.tolerantreader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(UserRestClient.class)
class UserRestClientTest {

    @Autowired
    UserRestClient userRestClient;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @ValueSource(strings = {"{\"firstName\":\"John\", \"lastName\":\"Doe\"}",
            "{\"firstName\":\"John\", \"lastName\":\"Doe\", \"age\":22}",
            "{\"name\":\"John Doe\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"age\":22}"})
    void getUserById(String json) {

        this.server.expect(requestTo(""))
                .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));

        UserDto userDto = userRestClient.getUserById("1");

        assertEquals("John", userDto.getFirstName());
        assertEquals("Doe", userDto.getLastName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"{\"firstName\":\"John\"}",
            "{\"name\":\"John\", \"lastName\":\"Doe\"}"})
    void getUserByIdError(String json) {

        this.server.expect(requestTo(""))
                .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));

        try {
        UserDto userDto = userRestClient.getUserById("1");
        } catch (RestClientException e) {
            assertTrue(e.getCause().getMessage().contains("JSON parse error"));

            return;
        }
        catch (Exception e) {
            fail();
        }

        fail();
    }
}