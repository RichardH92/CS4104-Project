public class IntersectEvent extends EndpointEvent {
	Segment i_segment;

	public IntersectEvent(Point point, Segment segment, Type type, Segment i_segment) {
		super(point, segment, type);
		
		this.i_segment = i_segment;
	}
}