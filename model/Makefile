args = -ea

Matrix.class: Matrix.java
	javac Matrix.java

.PHONY: run clean

run: Matrix.class
	java ${args} Matrix

clean:
	@find . -type f -name *.class -exec rm '{}' +
