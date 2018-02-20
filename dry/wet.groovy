class Example{

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

    static main(args) {
        List<Integer> values = [1,2,3,4,5,6,7,8,9];
        int sum = totalSum(values);
        int even_sum = totalEvenSum(values);
        println('Total Sum : ' + sum)
        println('Total Even Sum : ' + even_sum)
        println('Total Odd Sum :' + totalOddSum(values))
    }

}