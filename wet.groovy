import groovy.lang.Closure;

class Example {

    def static totalSum (List<Integer> values, Closure c) {
        return values.collect(c).sum();
    }

    static Closure total = { e-> return e};
    static Closure totalEven = { e-> return ((e%2 == 0) ? e : 0 )};
    static Closure totalOdd = { e-> return ((e%2 != 0? e : 0))};
    static Closure customCount = {e -> return (e%3 == 0 && e%5 ==0) ? e : 0}; 

    static main(args) {
        println('Good morning monday!');
        List<Integer> array = [1,2,3,4,5,6,7,8,9,15];
        println(totalSum(array, total)) // 45
        println(totalSum(array, totalEven)) // 20
        println(totalSum(array, totalOdd)) // 25
        println(totalSum(array, customCount)) 
    }
}