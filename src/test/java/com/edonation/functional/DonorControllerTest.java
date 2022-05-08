package com.edonation.functional;

import static com.edonation.testutils.TestUtils.businessTestFile;
import static com.edonation.testutils.TestUtils.currentTest;
import static com.edonation.testutils.TestUtils.exceptionTestFile;
import static com.edonation.testutils.TestUtils.myAssert;
import static com.edonation.testutils.TestUtils.testReport;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.edonation.controller.DonorController;
import com.edonation.dto.DonorDto;
import com.edonation.service.DonorService;
import com.edonation.testutils.MasterData;

@WebMvcTest(DonorController.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DonorControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DonorService donorService;
	
	

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	 void testRegisterDonor() throws Exception {
		DonorDto userDto = MasterData.getDonorDto();
		DonorDto savedUserDto = MasterData.getDonorDto();
		when(this.donorService.registerDonor(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donors/register-donor")
				.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(MasterData.asJsonString(savedUserDto));
		myAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDto))
					? "true"
					: "false"),
				businessTestFile);

	}
	
	@Test
	    void testUpdateDonor() throws Exception {
		DonorDto userDto = MasterData.getDonorDto();
		DonorDto savedUserDto = MasterData.getDonorDto();


		when(this.donorService.updateDonor(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/donors/update-donor")
			.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		myAssert(currentTest(),
			(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDto))
				? "true"
				: "false"),
			businessTestFile);

	    }
	
	@Test
	 void testGetDonorByNgoId() throws Exception {
		List<DonorDto> savedUserDtos = MasterData.getDonorDtosList();
		when(this.donorService.donorsByNgoId(1L)).thenReturn(savedUserDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/donors/by-ngo-id/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		myAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDtos))
					? "true"
					: "false"),
				businessTestFile);
	
	}
	
	

}
