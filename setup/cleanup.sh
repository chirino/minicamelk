#!/bin/bash
oc delete camelsource bodytemperature-source
oc get pods | grep broker | cut -d ' ' -f 1 | xargs -n 1 oc delete pod