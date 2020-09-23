#!/bin/bash
P=$1
RES=$(./wait-for-it.sh $P --timeout=5 -q)
RES=$?

if [[ $RES -eq 0 ]]; then
	java -cp /app/resources:/app/classes:/app/libs/* com.okta.developer.notes.backend.NotesBeApplicationKt
else
	echo "Unable to ping $P"
fi	
