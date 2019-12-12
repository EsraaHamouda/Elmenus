package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import entities.Data;
import entities.Restaurant;

public class JsonParser {

	/**
	 * read the file data in memory and add it to map
	 */
	public Map<String, Restaurant> databaseRestaurant = new HashMap<>();

	/**
	 * 
	 * @return Json array of the json file
	 */
	public JSONArray getAllRestauranArray() {
		try {

			JSONParser jsonParser = new JSONParser();

			try (FileReader reader = new FileReader("sample-restaurant-data.json")) {

				Object obj = jsonParser.parse(reader);

				JSONArray restaurantsList = (JSONArray) obj;

				return restaurantsList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/***
	 * 
	 * @return return the retaurants map
	 */
	public Map<String, Restaurant> getDatabaseRestaurant() {
		return databaseRestaurant;
	}

	/***
	 * Parse the data file
	 */
	public void readFromJson() {
		try {

			JSONParser jsonParser = new JSONParser();

			try (FileReader reader = new FileReader("sample-restaurant-data.json")) {

				Object obj = jsonParser.parse(reader);

				JSONArray restaurantsList = (JSONArray) obj;

				restaurantsList
						.forEach(restaurant -> databaseRestaurant.put((String) ((JSONObject) restaurant).get("uuid"),
								parseRestauranteObject((JSONObject) restaurant)));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/***
	 * Parse single restaurant json object to pojo object of Restaurant
	 * 
	 * @param restaurant
	 * @return
	 */
	private Restaurant parseRestauranteObject(JSONObject restaurant) {

		Restaurant rest = new Restaurant();
		String uuid = (String) restaurant.get("uuid");
		rest.setUuid(uuid);
		JSONObject dataobject = (JSONObject) restaurant.get("data");
		String enName = (String) dataobject.get("enName");
		String arName = (String) dataobject.get("arName");
		String state = (String) dataobject.get("state");
		String routingMethod = (String) dataobject.get("routingMethod");
		String logo = (String) dataobject.get("logo");
		String coverPhoto = (String) dataobject.get("coverPhoto");
		String enDescription = (String) dataobject.get("enDescription");
		String arDescription = (String) dataobject.get("arDescription");
		String shortNumber = (String) dataobject.get("shortNumber");
		String facebookLink = (String) dataobject.get("facebookLink");
		String twitterLink = (String) dataobject.get("twitterLink");
		String youtubeLink = (String) dataobject.get("youtubeLink");
		String website = (String) dataobject.get("website");
		boolean client = (boolean) dataobject.get("client");
		boolean pendingInfo = (boolean) dataobject.get("pendingInfo");
		boolean pendingMenu = (boolean) dataobject.get("pendingMenu");
		boolean closed = (boolean) dataobject.get("closed");
		boolean onlinePayment = (boolean) dataobject.get("onlinePayment");
		Data tempData = new Data(enName, arName, state, routingMethod, logo, coverPhoto, enDescription, arDescription,
				shortNumber, facebookLink, twitterLink, youtubeLink, website, onlinePayment, client, pendingInfo,
				pendingMenu, closed);
		rest.setData(tempData);
		return rest;

	}

	/**
	 * write the map that holds the restaurants to same json file after update a
	 * restaurant data or inserting new one.
	 * 
	 * @param restaurantMap
	 */
	public void writeToFile(Map<String, Restaurant> restaurantMap) {

		JSONArray jsonArray = new JSONArray();
		for (Map.Entry<String, Restaurant> entry : restaurantMap.entrySet()) {
			Gson gson = new Gson();

			jsonArray.add(gson.toJsonTree(entry.getValue()));
		}
		try {
			FileWriter file = new FileWriter("sample-restaurant-data.json", false);

			JSONArray.writeJSONString(jsonArray, file);
			file.close();
		} catch (Exception e) {

			e.getMessage();

		}

	}

}
