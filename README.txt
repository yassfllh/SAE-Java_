javac -d build -cp lib/junit-4.13.2.jar src/main/main/*.java src/test/*.java

java -cp build:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore test.AthleteTest test.CompetitionCollectiveTest test.CompetitionIndividuelleTest test.EpreuveTest test.EquipeTest test.JeuxOlympiquesTest test.PaysTest
