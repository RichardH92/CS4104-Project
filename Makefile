classes = trees/AVLTree.java Point.java Segment.java Graph.java Brute_Force_Solver.java EndpointEvent.java Algo_Solver.java EndpointEvent.java Type.java EndpointComparator.java IntersectEvent.java
tests = Test_Suite.java Test_Segment.java Temp_Tests.java

Make:
	javac main.java $(classes)

test:
	javac $(classes) $(tests)
	java Test_Suite

run:
	javac main.java $(classes)
	java main

clean:
	rm *.class
