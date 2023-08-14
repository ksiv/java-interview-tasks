
# java-interview-tasks

## Simple tasks that one typically asked to perform during an exam or job interview


## What is this?

This is a set of Java classes representing examples of tasks one often given during Job interview or an exam. 
Also, thanks to this marvelous platform it's easy to read in the browser. 
Every example is a wrapper class which contains all the target logic with minimal import of service functionality.

So far, I see three types of tasks:<br>
1. a naive approach to solve the tasks and at least one "improvement" where improvement is supposed to work better in (some/all) cases. This type of task shows some approach to solve a problem and why it's better than the other and that in general why we should seek for different approaches to same problem. 
2. implement "a" without using "b". In such task you are to implement some solution without using some method or data structure. This task forces you to find the other approach to solve same problem. The approach you have found is not always an improvement in terms of efficiency  but it might have some uses depending on an exact PL and it's limitations.
3. Just implement something. Such task often imply one solution and the whole idea is to learn or demonstrate the knowledge of some algorithm and your ability to utilize given PL to use this algorithm.


My last 15 years in IT I worked mostly in QA so do not expect from this project hardcore level coding.

## Who might find it useful

This is a matter of chance really. My approach to solve tasks alike is:<br> 
1. to read and understand the task.
2. to think of my implementations.
3. to look for other implementations in the net. 
4. when I have time put in on GitHub for being accessible to other people. 

So, in the step 3 I often find interesting solutions, small tricks that simply absent in examples on some respectable sites 
or someone's explanation is just clearer to me. If someone find my examples interesting or worth commenting I will be happy or if not maybe ChatGPT will be glad for more input for its algorithms.


 

## Why?

These tasks initially were developed for interviewing hopeful developers to get the idea of their knowledge of algorithm, data types and structures.
Could be performed in pseudo- programming language as well as in real one. In later case the understanding of resource consumption also could be checked.
To some extent one can grasp some insights of how an individual thinks in general. 
The later maybe a personal impression and with introduction of HR extensive filtration pretty much lost its original meaning. 


## How to run

I myself worked in different Java project maybe since 2016. It always a problem for me to execute a Java program from a command line :-) these classes just are never found. 
If you a Java developer you might find this issue a fun one, please take pity on us Maven type cradle dwellers.  I'm also totally enslaved by modern IDEs of course once in a while
we in test have to add test execution command line somewhere (Jenkins for example) but it not as often as for those who debug their app all day long.
Win 11 command line example<br> 

> /interviewtasks> java -classpath ".." interviewtasks.fibonacci 4

## Which task practicing sites I use
leetcode.com
www.codechef.com
www.geeksforgeeks.org
Most of these tasks are originated not on these platforms, they just collect them and use. My advice is to use "comments /solutions" sections.

## What about license.
All my contribution is under MIT license. The rest is a well-known stuff from the public domain. I'm trying to put in credits where it's possible. It's really hard to track down the impact contribution. So often some user contributes the code to some platform but it turns out one of classic solutions for those who have read some certain books. 

## Worth noticing

### on tech side ..
Some programs in this set might output time execution for different methods.
These are very rough measurements and depending on exact piece of code might have not much sense without understanding 
in case of Java JVM AOT and JIT optimizations. The sample sizes and execution times are also too small to measure correct profile on PC.

All samples successfully compiled in following environment
openjdk 11.0.12 2021-07-20
OpenJDK Runtime Environment Microsoft-25199 (build 11.0.12+7)
OpenJDK 64-Bit Server VM Microsoft-25199 (build 11.0.12+7, mixed mode)

### oh, those hard "soft" skills...

It is mandatory in real life project to work on specifications It's not on interviews or exams but might be handy or even crucial.
Some interviewers trying to "catch you" on "not asking" something as they _expect_ you to. They think it is _implied_ that everybody should think like them or like it's stated in their guideline.

In real world programming the input data is very specific the exceptions do exist but they are not many.
In the test tasks it's often not clear if you expected to solve maximum tasks per given time or you should solve each task thoroughly.
