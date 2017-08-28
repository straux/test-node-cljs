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
    functions stop

