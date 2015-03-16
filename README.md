I wrote this small application to help fan club of Hoai Lam to auto vote for him at wechoice.vn

# How to use
0. You need to install JAVA runtime in your computer. If you don't know how to, Google is ready to help.

1. Modify the *config.txt* file if needed. The most important one is timeout. Currently it is 10, but you should modify it based on your network (higher number, slower network). You can modify the password and name which will be used to register voting account, but usually they are not important.

2. Modify the *email.txt*: each line of this file should contain one email address you want to use to register.

3. Run *AutoRegister.jar* by:
java -jar AutoVote.jar
It will run through all email addresses in *email.txt* file and register on vietid website with your configured name and password.
**Note**: you have to activate account by yourself.

4. Run *AutoVote* by a similar way to vote.

##Disclaimer: there is no any guarantee about the quality of this application. You take your own risk to run it.
Good luck.
