package pl.dan.DPkurs.qajunit.junittest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigJunit {

    @BeforeEach
    public void setUpBeforeEach(){
        System.out.println("************** Before each test ***************");
    }
    @BeforeAll
    public static void setUpBeforeAll(){
        System.out.println("************** Before all test ***************");
    }

    @AfterEach
    public void setUpAfterEach() {
        System.out.println("=====After each test========");
    }
    @AfterAll
    public static void setUpAfterAll() {
        System.out.println("=====After all test========");
    }

}
