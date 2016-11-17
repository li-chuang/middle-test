package com.lichuang.jdbc.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcSqlServerUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() throws Exception {
		Assert.assertNotNull(JdbcSqlServerUtils.getConnection());
	}

}
