Run the tests like this:

For Chrome browser (Chrome set by default):
```
mvn clean test  OR
mvn clean test -Dwebdriver.driver=chrome
```

For Firefox browser:
```
mvn clean test -Dwebdriver.driver=firefox
```

The reports will be generated in `target/site/out`
