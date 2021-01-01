#!/usr/bin/env bash
javac LevelGenerator.java && java LevelGenerator
find . -name "*.class" -delete
#javadoc -d ../doc levelpack pack
