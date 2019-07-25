package katas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.SurfaceAreAndolumeOfaBoxApp;

public class SurfaceAreAndolumeOfaBoxTest {

	@Test
	public void testSize() {
		final SurfaceAreAndolumeOfaBoxApp testObject = new SurfaceAreAndolumeOfaBoxApp();
		 assertEquals(new int[] {1, 1}, testObject.getSize(1, 1, 1));
	}

}
