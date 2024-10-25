package org.utils;

import com.google.gson.Gson;
import org.models.User;


import java.util.List;

public class JsonHelper {
    public static String convertToJson(List<User> users) {
        Gson gson = new Gson();
        return gson.toJson(users);
    }
}
