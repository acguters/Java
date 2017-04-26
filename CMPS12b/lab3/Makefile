#Makefile to compile greet.java and greetings.java, new phony targets and to rungreet and greetings
JAVASRC = greet.java greetings.java
SOURCES = README Makefile ${JAVASRC}
MAINCLASS = greet greetings
CLASSES = greet.class greetings.class
JARCLASSES = ${CLASSES}

all: ${CLASSES}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

clean:
	rm ${CLASSES}
 
runGreet:
	java greet

runGreetings:
	java greetings

.PHONY: runGreet runGreetings clean all

