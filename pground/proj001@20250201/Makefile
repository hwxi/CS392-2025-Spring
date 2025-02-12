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
#
# all::
# all:: Hello
# all:: Flips
# all:: MyHello
# all:: ForEach
# all:: MyIterable
#
########################################################################

Hello: \
Hello.class; \
$(JAVA) -cp $(MYCPS) Hello
Hello.class: Hello.java; \
$(JAVAC) -cp $(MYCPS) Hello.java

########################################################################

Flips: \
Flips.class; \
$(JAVA) -cp $(MYCPS) Flips 1000
Flips.class: Flips.java; \
$(JAVAC) -cp $(MYCPS) Flips.java

########################################################################

ForEach: \
ForEach.class; $(JAVA) ForEach
ForEach.class: \
ForEach.java; $(JAVAC) ForEach.java

########################################################################

MyIterable: \
MyIterable.class; $(JAVA) MyIterable
MyIterable.class: \
MyIterable.java; $(JAVAC) MyIterable.java

########################################################################

MyHello: \
bucascs392x1/MyHello.class; \
$(JAVA) -cp $(MYCPS) bucascs392x1.MyHello hwxi
bucascs392x1/MyHello.class: \
MyHello.java; $(JAVAC) -cp $(MYCPS) -d . MyHello.java

########################################################################
########################################################################
clean:: ; rm -f *~
########################################################################
cleanall:: clean
cleanall:: ; rm -f *.class
cleanall:: ; rm -f bucascs392x1/*.class
########################################################################
########################################################################
########################################################################
