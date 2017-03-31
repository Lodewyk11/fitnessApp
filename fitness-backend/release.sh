#!/bin/bash -e

RELEASE_VERSION=$1

MODULES=$(ls -d */)


echo 'Releasing backend version '$RELEASE_VERSION'....'

for MODULE in $MODULES; do
	echo 'Releasing '${MODULE: : -1}
	cd $MODULE
	mvn versions:set -DnewVersion=$RELEASE_VERSION
	cd $(pwd)/..
done
