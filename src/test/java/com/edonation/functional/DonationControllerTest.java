package com.edonation.functional;

import static com.edonation.testutils.TestUtils.businessTestFile;
import static com.edonation.testutils.TestUtils.currentTest;
import static com.edonation.testutils.TestUtils.myAssert;
import static com.edonation.testutils.TestUtils.testReport;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.edonation.controller.DonationController;
import com.edonation.dto.DonationDto;
import com.edonation.dto.DonorDto;
import com.edonation.service.DonationService;
import com.edonation.testutils.MasterData;

@WebMvcTest(DonationController.class)
@AutoConfigureMockMvc
public class DonationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DonationService donationService;

    @AfterAll
    public static void afterAll() {
	testReport();
    }

    @Test
    void testAddDonation() throws Exception {
	DonationDto userDto = MasterData.getDonationDto();
	DonationDto savedUserDto = MasterData.getDonationDto();
	userDto.setDonationDate(LocalDate.now());
	when(this.donationService.addDonation(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donations/add-donation")
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
	 void testGetDonationByDonorId() throws Exception {
		List<DonationDto> savedUserDtos = MasterData.getDonationDtosList();
		when(this.donationService.donationsByDonorId(1L)).thenReturn(savedUserDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/donations/by-donor-id/1")
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
