package org.utils;

import io.cucumber.datatable.DataTable;
import org.models.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataHelper {
    public static List<User> mapToUserList(DataTable dataTable) {
        List<User> users = new ArrayList<>();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            User user = new User();
            user.setName(row.get("name"));
            user.setAge(Integer.parseInt(row.get("age")));
            user.setGender(row.get("gender"));
            users.add(user);
        }
        return users;
    }
}
