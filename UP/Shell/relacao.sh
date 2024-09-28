#!/bin/bash
if [ $# -ne 2 ]; then
  echo "Uso: $0 <numero1> <numero2>"
  exit 1
fi
num1=$1
num2=$2
if [ $num1 -lt $num2 ]; then
  echo "$num1 é menor que $num2"
elif [ $num1 -gt $num2 ]; then
  echo "$num1 é maior que $num2"
else
  echo "$num1 é igual a $num2"
fi
