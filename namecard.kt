fun solutionNameCard(sizes: Array<IntArray>): Int {
    var answer: Int = 0

    val maxLen1 = sizes.toMutableList().maxByOrNull { it[0] }
    val maxLen2 = sizes.toMutableList().maxByOrNull { it[1] }

    val maxLen = if (maxLen1?.get(0)!! >= maxLen2?.get(1)!!) maxLen1?.get(0) else maxLen2?.get(1)
    var minLen = 0

    for (i in maxLen!! downTo 1) {

        var result = true

        sizes.forEach {
            if ((it[0] <= maxLen && it[1] <= i) || (it[1] <= maxLen && it[0] <= i)) {

            } else {
                result = false
            }
        }

        if (!result) {
            minLen = i
            break
        }
    }

    return maxLen * (minLen + 1)
}

fun main() {
    var arr1 = intArrayOf(60, 50)
    var arr2 = intArrayOf(30, 70)
    var arr3 = intArrayOf(60, 30)
    var arr4 = intArrayOf(80, 40)

    var arr = arrayOf(arr1, arr2, arr3, arr4)

    println(solutionNameCard(arr))

}