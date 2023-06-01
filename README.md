# jasker

[![Maven Central](http://img.shields.io/maven-central/v/io.github.teuton-software/jasker)](https://search.maven.org/artifact/io.github.teuton-software/jasker)
[![GPL-3.0](https://img.shields.io/badge/license-GPL--3.0-%250778B9.svg)](https://www.gnu.org/licenses/gpl-3.0.html)

All-in-one Java wrapper for [asker](https://rubygems.org/gems/asker-tool) Ruby gem (using JRuby).

## Using the library with Maven

```xml
<dependency>
    <groupId>io.github.teuton-software</groupId>
    <artifactId>jasker</artifactId>
    <version>{jasker.version}</version>
</dependency>
```

## Using the with Gradle

```groovy
implementation 'io.github.teuton-software:jasker:{jasker.version}'
```

## Upgrade Ruby gems

`jasker` depends on some Ruby gems: `asker-tool`.

### Install Ruby gems

```bash
mvn exec:exec@install-rubygems
```

### Uninstall Ruby gems

```bash
mvn clean:clean@uninstall-rubygems
```

> Also deletes `target`directory.

### Reload all Ruby gems

```bash
mvn clean:clean@uninstall-rubygems exec:exec@install-rubygems
```

## Usage examples

Import `Asker` class:

```java
import io.github.teuton.jasker.Asker;
```

#### Get Asker version

Code:

```java
System.out.println(Asker.execute("version"));
```

or

```java
System.out.println(Asker.version());
```

Output:

```
X.Y.Z
```

## How to build and install to your local Maven repo

Clone the repo and change to its directory:

```bash
git clone https://github.com/teuton-software/jasker.git
cd jasker
```

Download and install Ruby gem (`asker-tool`) into `src/main/resources`:

```bash
mvn exec:exec@install-rubygems
```

Build, package and install the JAR library into your local Maven repo:

```bash
mvn install
```

## How to release to Maven Central


```bash
mvn deploy
```
