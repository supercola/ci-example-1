# CHANGEME application
This project has configuration and script files for AWS CodeDeploy and Docker environment.
If you want to use Docker environment, please modify **CHANGEME** stuff in the docker configuration files, __CHANGEME-dev.json and CHANGEME-prod.json__ including the filename themselves.

And also you should provide proper name about the application.
* Change the main package name if you mind to use *simple*
* Change the application title and description defined in __application.yml__ shown in the swagger file.

Basically you can see the swagger in all environment.
To control the swagger visibility, change the spring profile value in application.yml.

This is Spring profile based application.
To run it correctly, you must specify the default profile.
