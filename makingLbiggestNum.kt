fun solution(numbers: IntArray): String {
    var result = numbers.map { it.toString() }
        .sortedWith { num1, num2 -> (num2 + num1).compareTo(num1 + num2) }
        .joinToString("")

    return if (result[0] == '0') "0" else result
}

// sortedWith{ num1,num2 -> (num2 + num1).compareTo(num1 + num2) }
// num1+num2가 더크면 num1이 num2 앞에오고 num2+num1이 더크면 num2 num1앞으로온다


fun main(){

    var arr1 = intArrayOf(3,30,34,5,9)

    println(solution(arr1))

}