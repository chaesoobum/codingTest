class findDecimal {





    fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
        if(target == 0) {
            answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
        } else {
            for(i in start until el.size) {
                ck[i] = true
                combination(answer, el, ck, i + 1, target - 1)
                ck[i] = false
            }
        }
    }

    fun <T> permutation(
        result: MutableList<List<T>>,
        arr: Array<T>,
        n: Int,
        r: Int,
        nowArr: Array<T> = Array<Any?>(r) { null } as Array<T>,
        visited: BooleanArray = BooleanArray(n),
        curSelect: Int = 0
    ) {
        if (r == curSelect) {
            result.add(nowArr.toList())
            return
        }

        for (i in arr.indices) {
            if (!visited[i]) {
                visited[i] = true
                nowArr[curSelect] = arr[i]
                permutation(result, arr, n, r, nowArr, visited, curSelect + 1)
                visited[i] = false
            }
        }
    }


    fun solution(numbers: String): Int {
        var answer = 0

        val numbersArray = numbers.split("").filter { it != "" }.map { it.toInt() }.toTypedArray()
        val n = numbersArray.size

        val decimalList = mutableListOf<Int>()

        for (i in 1 .. n){
            val result = mutableListOf<List<Int>>()
            permutation(result,numbersArray,n,i)
            result.forEach {
                val str = StringBuilder()
                it.forEach {
                    str.append(it)
                }
                val stringInt = str.toString().toInt()

                var cnt = 0
                for (j in 1 .. stringInt){
                    if (stringInt%j == 0){
                        cnt++
                    }
                }

                if (cnt == 2){
                    decimalList.add(stringInt)
                }
            }
        }

        //println(decimalList)

        return decimalList.distinct().size
    }
}

fun main(){

    val findDecimal = findDecimal()

    println(findDecimal.solution("012345"))

}