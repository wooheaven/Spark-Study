#! /bin/bash

ls -l \
| grep "^d" \
| awk 'BEGIN{FS=OFS=" "} {if(NF > 8) print $9; next}' \
| cat -n \
| sed -e 's/ //g' \
| awk 'BEGIN{FS=OFS="\t"} {if(length($1) < 2) print 0$1,$2 ;else print $0}' \
| awk 'BEGIN{FS="\t"; OFS=" "} {print "git mv", $2"/", $1"_"substr($2, 4)"/" }' \
> git-move.sh

chmod +x git-move.sh
