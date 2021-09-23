args = -ea

Network.class: Network.java Matrix.class
	javac Network.java

Matrix.class: Matrix.java
	javac Matrix.java

.PHONY: clean test

test: Matrix.class Network.class
	java ${args} Matrix
	java ${args} Network

clean:
	@find . -type f -name "*.class" -exec rm '{}' +
