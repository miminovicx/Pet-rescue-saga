#!/usr/bin/env bash
javac LevelCreator.java && java LevelCreator
find . -name "*.class" -delete
# javadoc -d ../doc levelpack pack gui
