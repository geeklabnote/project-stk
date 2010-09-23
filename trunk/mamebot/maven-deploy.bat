cd %0\..
cmd /k mvn deploy:deploy-file -DgroupId=bufferings -DartifactId=ktrwjr -Dversion=1.0.0 -Dpackaging=jar -Dfile=./repo/ktrwjr.jar -Durl=file:repo