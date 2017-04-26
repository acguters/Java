#Makefile 
#Makefile creating and testing executable made in ASG8
#Special Instructions type “make test” to create and test executable, or type “make #clean” to remove class files or type “make spotless” to clean everything.

JAVASRC    = xref.java auxlib.java Tree.java Queue.java
SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = xref
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

all: ${CLASSES}

%.class: %.java
	javac -Xlint $<

clean:
	rm -f *.class

test: all
	java xref test.txt

.PHONY: clean all test
