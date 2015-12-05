import java.util.*;

public class EndpointEvent implements Comparable<EndpointEvent> {

	Type type;

	Point point;
	Segment segment;

	public EndpointEvent(Point point, Segment segment, Type type) {
		this.point = point;
		this.segment = segment;
		this.type = type;
	}

	public Type getType(){
		return type; 
	}

	@Override 
	public int compareTo(EndpointEvent otherEndpointEvent) {
		if (this.point.get_x_coord() > otherEndpointEvent.point.get_x_coord()) {
			return 1;
		}
		else if (this.point.get_x_coord() < otherEndpointEvent.point.get_x_coord()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}