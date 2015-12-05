import java.util.*;

public class EndpointEvent {

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

	public String toString() {
		return type.toString() + " EndpointEvent\ny-coord: " + point.get_y_coord();
	}
}