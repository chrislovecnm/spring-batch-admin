# Spring-Batch and Spring-Batch-Admin Remote Chunking JMS Examples

This is a simple example of how to use remote chunking.  To run the example:
* run 'mvn install' in the directory with this readme file 
* run 'mvn compile jetty:run -DENVIRONMENT=h2' in the spring-batch-admin-sample-remote-master directory
* from another command prompt run 'mvn compile jetty:run in the spring-batch-admin-sample-remote-slave directory

The starts two different jetty servers running activemq and an h2 database. The master server also has jms listeners that act as slave chunk writers as well.

To run the footballJob go to http://localhost:8080/spring-batch-admin-sample-remote/jobs/footballJob and click on the Launch button.

# Getting Started Using SpringSource Tool Suite (STS)

  This is the quickest way to get started.  It requires an internet connection for download, and access to a Maven repository (remote or local).

* Download STS version 2.5.* (or better) from the [SpringSource website](http://www.springsource.com/products/sts).  STS is a free Eclipse bundle with many features useful for Spring developers.
* Go to `File->New->Spring Template Project` from the menu bar (in the Spring perspective).
* The wizard has a drop down with a list of template projects.  One of them is a "Spring Batch Admin Webapp".  Select it and follow the wizard.
* A project is created with all dependencies and a simple input/output job configuration.  It can be run using a unit test, or on the command line (see instructions in the pom.xml).

# Getting Help

Read the main project [website](http://www.springsource.org/spring-batch-admin) and the [User Guide](http://www.springsource.org/spring-batch-admin/reference). Look at the source code and the Javadocs.  For more detailed questions, use the [forum](http://forum.springsource.org/forumdisplay.php?f=41).  If you are new to Spring as well as to Spring Batch, look for information about [Spring projects](http://www.springsource.org/projects).

# Contributing to Spring Batch Admin

Here are some ways for you to get involved in the community:

* Get involved with the Spring community on the Spring Community Forums.  Please help out on the [forum](http://forum.springsource.org/forumdisplay.php?f=41) by responding to questions and joining the debate.
* Create [JIRA](https://jira.springsource.org/browse/BATCHADM) tickets for bugs and new features and comment and vote on the ones that you are interested in.  
* Github is for social coding: if you want to write code, we encourage contributions through pull requests from [forks of this repository](http://help.github.com/forking/).
* Watch for upcoming articles on Spring by [subscribing](http://www.springsource.org/node/feed) to springframework.org

Before we accept a non-trivial patch or pull request we will need you to sign the [contributor's agreement](https://support.springsource.com/spring_committer_signup).  Signing the contributor's agreement does not grant anyone commit rights to the main repository, but it does mean that we can accept your contributions, and you will get an author credit if we do.  Active contributors might be asked to join the core team, and given the ability to merge pull requests.
