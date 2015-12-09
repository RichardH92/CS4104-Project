import java.util.*;

public class main {
	public static void main(String[] args) {
		Graph test = new Graph();

		Brute_Force_Solver s = new Brute_Force_Solver();


		//System.out.println("Segments:\n" + test.toString());

		System.out.println("\n\nBrute-force intersection Points:");

		List<Point> i_points = s.solve(test);

		/*for (int i = 0; i < i_points.size(); i++) {
			System.out.println(i_points.get(i).toString());
		}*/
		System.out.println("\nNumber of intersection points: " + i_points.size());

		System.out.println("\n\n");

		System.out.println("Our intersection points: ");
		Algo_Solver solver = new Algo_Solver(test);
		List<Point> i_points_two = solver.find_intersection_points();

		/*for (int i = 0; i < i_points_two.size(); i++) {
			System.out.println(i_points_two.get(i).toString());
		}*/
		System.out.println("\nNumber of intersection points: " + i_points_two.size());
	}
}
