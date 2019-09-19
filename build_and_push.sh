#!/bin/bash
mvn clean install
if [[ "$?" -ne 1 ]] ; then
  echo 'Build is okay, pushing';
  heroku container:login
  heroku container:push web --app rockpaperscissorsaki
  heroku container:release web --app rockpaperscissorsaki
  else echo "Build fails, don't push"; exit $rc
fi

