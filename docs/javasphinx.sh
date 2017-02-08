#!/bin/bash
# Script to generate Javadoc output for sphinx with javasphinx-apidoc

TITEL="ManagementBinaryTress"
SOURCE="../src/main/java/"

##############################################################
#                        do not edit                         #
##############################################################

# convert javadoc to rst files
javasphinx-apidoc -o source/ --title=$TITEL $SOURCE -u

# convert source to build files
make html
make epub
make epub3
make man
make latex
make latexpdf


exit 0