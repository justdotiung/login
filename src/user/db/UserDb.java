package user.db;

import java.util.HashMap;
import java.util.Map;

public class UserDb {
private static Map<String,User> map = new HashMap<String, User>();

public static void addUser(User user) {
	map.put(user.getUserId(), user);
}
}
