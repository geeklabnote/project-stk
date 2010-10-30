cd %0\..
cmd /k mvn deploy:deploy-file -DgroupId=com.google.gwt -DartifactId=gwt-servlet -Dversion=2.1.0 -Dpackaging=jar -Dfile=./repo/gwt-servlet.jar -Durl=file:repo