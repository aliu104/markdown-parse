CLASSPATH = lib/*:.
# does not work in windows terminal, use ieng6!
test: MarkdownParse.class MarkdownParseTest.class #in order to run test, we need these files
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
	
MarkdownParse.class: MarkdownParse.java # to have class file, you need to compile MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

TryCommonMark.class : TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java