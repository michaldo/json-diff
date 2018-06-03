package example;

import java.io.File;
import java.io.IOException;
import java.util.EnumSet;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.DiffFlags;
import com.flipkart.zjsonpatch.JsonDiff;

import net.javacrumbs.jsonunit.JsonAssert;

public class JsonTest {

	@Test
	public void testJsonEqualityWithZjsonpatch() throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode expected = mapper.readTree(new File("src/test/resources/expected.json"));
	    JsonNode actual = mapper.readTree(new File("src/test/resources/actual.json"));
		JsonNode differences = JsonDiff.asJson(actual, expected, EnumSet.of(DiffFlags.ADD_ORIGINAL_VALUE_ON_REPLACE));
		StringBuilder errorMessage = new StringBuilder();
		differences.forEach(diff -> errorMessage.append(diff).append("\n"));
		if (errorMessage.length() > 0) {
			throw new AssertionError(errorMessage.toString());
		}
	}
	
	@Test
	public void testJsonEqualityWithJsonunit() throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode expected = mapper.readTree(new File("src/test/resources/expected.json"));
	    JsonNode actual = mapper.readTree(new File("src/test/resources/actual.json"));

		JsonAssert.assertJsonEquals(expected, actual);
	}
	
	

}
