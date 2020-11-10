#!/bin/bash
jdbc:postgresql://db:5432/notes_db

.*://[.*:\d{4,5}]/.*

echo 'jdbc:postgresql://db:5432/notes_db' | grep -o '.*://[.*]:5432/.*'
echo 'jdbc:db:5432/notes_db' | grep -o '.*:[.*]:5432/.*'


postgres://rvwxqhvtvwgqmv:0c43a8597dd04d7efe966ffc64a0892d787e07d4151242109c2c204afb701772@ec2-107-21-109-15.compute-1.amazonaws.com:5432/d4fq7bp9lrok90