#!/bin/bash
heroku container:login
heroku container:push web --app rockpaperscissorsaki
heroku container:release web --app rockpaperscissorsaki
