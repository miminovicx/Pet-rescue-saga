#!/usr/bin/env bash
javac Test.java && java Test
find . -name "*.class" -delete
javadoc -d ../doc levelpack pack
