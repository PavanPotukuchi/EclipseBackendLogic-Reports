package com.edonation.exception;

import static com.edonation.testutils.TestUtils.currentTest;
import static com.edonation.testutils.TestUtils.exceptionTestFile;
import static com.edonation.testutils.TestUtils.myAssert;
import static com.edonation.testutils.TestUtils.testReport;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.edonation.controller.DonationController;
import com.edonation.dto.DonationDto;
import com.edonation.service.DonationService;
import com.edonation.testutils.MasterData;

@WebMvcTest(DonationController.class)
@AutoConfigureMockMvc
public class DonationExceptionTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DonationService donationService;

    @AfterAll
    public static void afterAll() {
	testReport();
    }

    @Test
    void testAddDonationInvalidDataException() throws Exception {
	DonationDto userDto = MasterData.getDonationDto();
	DonationDto savedUserDto = MasterData.getDonationDto();

	userDto.setDonationType("Ab");

	when(this.donationService.addDonation(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donations/add-donation")
		.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	myAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
		exceptionTestFile);

    }

    @Test
    void testAddDonationInvalidDonationDateException() throws Exception {
	DonationDto userDto = MasterData.getDonationDto();
	DonationDto savedUserDto = MasterData.getDonationDto();

	userDto.setDonationDate(LocalDate.now().plusDays(1));

	when(this.donationService.addDonation(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donations/add-donation")
		.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	myAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
		exceptionTestFile);

    }

    @Test
    void testAddDonationInvalidDonationAmountException() throws Exception {
	DonationDto userDto = MasterData.getDonationDto();
	DonationDto savedUserDto = MasterData.getDonationDto();

	userDto.setAmount(0.0);

	when(this.donationService.addDonation(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donations/add-donation")
		.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	myAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
		exceptionTestFile);

    }
}
