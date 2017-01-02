package shouldSleep;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShouldSleepTest {
	ShouldSleep ss;
	
	@Before
	public void  setup(){
		ss = new ShouldSleep();
		System.out.println("开始测试");
	}
	
	@After
	public void end(){
		System.out.println("测试结束");
	}
	@Test
	public void testShouldSleep() {
		assertFalse("在工作日但是不再假期",ss.shouldSleep(true,false));
	}
	
	@Test
	public void testShouldSleep1() {
		assertTrue("在工作日也在假期",ss.shouldSleep(true,true));
	}
	
	@Test
	public void testShouldSleep2() {
		assertTrue("不在工作日也不在假期",ss.shouldSleep(false,false));
	}
	
	@Test
	public void testShouldSleep4() {
		assertTrue("不再在工作日但是不在假期",ss.shouldSleep(false,true));
	}

}