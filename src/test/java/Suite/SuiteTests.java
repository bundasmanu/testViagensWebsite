package Suite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Drivers.instDrivers;
import UnitTests.CompraBilhetesTest;
import UnitTests.Login;
import UnitTests.PontuacaoDestinosTest;
import UnitTests.RegistoUser;
import UnitTests.TitleTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Armando
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TitleTest.class, RegistoUser.class, Login.class, CompraBilhetesTest.class, PontuacaoDestinosTest.class})
public class SuiteTests {

    @BeforeClass
    public static void setUpClass() throws Exception {
        instDrivers.initWebDriver();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        instDrivers.close();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
