package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class FrameTest {
	private KeyEvent e;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		JFrame frame = new JFrame();
		e = new KeyEvent(frame, 1, 20, 1, 10, 'a');
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenKeyEventUp() {
	  e.setKeyCode(KeyEvent.VK_UP);
	  e.setKeyCode(KeyEvent.VK_Z);
	  assertEquals(ControllerOrder.UP, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventDown() {
	  e.setKeyCode(KeyEvent.VK_DOWN);
	  e.setKeyCode(KeyEvent.VK_S);
	  assertEquals(ControllerOrder.DOWN, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventLeft() {
	  e.setKeyCode(KeyEvent.VK_LEFT);
	  e.setKeyCode(KeyEvent.VK_Q);
	  assertEquals(ControllerOrder.LEFT, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventRight() {
	  e.setKeyCode(KeyEvent.VK_RIGHT);
	  e.setKeyCode(KeyEvent.VK_D);
	  assertEquals(ControllerOrder.RIGHT, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventSpace() {
	  e.setKeyCode(KeyEvent.VK_SPACE);
	  assertEquals(ControllerOrder.SPACE, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventRetry() {
	  e.setKeyCode(KeyEvent.VK_R);
	  assertEquals(ControllerOrder.RETRY, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventUpLeft() {
	  e.setKeyCode(KeyEvent.VK_A);
	  assertEquals(ControllerOrder.UPLEFT, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventUpRight() {
	  e.setKeyCode(KeyEvent.VK_E);
	  assertEquals(ControllerOrder.UPRIGHT, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventDownLeft() {
	  e.setKeyCode(KeyEvent.VK_W);
	  assertEquals(ControllerOrder.DOWNLEFT, Frame.keyCodeToControllerOrder(e));
	
	}
	
	@Test
	public void whenKeyEventDownRight() {
	  e.setKeyCode(KeyEvent.VK_C);
	  assertEquals(ControllerOrder.DOWNRIGHT, Frame.keyCodeToControllerOrder(e));
	
	}
	
	

}
