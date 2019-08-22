#!/bin/bash
# checking network connectivity


# IPs and ports to check
# Ignore blank lines and treat hash sign as comments
# comments will be kept as a comment of result
IP_PORT="

# local host 
127.0.0.1 2000
127.0.0.1 21

# well known sites
www.google.com 80
www.baidu.com 80
"

# checking
echo "$IP_PORT" | grep -Ev "^$" |
while read line;do
  # simply print comment line
  echo "$line" | grep -qE "^#"
  if [ $? -eq 0 ];then
	  echo "$line"
	  continue
  fi

  # normal line with ip and port
  connectFlag="DOWN"
  ip=$(echo $line | awk '{print $1}')
  port=$(echo $line | awk '{print $2}')
  (echo > /dev/tcp/$ip/$port) >/dev/null 2>&1
  if [ $? -eq 0 ];then
    connectFlag="UP"
  fi

  printf "%-20s %5s %5s\n" $line $connectFlag
done
