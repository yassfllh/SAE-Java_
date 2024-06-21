rm -rf build

mkdir -p build

javac -d build -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/main/*.java

javac -d build -cp build:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/test/*.java

java -cp build:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore AthleteTest CompetitionCollectiveTest CompetitionIndividuelleTest EpreuveTest EquipeTest JeuxOlympiquesTest PaysTest
