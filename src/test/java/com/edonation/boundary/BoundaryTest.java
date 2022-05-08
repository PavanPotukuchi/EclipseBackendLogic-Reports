package com.edonation.boundary;

import static com.edonation.testutils.TestUtils.boundaryTestFile;
import static com.edonation.testutils.TestUtils.currentTest;
import static com.edonation.testutils.TestUtils.myAssert;
import static com.edonation.testutils.TestUtils.testReport;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.edonation.dto.DonationDto;
import com.edonation.dto.DonorDto;
import com.edonation.dto.NgoDto;
import com.edonation.testutils.MasterData;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
    private static Validator validator;

    // ----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
	testReport();
    }

    @Test
    void testDonarUsernameNotNull() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setUsername(null);
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarUsernameMin5() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setUsername("dfs");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarUsernameMax30() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setUsername("wertghdfgbnhfghnhjmkghjklkjhgfff");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarNameNotNull() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setDonorName(null);
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarNameMin5() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setDonorName("dfs");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarNameMax30() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setDonorName("wertghdfgbnhfghnhjmkghjklkjhgfff");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPasswordNotNull() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setPassword(null);
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPasswordMin3() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setPassword("df");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPasswordMax25() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setPassword("wertghdfgbnhfghnhjmkghjklkjhgfff");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarEmailNotNull() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setEmail(null);
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarEmailPattern() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setEmail("sdasdf@@gmail.com");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPhoneNumberMax10() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setPhoneNumber("3748784759808");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPhoneNumberMin10() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setPhoneNumber("6765");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPhoneNumberNotNull() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setPhoneNumber(null);
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarPhoneNumberPattern() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setEmail("6767yhgtrf");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarAddressNotNull() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setAddress(null);
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarAddressMin5() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setAddress("df");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonarAddressMax100() throws Exception {
	DonorDto donorDto = MasterData.getDonorDto();
	donorDto.setAddress(
		"wertghdfgbnhfghnhjmkghjklkjhgfffwertghdfgbnhfghnhjmkghjklkjhgfffwertghdfgbnhfghnhjmkghjklkjhgfffwertghdfgbnhfghnhjmkghjklkjhgfff");
	Set<ConstraintViolation<DonorDto>> violations = validator.validate(donorDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgoAddressNotNull() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setAddress(null);
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgoAddressMin5() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setAddress("df");
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgoAddressMax100() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setAddress(
		"derssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssscccccccccccccccccccccccccccccccccccccccccccccbggbgbgcccccccccccccccccccf");
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgoPasswordNotNull() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setPassword(null);
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgoPasswordMin3() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setPassword("df");
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgoPasswordMax25() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setPassword(
		"derssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssscccccccccccccccccccccccccccccccccccccccccccccbggbgbgcccccccccccccccccccf");
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgousernameNotNull() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setUsername(null);
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgousernameMin5() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setUsername("df");
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testNgousernameMax30() throws Exception {
	NgoDto ngoDto = MasterData.getNgoDto();
	ngoDto.setUsername(
		"derssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssscccccccccccccccccccccccccccccccccccccccccccccbggbgbgcccccccccccccccccccf");
	Set<ConstraintViolation<NgoDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }
    
    @Test
    void testDonationTypeNotNull() throws Exception {
	DonationDto ngoDto = MasterData.getDonationDto();
	ngoDto.setDonationType(null);
	Set<ConstraintViolation<DonationDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonationTypeMin5() throws Exception {
	DonationDto ngoDto = MasterData.getDonationDto();
	ngoDto.setDonationType("qwe");
	Set<ConstraintViolation<DonationDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    void testDonationTypeMax100() throws Exception {
	DonationDto ngoDto = MasterData.getDonationDto();
	ngoDto.setDonationType("derssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssscccccccccccccccccccccccccccccccccccccccccccccbggbgbgcccccccccccccccccccf");
	Set<ConstraintViolation<DonationDto>> violations = validator.validate(ngoDto);
	myAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

}
