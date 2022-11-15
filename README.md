# Reproducer for behavior mentioned in [this quarkus issue][0]

## How to see intended application behavior without errors

1. Run with `quarkus dev`.
2. Visit the `/hello` endpoint.

Each time a `GET` is made to `/hello`, a h2 database is created and one `Greeting` record is placed in it.
The database files will be created in the root directory of this repository.

## How to reproduce error that prevents application from starting

1. Build with `quarkus build`.
2. Run `java -jar target/quarkus-app/quarkus-run.jar`.

See error:
> Model classes are defined for the default persistence unit <default> but configured datasource <default> not found:
> the default EntityManagerFactory will not be created. To solve this, configure the default datasource.
> Refer to https://quarkus.io/guides/datasource for guidance.

## To get rid of the error

1. Uncomment the commented-out configuration property in application.properties
2. Build with `quarkus build`.
3. Run `java -jar target/quarkus-app/quarkus-run.jar`

[0]: https://github.com/quarkusio/quarkus/issues/29269
