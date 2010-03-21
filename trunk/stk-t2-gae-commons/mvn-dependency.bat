cd %0\..
cmd /k mvn clean eclipse:eclipse dependency:copy-dependencies -DdownloadSources=true -DdownloadJavadocs=true
