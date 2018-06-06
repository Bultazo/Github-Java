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

/**
 * @author DELL
 *
 */
public class FrameTest {
	/**
	 * The event
	 */
	private KeyEvent e;


	/**
	 * The test setUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		JFrame frame = new JFrame();
		e = new KeyEvent(frame, 1, 20, 1, 10, 'a');
	}

	/**
	 * The test tearDown
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The test whenKeyEventUp
	 */
	@Test
	public void whenKeyEventUp() {
		e.setKeyCode(KeyEvent.VK_UP);
		assertEquals(ControllerOrder.UP, Frame.keyCodeToControllerOrder(e));
		e.setKeyCode(KeyEvent.VK_Z);
		assertEquals(ControllerOrder.UP, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventDown
	 */
	@Test
	public void whenKeyEventDown() {
		e.setKeyCode(KeyEvent.VK_DOWN);
		assertEquals(ControllerOrder.DOWN, Frame.keyCodeToControllerOrder(e));
		e.setKeyCode(KeyEvent.VK_S);
		assertEquals(ControllerOrder.DOWN, Frame.keyCodeToControllerOrder(e));
	}

	/**
	 * The test whenKeyEventLeft
	 */
	@Test
	public void whenKeyEventLeft() {
		e.setKeyCode(KeyEvent.VK_LEFT);
		assertEquals(ControllerOrder.LEFT, Frame.keyCodeToControllerOrder(e));
		e.setKeyCode(KeyEvent.VK_Q);
		assertEquals(ControllerOrder.LEFT, Frame.keyCodeToControllerOrder(e));
	}

	/**
	 * The test whenKeyEventRight
	 */
	@Test
	public void whenKeyEventRight() {
		e.setKeyCode(KeyEvent.VK_RIGHT);
		assertEquals(ControllerOrder.RIGHT, Frame.keyCodeToControllerOrder(e));
		e.setKeyCode(KeyEvent.VK_D);
		assertEquals(ControllerOrder.RIGHT, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventSpace
	 */
	@Test
	public void whenKeyEventSpace() {
		e.setKeyCode(KeyEvent.VK_SPACE);
		assertEquals(ControllerOrder.SPACE, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventRetry
	 */
	@Test
	public void whenKeyEventRetry() {
		e.setKeyCode(KeyEvent.VK_R);
		assertEquals(ControllerOrder.RETRY, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventUpLeft
	 */
	@Test
	public void whenKeyEventUpLeft() {
		e.setKeyCode(KeyEvent.VK_A);
		assertEquals(ControllerOrder.UPLEFT, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventUpRight
	 */
	@Test
	public void whenKeyEventUpRight() {
		e.setKeyCode(KeyEvent.VK_E);
		assertEquals(ControllerOrder.UPRIGHT, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventDownLeft
	 */
	@Test
	public void whenKeyEventDownLeft() {
		e.setKeyCode(KeyEvent.VK_W);
		assertEquals(ControllerOrder.DOWNLEFT, Frame.keyCodeToControllerOrder(e));

	}

	/**
	 * The test whenKeyEventDownRight
	 */
	@Test
	public void whenKeyEventDownRight() {
		e.setKeyCode(KeyEvent.VK_C);
		assertEquals(ControllerOrder.DOWNRIGHT, Frame.keyCodeToControllerOrder(e));

	}

}