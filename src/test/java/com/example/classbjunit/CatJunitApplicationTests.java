package com.example.classbjunit;

import com.example.classbjunit.service.ItemServiceTest;
import com.example.classbjunit.service.impl.CartServiceImpl;
import com.example.classbjunit.service.impl.CartServiceImplTest;
import org.junit.jupiter.api.Test;
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
