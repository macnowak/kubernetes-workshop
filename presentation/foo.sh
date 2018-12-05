#!/usr/bin/env bash

wget --output-document=reveal.js.tar.gz https://github.com/hakimel/reveal.js/archive/3.7.0.tar.gz && tar -xvzf reveal.js.tar.gz && cp -R ./reveal.js-3.7.0/* . && rm reveal.js.tar.gz && rm -Rf reveal.js-3.7.0