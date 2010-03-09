cd %0\..
cmd /k mvn deploy:deploy-file -Durl=file:repo -Dfile=.\lib\t2-slim3-gen-0.1-SNAPSHOT.jar -DgroupId=org.t2framework.slim3 -DartifactId=t2-slim3-gen -Dversion=0.1-SNAPSHOT -Dpackaging=jar
rem cmd /k mvn deploy:deploy-file -Durl=file:repo -Dfile=D:\usr\local\eclipse\workspace\t2-gae-mobylet\lib\slim3-EA1-SNAPSHOT.jar -DgroupId=slim3 -DartifactId=slim3 -Dversion=EA1-SNAPSHOT -Dpackaging=jar
