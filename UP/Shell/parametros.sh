#!/bin/bash
i=1
for param in "$@"; do
    echo "Parâmetro $i: $param"
    i=$((i + 1))
done
