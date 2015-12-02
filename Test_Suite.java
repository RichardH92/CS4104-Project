public class Test_Suite {

	public static void main(String[] args) {
		
		if (!Test_Segment.Test_Segment_Intersections())
			System.out.println("Fail 1\r\n");
		
		if (!Test_Segment.Test_Is_Horizontal())
			System.out.println("Fail 2\r\n");
	}
}