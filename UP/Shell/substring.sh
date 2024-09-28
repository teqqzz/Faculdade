#!/bin/bash
if [ $# -ne 2 ]; then
    echo "Uso: $0 palavra1 palavra2"
    exit 1
fi
if echo "$2" | grep -q "$1"; then
    echo "$1 está contida em $2"
else 
    echo "$1 não está contida em $2"
fi
