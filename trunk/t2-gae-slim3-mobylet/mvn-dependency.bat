cd %0\..
cmd /k mvn eclipse:clean eclipse:eclipse generate-sources -DdownloadSources=true -DdownloadJavadocs=true
