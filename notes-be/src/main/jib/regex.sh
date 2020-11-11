#!/bin/bash

input="postgres://rvwxqhvtvwgqmv:0c43a8597dd04d7efe966ffc64a0892d787e07d4151242109c2c204afb701772@ec2-107-21-109-15.compute-1.amazonaws.com:5432/d4fq7bp9lrok90"


strname="jdbc:postgresql://127.0.0.1:5432/notes_db"
if [[ $input =~ .*//(.+):5432.* ]]; then
    echo "result: ${BASH_REMATCH[1]}"
else
    echo "unable to parse string $strname"
fi


#postgres://rvwxqhvtvwgqmv:0c43a8597dd04d7efe966ffc64a0892d787e07d4151242109c2c204afb701772@ec2-107-21-109-15.compute-1.amazonaws.com:5432/d4fq7bp9lrok90