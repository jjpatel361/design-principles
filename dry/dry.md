# Basic Principles 

Don't Repeat Yourself (DRY) states 

> Every piece of knowledge must have a single, unambiguous, authoritative representation within a system.

Example

Write a program that finds sum of all values of a list of integers.

Solution 

```groovy
class Example{

    static def totalSum(values){
        int sum = 0;
        for (v in values) {
            sum+= v;
        }
        return sum;
    }
    static main(args) {
        List<Integer> values = [1,2,3,4,5,6,7,8,9];
        int sum = totalSum(values);
     }

}

``` 

A new feature to the existing codebase, we need to find sum of all even values of the list. Since, it is Friday evening and I am all pumped for a weekend below is the solution I come up with

```groovy
static def totalSum(values){
    int sum = 0;
    for (v in values) {
        sum+= v;
    }
    return sum;
}

static def totalEvenSum(values){
    int sum = 0;
    for (v in values) {
        if (v%2 == 0) sum+= v;
    }
    return sum;
}

``` 

There is one more change required. Bob (_my manager_) asked me to add support for sum of Odd values as well. And here is the solution

```groovy

static def totalSum(values){
    int sum = 0;
    for (v in values) {
        sum+= v;
    }
    return sum;
}

static def totalEvenSum(values){
    int sum = 0;
    for (v in values) {
        if (v%2 == 0) sum+= v;
    }
    return sum;
}

static def totalOddSum(values){
    int sum = 0;
    for (v in values) {
        if (v%2 != 0) sum+= v;
    }
    return sum;
}
``` 

> So, what is wrong with this codebase? 

There are 3 code blocks doing the same logic i.e. summing value over a list. The condition of summing an item changes. But the knowledge or logic is repeated. Can we do better?

Applying DRY

**Approach 1:**
```groovy

static def totalSum(values, type){
    int sum = 0;
    switch(type) {
        case "ODD":
           for (v in values) {
                if (v%2 != 0) sum+= v;
            } 
            break
        case "EVEN":
            for (v in values) {
                if (v%2 == 0) sum+= v;
            }
            break
        default:
            for (v in values) {
                sum+= v;
            }
            break;
    }
    return sum;
}

``` 
This is a slightly better approach. Now, there is just one single representation i.e. method `totalSum` number of ways to sum are supported by system.

> Can we do better than this?

**Approach 2:**
```groovy
import groovy.lang.Closure;

class Example {

    def static totalSum (List<Integer> values, Closure c) {
        return values.collect(c).sum();
    }

    static Closure total = { e-> return e};
    static Closure totalEven = { e-> return ((e%2 == 0) ? e : 0 )};
    static Closure totalOdd = { e-> return ((e%2 != 0? e : 0))};
    

    static main(args) {
        List<Integer> array = [1,2,3,4,5,6,7,8,9];
        println(totalSum(array, total)) // 45
        println(totalSum(array, totalEven)) // 20
        println(totalSum(array, totalOdd)) // 25
    }
}
```

We know that we need to sum the elements of the list. The way elements are selected for summing is varied. Hence, we can pass the function/expressions (_in this case `Closures`_) as parameter to the function. 

The code above doesn't violate `DRY` principle and is easy to understand and extend. If there is an additional requirement then all you have to do is write a Closure for it and use `totalSum` function
