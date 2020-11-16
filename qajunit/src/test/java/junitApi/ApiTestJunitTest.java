package junitApi;

import org.junit.jupiter.api.Test;
import pl.dan.DPkurs.qajunit.junittest.ConfigJunit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTestJunitTest extends ConfigJunit {

    @Test
    public void aaaTest(){
        assertTrue(true);
    }
}
