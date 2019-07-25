package katas;

public class SurfaceAreAndolumeOfaBoxApp {

	public int[] getSize(int width , int height , int distance) {
		
		final int area= 2*(distance*height+height*width+width*distance);
		final int volume= width*height*distance;
		
		return new int[] {area, volume};
    }
	
}
