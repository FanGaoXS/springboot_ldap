# Centos7配置LDAP服务端

## 1、环境准备

镜像：Centos7-minimal

## 2、配置yum源

centos自带的yum源一般不是国内的，会比较慢，建议选择阿里源，配置yum源之前需要先安装wget。

1. 安装wget

   ```shell
   yum install -y wget
   ```

   

2. 备份系统默认的yum源

   ```shell
   mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
   ```

   

3. 配置阿里云的yum源

   ```shell
   wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.aliyun.com/repo/Centos-7.repo
   ```

## 3、安装GNOME桌面系统（可选）

1. 列出可以安装的桌面环境

   ```shell
   yum grouplist
   ```

2. 安装GNOME以及对应的桌面管理工具

   ```shell
   yum -y groups install "GNOME Desktop" "Graphical Administration Tools"
   ```

   注意，"GNOME Desktop" "Graphical Administration Tools"一定要对应第一步列出来的

3. 设置GNOME为开机启动

   ```shell
   systemctl set-default graphical.target
   ```

4. 重启Centos

   ```shell
   reboot
   ```

## 4、关闭selinux和防火墙

```shell
setenforce 0
```

并且将selinux的配置文件改为：

```properties
# This file controls the state of SELinux on the system.
# SELINUX= can take one of these three values:
#     enforcing - SELinux security policy is enforced.
#     permissive - SELinux prints warnings instead of enforcing.
#     disabled - No SELinux policy is loaded.
SELINUX=disabled
# SELINUXTYPE= can take one of three values:
#     targeted - Targeted processes are protected,
#     minimum - Modification of targeted policy. Only selected processes are protected. 
#     mls - Multi Level Security protection.
SELINUXTYPE=targeted
```

关闭防火墙：

```shell
systemctl stop firewalld.service 
```

## 5、设定ldap域名配置host

1. 备份默认的hosts

   ```shell
   cp /etc/hosts /etc/hosts.ori
   ```

   

2. 添加host

   ```
   127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
   ::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
   10.0.0.7	etiantian.org
   ```

   将etiantian.org绑定到10.0.0.7

## 6、安装LDAP master

安装相关依赖

```shell
yum -y install openldap compat-openldap openldap-clients openldap-servers openldap-servers-sql openldap-devel migrationtool
```
安装完成后使用：

```shell
slapd -VV
```

查看openldap的版本号

## 7、配置open ldap




