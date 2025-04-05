class carpet {
    fun solution(brown: Int, yellow: Int): MutableList<Int> {
        var answer = mutableListOf<Int>()

        for (i in 1..yellow) {

            if (yellow % i == 0) {

                if ((i * 2) + ((yellow / i) * 2) + 4 == brown) {

//                    println(i)//세로
//                    println(yellow/i)//가로
//
//                    println((i*2) + ((yellow/i)*2) + 4)
                    //                    println(yellow/i+2)
//                    println(i+2)
                    val result = mutableListOf<Int>()
                    result.add(yellow/i+2)
                    result.add(i+2)
                    return result
                }

            }

        }

        return answer

    }
}

fun main() {
    val carpet = carpet()

    println(carpet.solution(24, 24))
}