/**
 * 
 */
package com.vforcore.rest.resources.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vforcore.ApplicationContextUtil;

/**
 * @author stanriku
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("dev")
//@ContextConfiguration(locations = {"classpath*:spring/logging-context.xml","classpath:services-context-test.xml"})
public class MyTest {

	@Test
	public void testMy() {
		ApplicationContextUtil.getContext();
	}
	
}
