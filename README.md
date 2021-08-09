# AOPJavaSDK
Java SDK for AOP

# Compiling
To compile the Java code in the terminal with javac, you first have to make sure that you have a Java Development Kit installed (JDK). You can check if javac is available by typing `javac --version` in your terminal and verifying that your version of javac is shown. If you do not have a JDK installed, you can get OpenJDK from their [website](https://openjdk.java.net/).

Next, you open a terminal and change your directory to the 'javaProject'-folder. If you are in the 'javaProject'-folder, you can run the following command to compile all the .java files inside the 'src'-folder into a folder called 'bin':
```bash
javac -d bin -cp \* $(find src -name '*.java')
```
The `-cp \*` includes all the .jar files in the 'javaProject'-folder.

# Creating the .jar
Once the project is compiled, a .jar file of the project can be created. This .jar file can then be used to import this Java SDK in a project. To create the .jar file of this SDK, first open a terminal and change your directory to the folder you compiled the project to (e.g. the bin-folder of the previous section). Then enter the following command to create the .jar file:

```bash
jar cvf javaProject.jar -C . .
```

# Importing
To import the project, you can use the created .jar file. Let's say you have a new file called HelloWorld.java that needs to import the PrintJob-class from this Java SDK. Inside the HelloWorld.java file you can import the PrintJob-class by typing `import com.CloudOfficePrint.Response;`. If you want to run your HelloWorld.java file, you first have to compile it. When compiling, you need to make sure to include the .jar file of this Java SDK, called javaProject.jar, like this:
```bash
javac -cp .:javaProject.jar HelloWorld.java
```
Then you can run the compiled version of your HelloWorld.java file using `java HelloWorld`.
