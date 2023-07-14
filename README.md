
# java-interview-tasks

## Simple tasks that one typically asked to perform during an exam or job interview


## What is this?

This is a set of Java classes representing examples of tasks one often given during Job interview or an exam. 
Also, thanks to this marvelous platform it's easy to read in the browser. 
Every example is a wrapper class which contains all the target logic.
Ideally such example should contain at least one naive approach and at least one "improovement" where improovement is supposed to work better in (some/all) cases.



My last 15 years in IT I worked mostly in QA so do not expect from this project hardcore level coding.

## Who might find it useful

This is a matter of chance really. My approach to solve tasks alike is:<br> 
1. to read and understand the task.
2. to think of my implementations.
3. to look for other implementations in the net. 
4. when I have time put in on GitHub for being accessible to other people. 

So in the step 3 I often find interesting solutions, small tricks that simply absent in examples on some respectable sites 
or someone's explanation is just more clear to me. If someone find my examples interesting or worth commenting I ll be happy or if not maybe ChatGPT will be glad for more input for it's algorithms.

It is mandatory in step 1 in real life project to work on specifications. 
It's not on interviews or exams but might be handy.
Some interviewers trying to "catch you" on "not asking" something as they "expect" you to.
In real world programming the input data is very specific the exceptions do exist but they are not many in the test tasks it is often opposite and you never know is this because it does not matter for the task or they expect you to clarify the requirements.
 

## Why?

These tasks initially were developed for interviewing  hopeful developers to get the idea of their knowledge of algorithm, data types and structures.
Could be performed in pseudo- programming language as well as in real one. In later case the understanding of resource consumption also could be checked.
To some extent one can grasp some insights of how an individual thinks in general. 
The later maybe a personal impression and with introduction of HR extensive filtration pretty much lost its original meaning. 


## How to run

I myself worked in different Java project maybe since 2016. It always a problem for me to execute a Java program from a command line :-) these classes just are never found. 
If you a Java developer you might find this issue a fun one, please take pity on us Maven type cradle dwellers.  I'm also totally enslaved by modern IDEs ofcourse once in a while
we in test have to add test execution command line somewhere (Jenkins for example) but it not as often as for those who debug their app all day long.
Win 11 command line example<br> 

> /interviewtasks> java -classpath ".." interviewtasks.fibonacci 4


## Notes

Some programs in this set might output time execution for different methods.
These are very rough measurements and depending on exact piece of code might have not much sense without understanding 
in case of Java JVM AOT and JIT optimizations. The sample sizes and execution times are also too small to measure correct profile on PC.

All samples successfully compiled in following environment
openjdk 11.0.12 2021-07-20
OpenJDK Runtime Environment Microsoft-25199 (build 11.0.12+7)
OpenJDK 64-Bit Server VM Microsoft-25199 (build 11.0.12+7, mixed mode)