package test;

import static org.junit.Assert.*;
import org.junit.Test;
import med.Balloon;

public class TestBalloon extends Balloon{

	@Test
	public void testInit() {
		init();
		assertEquals(getWidth(),25);
	}

}
