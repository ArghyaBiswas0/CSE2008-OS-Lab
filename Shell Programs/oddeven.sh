#check if a number is even or odd

echo "Enter a Number:"
read n
rem=$(( $n % 2 ))
if [ $rem -eq 0 ]
then
	echo "Number is even"
else
	echo "Number is odd"
fi