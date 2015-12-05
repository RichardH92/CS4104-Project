public class EndpointEvent {
	enum Type  {
		LEFT, RIGHT, TOP, BOTTOM, INTERSECT
	}

	Type type;

	Point point;
	Segment segment;

	public EndpointEvent(Point point, Segment segment, Type type) {
		this.point = point;
		this.segment = segment;
		this.type = type;
	}
}