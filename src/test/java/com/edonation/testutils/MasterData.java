package com.edonation.testutils;

import java.util.ArrayList;
import java.util.List;

import com.edonation.dto.DonationDto;
import com.edonation.dto.DonorDto;
import com.edonation.dto.NgoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class MasterData {

    static ObjectMapper mapper = JsonMapper.builder() // or different mapper for other format
	    .addModule(new ParameterNamesModule())
	    .addModule(new Jdk8Module())
	    .addModule(new JavaTimeModule())
	    // and possibly other configuration, modules, then:
	    .build();

    public static DonorDto getDonorDto() {

	DonorDto donorDto = null;
	try {
	    donorDto = mapper.readValue("{\n" + "        \"id\": 1,\n" + "        \"donorName\": \"amitpatel\",\n"
		    + "        \"username\": \"amitpatel\",\n" + "        \"password\": \"asdfghj\",\n"
		    + "        \"email\": \"amitpatel@gmail.com\",\n" + "        \"phoneNumber\": \"7780443926\",\n"
		    + "        \"address\": \"asdfaadasdffafa\",\n" + "        \"ngo\": {\n"
		    + "            \"id\": 1,\n" + "            \"ngoName\": \"ngonamed\",\n"
		    + "            \"username\": \"amitpatel\",\n" + "            \"password\": \"adfgdsd\",\n"
		    + "            \"address\": \"asdfaadasdffafa\",\n"
		    + "            \"phoneNumber\": \"7780443926\",\n"
		    + "            \"establishedDate\": \"2017-01-13\",\n" + "            \"donors\": null\n"
		    + "        },\n" + "        \"ngoId\": 2\n" + "    }", DonorDto.class);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}

	return donorDto;
    }

    public static List<DonorDto> getDonorDtosList() {
	List<DonorDto> donorDtos = new ArrayList<>();
	donorDtos.add(getDonorDto());
	return donorDtos;

    }
    
    public static List<DonationDto> getDonationDtosList() {
   	List<DonationDto> donorDtos = new ArrayList<>();
   	donorDtos.add(getDonationDto());
   	return donorDtos;

       }
    
    public static DonationDto getDonationDto() {

   	DonationDto donationDto = null;
   	try {
   	 donationDto = mapper.readValue("{\n"
   	 	+ "        \"id\": 14,\n"
   	 	+ "        \"donor\": {\n"
   	 	+ "            \"id\": 2,\n"
   	 	+ "            \"donorName\": \"amitpatel\",\n"
   	 	+ "            \"username\": \"amitpatel\",\n"
   	 	+ "            \"password\": \"qwertyuj\",\n"
   	 	+ "            \"email\": \"amitpatel@gmail.com\",\n"
   	 	+ "            \"phoneNumber\": \"7780443926\",\n"
   	 	+ "            \"address\": \"asdfaadasdffafa\",\n"
   	 	+ "            \"ngo\": null,\n"
   	 	+ "            \"ngoId\": 3\n"
   	 	+ "        },\n"
   	 	+ "        \"donorId\": 2,\n"
   	 	+ "        \"ngo\": {\n"
   	 	+ "            \"id\": 1,\n"
   	 	+ "            \"ngoName\": \"ngonamed\",\n"
   	 	+ "            \"username\": \"amitpatel\",\n"
   	 	+ "            \"password\": \"ertghjyu\",\n"
   	 	+ "            \"address\": \"asdfaadasdffafa\",\n"
   	 	+ "            \"phoneNumber\": \"7780443926\",\n"
   	 	+ "            \"establishedDate\": \"2017-01-13\",\n"
   	 	+ "            \"donors\": null\n"
   	 	+ "        },\n"
   	 	+ "        \"ngoId\": 1,\n"
   	 	+ "        \"donationType\": \"patanahi\",\n"
   	 	+ "        \"amount\": 3400.0,\n"
   	 	+ "        \"donationDate\": \"2022-05-05\"\n"
   	 	+ "    }", DonationDto.class);
   	} catch (JsonProcessingException e) {
   	    e.printStackTrace();
   	}

   	return donationDto;
       }
    
    public static NgoDto getNgoDto() {

   	NgoDto ngoDto = null;
   	try {
   	 ngoDto = mapper.readValue("{\n"
   	 	+ "            \"id\": 1,\n"
   	 	+ "            \"ngoName\": \"ngonamed\",\n"
   	 	+ "            \"username\": \"amitpatel\",\n"
   	 	+ "            \"password\": \"äsfdsfd\",\n"
   	 	+ "            \"address\": \"asdfaadasdffafa\",\n"
   	 	+ "            \"phoneNumber\": \"7780443926\",\n"
   	 	+ "            \"establishedDate\": \"2017-01-13\",\n"
   	 	+ "            \"donors\": null\n"
   	 	+ "        }", NgoDto.class);
   	} catch (JsonProcessingException e) {
   	    e.printStackTrace();
   	}

   	return ngoDto;
       }
    
    

    public static String asJsonString(final Object obj) {
	try {
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    final String jsonContent = mapper.writeValueAsString(obj);

	    return jsonContent;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
}
