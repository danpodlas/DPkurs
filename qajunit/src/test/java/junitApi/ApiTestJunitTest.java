package junitApi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.dan.DPkurs.qajunit.junittest.ConfigJunit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Api test junit")
@Tag("junit")
public class ApiTestJunitTest extends ConfigJunit {

    @Test
    public void sampleApiTEst() {
        assertTrue(true);
    }
}
