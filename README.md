# Sample of clojurescript integration with nodejs and google functions

## Build

    rm target/index.js
    lein cljsbuild once functions


## Run locally (main fn)

    node target/index.js

## Simulate Google Functions locally

Install [gcloud local emulator](https://cloud.google.com/functions/docs/emulator)

Run:

    cp package.json target/package.json

    functions start
    functions deploy helloHttp --local-path=target --trigger-http # only once
    functions call helloHttp --data='{"message":"test"}'
    functions call helloHttp --data='{"message":"fail"}'
    curl -XPOST 'http://localhost:8010/[PROJECT_ID]/[REGION]/helloHttp' -d '{"message":"test"}' --header 'Content-Type: application/json'
    functions stop

## Deploy and run on Google functions

Install [gcloud sdk](https://cloud.google.com/sdk/downloads)

Run:

    cp package.json target/package.json
    gcloud beta functions deploy helloHttp --local-path target --stage-bucket [YOUR_STAGING_BUCKET_NAME] --trigger-http

    curl -XPOST "https://[REGION]-[PROJECT_ID].cloudfunctions.net/helloHttp" -d '{"message":"test"}' --header 'Content-Type: application/json'

