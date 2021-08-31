package student_mgn_lks.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public class JdbcUtilTest {
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnecttion() {
		System.out.println("testGetConnection");
		Connection con = JdbcUtill.getConnection();
		Assert.assertNotNull(con);
		System.out.println("con >> "+con);
	}
}
