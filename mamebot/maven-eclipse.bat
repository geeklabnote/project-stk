cd %0\..
cmd /k mvn clean eclipse:clean eclipse:eclipse process-sources -DdownloadSources=true -DdownloadJavadocs=true -Derror.skip=true
