# emailaddress

Scala micro-library for typing, validating and obfuscating email addresses.

## Address Typing & Validation

The `EmailAddress` class will only accept valid addresses:

```scala
scala> import uk.gov.hmrc.emailaddress._
import uk.gov.hmrc.emailaddress._

scala> EmailAddress("example@test.com")
res0: uk.gov.hmrc.emailaddress.EmailAddress = example@test.com

scala> EmailAddress("not_a_meaningful_address")
java.lang.IllegalArgumentException: requirement failed: 'not_a_meaningful_address' is not a valid email address
```

You can also use `EmailAddress.isValid(...)`:

```scala
scala> EmailAddress.isValid("example@test.com")
res2: Boolean = true

scala> EmailAddress.isValid("not_a_meaningful_address")
res3: Boolean = false
```

## Accessing the domain and mailbox

You can access the mailbox and domain of a given address:

```scala
scala> EmailAddress("example@test.com").domain
res0: uk.gov.hmrc.emailaddress.EmailAddress.Domain = test.com

scala> EmailAddress("example@test.com").mailbox
res1: uk.gov.hmrc.emailaddress.EmailAddress.Mailbox = example
```

These compare equal as you might expect:

```scala
scala> EmailAddress("example@test.com").domain == EmailAddress("another@test.com").domain
res2: Boolean = true

scala> EmailAddress("example@test.com").domain == EmailAddress("another@test.co.uk").domain
res3: Boolean = false
```

## Obfuscation

Addresses are obfuscated by starring out all of their mailbox part, apart from the first and last letters:

```scala
scala> ObfuscatedEmailAddress("example@test.com")
res4: uk.gov.hmrc.emailaddress.ObfuscatedEmailAddress = e*****e@test.com
```

Unless there are only two letters:

```scala
scala> ObfuscatedEmailAddress("ex@test.com")
res7: uk.gov.hmrc.emailaddress.ObfuscatedEmailAddress = **@test.com```

```

You can also create them directly from an `EmailAddress`:

```scala
scala> EmailAddress("example@test.com").obfuscated
res6: uk.gov.hmrc.emailaddress.ObfuscatedEmailAddress = e*****e@test.com
```

## Converting back to `String`

All classes `toString` and implicitly convert to `String`s nicely:

```scala
scala> val someString: String = EmailAddress("example@test.com")
someString: String = example@test.com

scala> val someString = EmailAddress("example@test.com").toString
someString: String = example@test.com

scala> val someString: String = ObfuscatedEmailAddress("example@test.com")
someString: String = e*****e@test.com

scala> val someString = ObfuscatedEmailAddress("example@test.com").toString
someString: String = e*****e@test.com

scala> EmailAddress("example@test.com").domain.toString
res4: String = test.com

scala> val s: String = EmailAddress("example@test.com").domain
s: String = test.com

scala> EmailAddress("example@test.com").mailbox.toString
res5: String = example

scala> val s: String = EmailAddress("example@test.com").mailbox
s: String = example
```

## Install

### Prerequisit

* [sbt-1.6.1](https://www.scala-sbt.org/)
* [OpenJDK 17.0.1](https://openjdk.java.net/)

Note, [GraalVM Community Edition 21.3.0](https://www.graalvm.org/) also supported.

### Build

Currently, you need to use ["publishLocal" feature](https://www.scala-sbt.org/1.x/docs/Publishing.html#Publishing+locally) of SBT.

1. Clone from [GitHub](https://github.com/FomalhautWeisszwerg/emailaddress.git)

```shell
git clone https://github.com/FomalhautWeisszwerg/emailaddress.git
```

2. Build with `sbt`

```shell
sbt -java-home ${JAVA_HOME} compile
```

3. Running tests

```shell
sbt -java-home ${JAVA_HOME} test
```

4. Publish to the local

```shell
sbt -java-home ${JAVA_HOME} publishLocal
```

Now, `emailaddress` has been installed in ${HOME}/.ivy2/local directory as following:

```shell
$ LANG=C tree ${HOME}/.ivy2
/home/fomalhaut/.ivy2
`-- local
    `-- emailaddress
        `-- emailaddress_2.13
            `-- 0.1.0-SNAPSHOT
                |-- docs
                |   |-- emailaddress_2.13-javadoc.jar
                |   |-- emailaddress_2.13-javadoc.jar.md5
                |   `-- emailaddress_2.13-javadoc.jar.sha1
                |-- ivys
                |   |-- ivy.xml
                |   |-- ivy.xml.md5
                |   `-- ivy.xml.sha1
                |-- jars
                |   |-- emailaddress_2.13.jar
                |   |-- emailaddress_2.13.jar.md5
                |   `-- emailaddress_2.13.jar.sha1
                |-- poms
                |   |-- emailaddress_2.13.pom
                |   |-- emailaddress_2.13.pom.md5
                |   `-- emailaddress_2.13.pom.sha1
                `-- srcs
                    |-- emailaddress_2.13-sources.jar
                    |-- emailaddress_2.13-sources.jar.md5
                    `-- emailaddress_2.13-sources.jar.sha1

9 directories, 15 files
```

## Import

After installation, add the following dependency in your build.sbt

```scala
libraryDependencies += "default" %% "emailaddress" % "0.1.0-SNAPSHOT"
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
