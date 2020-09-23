#!/bin/bash
P=$1
RES=$(./wait-for-it.sh $P --timeout=5 -q)
RES=$?
#echo $RES
if [[ $RES -eq 0 ]]; then
	java --version
else
	echo "Unable to ping $P"
fi	
