public class Test_Suite {

	public static void main(String[] args) {
		System.out.println("\r\nRunning tests...\r\n");

		Test_Segment.Test_Intersection_True();
		Test_Segment.Test_Intersection_False();
		Test_Segment.Test_Intersection_Equal_Endpoints();
		Test_Segment.Test_Intersection_Overlap_Endpoint();
		Test_Segment.Test_Intersection_Same_Orientation();
		Test_Segment.Test_Is_Horizontal();
		Test_Segment.Test_Overlaps_True();
		Test_Segment.Test_Overlaps_False();
		Test_Segment.Test_Overlaps_Equal_Endpoints();
	}
}