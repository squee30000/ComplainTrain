#!/bin/bash
export PATH_TO_FX=/home/ben/openjfx-11.0.2_linux-x64_bin-sdk/javafx-sdk-11.0.2/lib
javac --module-path $PATH_TO_FX --add-modules javafx.controls $1
java --module-path $PATH_TO_FX --add-modules javafx.controls $2
