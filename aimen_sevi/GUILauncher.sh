#!/usr/bin/env bash
javac GraphicalInterface.java && java GraphicalInterface
find . -name "*.class" -delete
#javadoc -d ../doc levelpack gui environment_player_pack
