#!/bin/bash

# basic config
config()
{
    echo "config ok."
}

# move the *.ts to the same folder.
step1()
{
    a=`find -name "*.ts"`
    for i in ${a[*]}
    do 
        \cp -f $i "./"
    done
    echo "step1 ok."
}

# create temp out.txt.
step2()
{
    a=`find -name "*.ts"`
    for i in ${a[@]}
    do
        echo $i >> out.txt
    done
}

# process out.txt.
step3()
{
    cat out.txt | grep --color "[0-9]*.ts" -o > tmp.txt
    sort -nu tmp.txt > out.txt

    sed "s/^/file '&/g" out.txt > tmp.txt
    sed "s/$/'&/g" tmp.txt > out.txt
}

# use ffmpeg to merge *ts to mp4.
step4()
{
    ffmpeg -f concat -i out.txt -c copy out.mp4
}

# clean temp file.
step5()
{
    rm *.ts
    rm *.txt
}

# the main function
main()
{
    # config;
    step1;
    step2;
    step3;
    step4;
    step5;
}

# do it. go go go.
main;