# sql-provider
Build plugins easily using sql-provider for criar databases easily

# Use example
_Connecting to database_
```java
public static void main(String[] args) {
    DatabaseFactory databaseFactory = new DatabaseFactory(DatabaseType.SQLITE);
    databaseFactory.setFile(new File("database.sql"));
    databaseFactory.connect();
}
```
_Creating table in database_
```java
public static void main(String[] args) {
    DatabaseFactory databaseFactory = new DatabaseFactory(DatabaseType.SQLITE);
    databaseFactory.setFile(new File("database.sql"));
    databaseFactory.connect();
    databaseFactory.execute("CREATE TABLE IF NOT EXISTS Test (Example VARCHAR(16))");
}
```
_Disconnect from database_
```java
public static void main(String[] args) {
    DatabaseFactory databaseFactory = new DatabaseFactory(DatabaseType.SQLITE);
    databaseFactory.setFile(new File("database.sql"));
    databaseFactory.disconnect();
}
```
