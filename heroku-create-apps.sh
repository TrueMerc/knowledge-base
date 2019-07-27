#!/usr/bin/env bash

heroku apps:create knowledgebase-ui
heroku addons:create heroku-postgresql:hobby-dev --app knowledgebase-ui
heroku config:set DB_DRIVER=org.postgresql.Driver HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect --app knowledgebase-ui
heroku config:set HOST_NAME=https://knowledgebase-ui.herokuapp.com --app knowledgebase-ui

