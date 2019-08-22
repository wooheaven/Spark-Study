#!/bin/bash

# for with file
while read line
do
	# echo
echo "line as String = "$line
echo ""

	# save values to variables from a file
oldStr=`echo $line | awk 'BEGIN{FS=OFS=" "} {print $1}'`
newStr=`echo $line | awk 'BEGIN{FS=OFS=" "} {print $3}'`
	
	# check variables
echo "oldStr = "$oldStr
echo "newStr = "$newStr
	
	# grep $oldStr
grep $oldStr README.md
grep $oldStr README.md | sed -e "s|$oldStr|$newStr|"
echo ""

	# modify
sed -i'' -e "s#${oldStr}#${newStr}#" README.md
	
	# final
unset oldStr
unset newStr

done < ./99_Utility/change_A_to_B.txt

if [ -f ./README.md-e ]; then 
rm -rf ./README.md-e
fi
