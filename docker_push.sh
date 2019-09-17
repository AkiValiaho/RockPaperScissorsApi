#!/bin/bash
heroku container:login
docker build -t com.akivaliaho:built .
docker tag com.akivaliaho:built registry.heroku.com/rockpaperscissorsaki
docker push registry.heroku.com/rockpaperscissorsaki