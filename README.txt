javac -d build -cp lib/junit-4.13.2.jar src/main/main/*.java src/test/*.java

java -cp build:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore test.AthleteTest test.CompetitionCollectiveTest test.CompetitionIndividuelleTest test.EpreuveTest test.EquipeTest test.JeuxOlympiquesTest test.PaysTest


Dans le fichier launch.json (si inexistant créer dans le dossier .vscode) :
tout effacer et copier-coller les commandes suivantes :

{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "ApplicationPrincipale",
            "request": "launch",
            "mainClass": "main.ApplicationPrincipale",
            "vmArgs": "--module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml",
            "projectName": "SAE-Java_-main_97cdb72b"
        },
        {
            "type": "java",
            "name": "Launch Program",
            "request": "launch",
            "mainClass": "main.ApplicationPrincipale",
            "vmArgs": "--module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml",
            "cwd": "${workspaceFolder}",
            "projectName": "SAE-Java-JO-main"
        }         
    ]
}