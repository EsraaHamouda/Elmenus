package com.elmenu.task;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.ResponseResult;
import entities.Restaurant;
import exception.ApiExceptionHandler;
import exception.ApiRequestException;
import util.JsonParser;

@RestController
@RequestMapping(path = "/api")
public class Controller {

	/***
	 * 
	 * @param closed
	 * @return the open restaurants if closed = 0 and the closed retaurants if
	 *         closed = 1
	 */
	@GetMapping(value = "/restaurant", params = "closed")
	public ResponseEntity<Object> getOpenRestaurants(@RequestParam(value = "closed") Boolean closed) {
		ResponseResult response = new ResponseResult();
		try {
			JsonParser jsonParser = new JsonParser();
			jsonParser.readFromJson();
			Map<String, Restaurant> list = jsonParser.getDatabaseRestaurant();

			ArrayList<Restaurant> res = new ArrayList<>();
			for (Map.Entry<String, Restaurant> entry : list.entrySet()) {
				Restaurant restaurant = entry.getValue();
				if (closed == restaurant.getData().getClosed()) {
					res.add(restaurant);
				}
			}

			return new ResponseEntity<Object>(res, HttpStatus.OK);

		} catch (Exception e) {
			throw new ApiRequestException("Cannot query the restaurants list");
		}

	}

	/***
	 * 
	 * @return all the restaurants stored in the json file
	 */
	@GetMapping(value = "/restaurant")
	public ResponseEntity<Object> allRestaurant() {
		try {
			JsonParser jsonParser = new JsonParser();
			jsonParser.readFromJson();
			JSONArray list = jsonParser.getAllRestauranArray();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiRequestException("Cannot retrive all restaurants");
		}

	}

	/***
	 * 
	 * @param newRestaurant
	 * @param id
	 * @return update specific restaurant data of a given id by the new given data
	 */

	@PutMapping(value = "/restaurant/{uuid}")
	public ResponseResult replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable UUID uuid) {

		try {

			JsonParser jsonParser = new JsonParser();
			jsonParser.readFromJson();
			Map<String, Restaurant> map = jsonParser.getDatabaseRestaurant();
			map.put(uuid.toString(), newRestaurant);
			jsonParser.writeToFile(map);
			return new ResponseResult(true, "Restaurant updated sucessfully", HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseResult(new ApiRequestException("Cannot update a restaurant", e));
		}

	}

	/****
	 * 
	 * @param restaurant
	 * @return insert new restaurant to the json file
	 */
	@PostMapping("/restaurant")
	public ResponseResult createRestaurant(@Valid @RequestBody Restaurant restaurant) {

		try {

			JsonParser jsonParser = new JsonParser();
			jsonParser.readFromJson();
			Map<String, Restaurant> list = jsonParser.getDatabaseRestaurant();
			list.put(restaurant.getUuid(), restaurant);
			jsonParser.writeToFile(list);
			return new ResponseResult(true, "Restaurant is created sucessfully", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseResult(new ApiRequestException("Cannot create new restaurant", e));
		}

	}

}
