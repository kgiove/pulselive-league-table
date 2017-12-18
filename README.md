# Java​ ​Development​ ​Task​ ​-​ ​League​ ​Table
 
Scenario
----------

The​ ​purpose​ ​of​ ​this​ ​exercise​ ​is​ ​to​ ​demonstrate​ ​your​ ​ability​ ​to​ ​use​ ​Java​ ​to​ ​build​ ​a dynamic​ ​football​ ​league​ ​table​ ​generator. LeagueTableEntry​ ​objects​ ​are​ ​sorted​ ​by​ ​points,​ ​goal​ ​difference,​ ​goals​ ​for​ ​and​ ​then team​ ​names.​ ​The​ ​normal​ ​rules​ ​for​ ​scoring​ ​points​ ​apply. 

In​ ​undertaking​ ​this​ ​task,​ ​​please​ ​consider​ ​the​ ​following:
 
- You​ ​should​ ​be​ ​submitting​ ​production​ ​quality​ ​code 
- Future​ ​reuse​ ​and​ ​extension​ ​of​ ​code
- Any​ ​documentation​ ​/ notes​ ​on​ ​build

 
## Architecture
 - Maven project, using Java8, JUnit
    
## Tests
 - Created unit tests to cover all functions and calls
 ```
 <root project>/mvn clean install
 ```
 
## Running
Unit tests
```
<root project>/mvn clean install
```

To run the application, we can use the following command.
```
<root project>/mvn exec:java -Dexec.mainClass="com.pulselive.league.Main"
```

The code above generates the following result.
In the main class a list of matches have been passed as input. ​Each​ ​team​ ​plays​ ​a​ ​number​ ​of​ ​matches​ ​and​ ​the results​ ​of​ ​each​ ​match​ ​build​ ​that​ ​table. At the end, LeagueTableEntry​ ​objects​ ​are​ ​sorted​ ​by​ ​points,​ ​goal​ ​difference,​ ​goals​ ​for​ ​and​ ​then team​ ​names.​ ​The​ ​normal​ ​rules​ ​for​ ​scoring​ ​points​ ​apply. 
```

[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building pulselive-league-table 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ pulselive-league-table ---

-----------------------------
Premier League Table
-----------------------------
       Position           Team         Played            Won          Drawn           Lost      Goals For  Goals Against     Goal Difference         Points
              1        Man Utd              3              3              0              0              6              3                   3              9
              2          Spurs              3              2              0              1              5              4                   1              6
              3      Liverpool              2              2              0              0              4              2                   2              6
              4     Stoke City              4              1              0              3              5              7                  -2              3
              5    Bournemouth              1              1              0              0              2              1                   1              3
              6        Chelsea              3              0              0              3              3              6                  -3              0
              7        Arsenal              1              0              0              1              1              2                  -1              0
              8       Man City              1              0              0              1              1              2                  -1              0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```