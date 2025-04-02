fun main() {

    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(solution1(arr))
}

fun solution1(citations: IntArray): Int {
    var answer = 0

    var start = citations.size

    for (i in start downTo 0) {

        val citationCount = citations.count { it >= i }

        if (citationCount >= i) {
            if (citations.size - citationCount <= citationCount) {
                answer = i
                break
            }
        }
    }
    return answer
}