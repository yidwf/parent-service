#!/bin/bash
export JAVA_HOME=/opt/jdk1.8.0_271
export JRE_HOME=/$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar
export PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
 
#这里可替换为你自己的执行程序，其他代码无需更改
 
APP_NAME=/data/app-eureka-server/app-eureka-server.jar
#使用说明，用来提示输入参数
usage() {
    echo "Usage: sh deploy.sh [start|stop|restart|status]"
    exit 1
}
 
#检查程序是否在运行
is_exist(){
  pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
  #如果不存在返回1，存在返回0     
  if [ -z "${pid}" ]; then
   return 1
  else
    return 0
  fi
}
 
#启动方法
start(){
  is_exist
  if [ $? -eq 0 ]; then
    echo "${APP_NAME} is already running. pid=${pid}"
  else
    nohup java -jar ${APP_NAME} -Xms32M -Xmx64M --spring.profiles.active=prod  >/dev/null 2>&1 &
  fi
}
 
#停止方法
stop(){
  is_exist
  if [ $? -eq "0" ]; then
    kill -9 $pid
    echo "${APP_NAME} has stopped !"
  else
    echo "${APP_NAME} is not running"
  fi  
}
 
#输出运行状态
status(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is running. Pid is ${pid}"
  else
    echo "${APP_NAME} is NOT running."
  fi
}
 
#重启
restart(){
  stop
  sleep 5
  start
}
 
#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  "start")
    start
    status
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    status
    ;;
  *)
    usage
    ;;
esac