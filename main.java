import java.util.*;

public class main {
	public static void main(String[] args) {
		Graph test = new Graph();

		Brute_Force_Solver s = new Brute_Force_Solver();


		System.out.println("Segments:\n" + test.toString());

		System.out.println("Intersection Points:");

		List<Point> i_points = s.solve(test);

		for (int i = 0; i < i_points.size(); i++) {
			System.out.println(i_points.get(i).toString());
		}
	}
}
