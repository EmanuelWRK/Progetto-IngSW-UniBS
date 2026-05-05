package it.unibs.ingsw.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class AppModel {
	public static boolean riempiFile(String username) {
		boolean ok = false;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("user.json");
			List<String> users;
			
			if (file.exists()) {
				users = mapper.readValue(file, new TypeReference<List<String>>() {});
			} else {
				users = new ArrayList<>();
			}
			if (users.contains(username)) {
				ok = false;
			} else {
				users.add(username);
				mapper.writeValue(file, users);
				ok = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
}
