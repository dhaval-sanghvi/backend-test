# Quotely Java Application

This application takes as an argument `English` or `Russian` and returns a quote from the forismatic API with the correct language.<br />
If a language is not specified, defaults to English.<br />
If an unsupported language Or multiple languages are specified, It Fails with Appropriate message<br />

# Mvn commands

mvn clean - Cleanup all files and directories<br />
mvn package - Creates Jar for the project<br />
mvn test -  Executes Tests<br />

# Run application
Different ways to run application <br />
1. java -jar target/quotely-1.0.0-SNAPSHOT.jar Russian

2. mvn exec:java -Dexec.mainClass=com.gremlin.quotes.GetQuotesApplication -Dexec.args="English" -q

# Example
java -jar target/quotely-1.0.0-SNAPSHOT.jar English<br />
Quote: What you do not want done to yourself, do not do to others. Be Kind!<br />
By Author: Eckhart Tolle<br />

# Tools Used
mvn 3<br />
jdk 18<br />


