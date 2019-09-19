package com.arvindsrivastava.poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    private String INPUT = "123456";

    @Test
    public void testLength() {
        Assert.assertEquals(64, new App().sha256hex(INPUT).length());
    }

    @Test
    public void testHex() {
        String expected = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        Assert.assertEquals(expected, new App().sha256hex(INPUT));
    }

	@Test
    public void testWithExternalData() throws IOException {
		
		System.out.println(this.getClass().getClassLoader().getResource("sample-data-1"));
		
		try( BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("sample-data-1")))){
			
			String input = reader.readLine();
			String expectedOutput = reader.readLine();
	        Assert.assertEquals(expectedOutput, new App().sha256hex(input));
		}
    }

}