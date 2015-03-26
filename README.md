SeAuto Cucumber Sample Project
======

Introduction
------
This project is intended to be a template project for those wanting to quickly
implement and use SeAuto for Cucumber.

## Setup instructions


#### Prerequisites: 
* Download and install the [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/) 
* Download and install [Apache Maven](http://maven.apache.org/download.cgi) 
  * Any version on that page will work if you have a preference
* Firefox, for the demo to run

#### Run:

This repository and the SeAuto repo need to be cloned.
SeAuto will need to run a `mvn clean install` in the home directory to install it's package into your local repo

#### To build the archetype:
````bash
mvn archetype:create-from-project
cd target/genrated-sources/archetype
mvn install
cd /to/new/project/dir
mvn archetype:generate -DarchetypeCatalog=local
````
Then follow the instructions inserting your GroupId, etc..

#### To run this project or the built archetype
To run:

`mvn clean integration-test`
You should see a firefox browser launch, go to Bing.com and search for Partnet, verifying Partnet is in the search results

After the tests run, the reports are located in`target/surefire-reports` in regular junit test format

### Run with other browsers
The other driver binaries can be downloaded and placed in the correct location by using the seauto-driver-manager plugin

Execute the following command to download the appropriate drivers for your current operating system:

```
mvn com.partnet:seauto-driver-manager:download
```

After that, run the tests with the following command, as found in the [Configuration](http://mercury.part.net/WebContent/#/configuration) section of the documentation:

```
mvn clean integration-test -Dtest.config.browser=<your browser, eg. IE>
```

To run each test with it's own browser type, see [Create Tests](http://mercury.part.net/WebContent/#/createTests)

## Documentation
Please see the [documentation](http://mercury.part.net/WebContent/#/getStarted)