########################################################################
#
# A simple Makefile for compiling Java code for CS392X1
#
########################################################################
JAVA=java
JAVAC=javac
########################################################################
MYCPS=.:./../../assets/algs4/algs4.jar
########################################################################
all::
all:: \
BinarySearch
all:: \
GBinarySearch
########################################################################
BinarySearch: BinarySearch.class; $(JAVA) -cp $(MYCPS) BinarySearch input.txt
BinarySearch.class: BinarySearch.java; $(JAVAC) -cp $(MYCPS) BinarySearch.java
########################################################################
GBinarySearch: GBinarySearch.class; $(JAVA) -cp $(MYCPS) GBinarySearch input.txt
GBinarySearch.class: GBinarySearch.java; $(JAVAC) -cp $(MYCPS) GBinarySearch.java
########################################################################
clean:: ; rm -f *~
########################################################################
cleanall:: clean
cleanall:: ; rm -f *.class
########################################################################
########################################################################
########################################################################
