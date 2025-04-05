class exam {
    fun solution(answers: IntArray): List<Int> {
        var answer = mutableListOf<Int>()

        val numList1 = intArrayOf(1, 2, 3, 4, 5)
        val numList2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val numList3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var num1 = 0
        var num2 = 0
        var num3 = 0

        //수포자1 정답수 계산
        for(i in 0 .. answers.size-1){
            val numListIndex = i%5
            if (answers[i] == numList1[numListIndex]){
                num1++
            }
        }

        //수포자2 정답수 계산
        for(i in 0 .. answers.size-1){
            val numListIndex = i%8
            if (answers[i] == numList2[numListIndex]){
                num2++
            }
        }

        //수포자3 정답수 계산
        for(i in 0 .. answers.size-1){
            val numListIndex = i%10
            if (answers[i] == numList3[numListIndex]){
                num3++
            }
        }

        val map = mutableMapOf<Int,Int>()
        map.put(1,num1)
        map.put(2,num2)
        map.put(3,num3)

        val maxValue = map.values.maxOrNull()
        val maxKeys = map.filterValues { it == maxValue }.keys.toList()

        return maxKeys
    }
}

fun main() {

    val exam = exam()

    var arr = intArrayOf(1,3,2,4,2)

    print(exam.solution(arr))

}