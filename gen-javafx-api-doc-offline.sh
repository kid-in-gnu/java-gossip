#!/bin/bash

## purpose: practising javadoc cli, generate the javadoc offline
## tested in git bash ONLY

PREFIX=jfx
VERSION=21.0.9
SOURCE="${PREFIX}-${VERSION}"
OUTPUT="${PREFIX}-${VERSION}_api"

mkdir $SOURCE $OUTPUT

## src.zip here is a zipped file downloaded from https://gluonhq.com/products/javafx/, inside javafx sdk
unzip src.zip -d $SOURCE

MODULES=`ls $PREFIX-$VERSION`
MODULE_OPTIONS=

for m in $MODULES
do
    MODULE_OPTIONS="${MODULE_OPTIONS} --module ${m}"
done

STR="javadoc -d $OUTPUT --module-source-path $SOURCE $MODULE_OPTIONS -tag moduleGraph,implSpec"

## e.g. javadoc -d jfx-21.0.9_API --module-source-path jfx-21.0.9 --module javafx.base --module javafx.controls --module javafx.fxml --module javafx.graphics --module javafx.media --module javafx.swing --module javafx.web -tag moduleGraph,implSpec
# skipped the custom tags for not generating the errors
javadoc -d $OUTPUT --module-source-path $SOURCE $MODULE_OPTIONS -tag moduleGraph,implSpec

# echo $STR