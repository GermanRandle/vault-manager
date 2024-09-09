### [v1.1] Technical debt after v1

- revise ALL files
- delete duplicatesStrategy from build.gradle's?
- delete exposes from dockerfiles?
- Shared `build.gradle` files for microservices
- Upgrade Kotlin to 2.0.10+
- What's the value of Gradle's `group` and `version`?
- Exception logging (with stacktrace)
- Docker optimization – don't copy unnecessary files
- Docker optimization – don't run daemon?
- minimize copypaste
- use latest jdk?

### [v2] Feature: vault validation

- Define basic entities
- Introduce invariants
- Validate directory structure
- How to write tests
- Validate business ids
- Routine checks

## Ideas for future

- Days creation (+mutation grpc service)
- Routines auto-creation
- Dead links tracking
- CI (automatic testing + linting)
- Notifications to Telegram (new MS + Kafka)
- Regular reminders (new MS)
- Backups, auto-backups
- Statistics service
- Control over processes (in inspection service)
