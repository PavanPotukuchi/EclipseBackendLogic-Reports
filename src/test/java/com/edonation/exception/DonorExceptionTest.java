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

import com.edonation.controller.DonorController;
import com.edonation.dto.DonorDto;
import com.edonation.service.DonorService;
import com.edonation.testutils.MasterData;

@WebMvcTest(DonorController.class)
@AutoConfigureMockMvc
public class DonorExceptionTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DonorService donorService;

    @AfterAll
    public static void afterAll() {
	testReport();
    }

    @Test
    void testRegisterDonorInvalidDataException() throws Exception {
	DonorDto userDto = MasterData.getDonorDto();
	DonorDto savedUserDto = MasterData.getDonorDto();

	savedUserDto.setId(1L);
	userDto.setUsername("Ab");

	when(this.donorService.registerDonor(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donors/register-donor")
		.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	myAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
		exceptionTestFile);

    }

    @Test
    void testUpdateDonorInvalidDataException() throws Exception {
	DonorDto userDto = MasterData.getDonorDto();
	DonorDto savedUserDto = MasterData.getDonorDto();

	userDto.setId(null);

	when(this.donorService.updateDonor(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/donors/update-donor")
		.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	myAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
		exceptionTestFile);

    }

    @Test
    void testRegisterDonorNgoInvalidEstablishedDateException() throws Exception {
	DonorDto userDto = MasterData.getDonorDto();
	DonorDto savedUserDto = MasterData.getDonorDto();

	userDto.getNgo().setEstablishedDate(LocalDate.now());
	;

	when(this.donorService.registerDonor(userDto)).thenReturn(savedUserDto);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/donors/register-donor")
		.content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	myAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
		exceptionTestFile);

    }

}
