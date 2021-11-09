package com.liberi.catjunit;

import com.liberi.catjunit.service.ItemServiceTest;
import com.liberi.catjunit.service.impl.CartServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
		CartServiceImplTest.class, //test case 1
		ItemServiceTest.class     //test case 2
})
class CatJunitApplicationTests {

}
