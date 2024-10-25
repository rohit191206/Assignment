package org.utils;

import com.google.gson.Gson;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.models.User;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHelper {
    public static String convertToJson(List<User> users) {
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    private static final String DATA_FILE_PATH = "src/test/resources/testData.json";

    public static List<User> loadUsersFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(DATA_FILE_PATH), new TypeReference<List<User>>() {});
    }
}
