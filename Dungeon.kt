import java.awt.print.Printable

class Dungeon {
    var publick = 0
    val max = mutableListOf<Int>()

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        publick = k

        val result = mutableListOf<IntArray>()
        val size = dungeons.size

        permutation(result,dungeons,size,size)

        val maxValue = max.maxOrNull()
        answer = maxValue!!

        return answer
    }

    fun permutation(
        printArr: MutableList<IntArray>,
        arr: Array<IntArray>,
        n: Int,
        r: Int,
        nowArr: Array<IntArray> = arr.sliceArray(0 until r),
        visited: BooleanArray = BooleanArray(n),
        curSelect: Int = 0
    ) {

        if (r == curSelect) {
            nowArr.forEach {
                printArr.add(it)
            }
            // 현재순열에대해 계산한다
            var k = publick

            var cnt = 0
            for(item in printArr){
                if (k>=item[0]){
                    k -= item[1]
                    cnt++
                }else{
                    break
                }
            }
            max.add(cnt)

            printArr.clear()
            //println(nowArr.contentToString())
            return
        }

        for (i in arr.indices) {
            if (!visited[i]) {
                visited[i] = true
                nowArr[curSelect] = arr[i]
                permutation(printArr, arr, n, r, nowArr, visited, curSelect + 1)
                visited[i] = false
            }
        }

    }
}

fun main() {
    val a = Dungeon()
    val arr1 = intArrayOf(80, 20)
    val arr2 = intArrayOf(50, 40)
    val arr3 = intArrayOf(30, 10)
    val arrInput = arrayOf(arr1, arr2, arr3)
    //val arr = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
    val n = arrInput.size
    val r = 2


    println(a.solution(80,arrInput))


//    result.forEachIndexed { index, ints ->
//        println(index)
//        println(ints[0])
//        println(ints[1])
//        println("next")
//        println()
//    }
}