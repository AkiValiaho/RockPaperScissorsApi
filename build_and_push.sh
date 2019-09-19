#!/bin/bash
mvn clean install
if [[ "$?" -ne 1 ]] ; then
  echo 'Build is okay, pushing';
  heroku container:login
  docker build -t registry.heroku.com/rockpaperscissorsaki/web .
  docker push registry.heroku.com/rockpaperscissorsaki/web
  heroku container:release web --app rockpaperscissorsaki
  else echo "Build fails, don't push"; exit 1
fi

