import java.util.PriorityQueue

fun main() {
    //	[[0, 3], [1, 9], [2, 6]] = 9
    //  [[0, 3], [1, 9], [3, 5]] = 8
    val arr1 = intArrayOf(1, 5)
    val arr2 = intArrayOf(10, 20)
    val arr3 = intArrayOf(10, 9)
    val arr4 = intArrayOf(10, 10)

    val array = arrayOf(arr1, arr2, arr3, arr4)

    println(solution(array))

}

fun solution(jobs: Array<IntArray>): Int {
    var answer = 0

    // 짧은 작업을 우선으로 반환하는 대기큐
    val jobQueue =
        PriorityQueue<IntArray>(compareBy<IntArray?>() { it?.get(1) }.thenBy { it?.get(0) })


    // 대기중인 작업들을 담을 해시맵
    val jobsList = jobs.toMutableList()
    jobsList.sortBy { it[0] }

    // 현재 작업중인 프로세스
    var processingJob: IntArray? = null

    // 현재 작업중인 프로세스가 끝날시간
    var currentProcessEndTime: Int? = null

    // 각 작업들의 요청시간과 반환시간을 저장할 list<IntArray<Int>>
    var result = mutableListOf<List<Int>>()


    // 들어온 프로세스들의 총 실행시간
    var processingTime = 0
    jobs.forEach {
        processingTime += it[1]
    }

    var i = 0

    //[요청시간],[반환시간]이 들어가는 리스트의 크기가 각 프로세스의 개수와 같아지는순간까지돌린다
    while (result.size != jobs.size){

        //i초에 큐에들어가서 대기리스트에서 삭제될 작업들의 인덱스리스트
        val deleteList = mutableListOf<IntArray>()
        // i초에 큐에들어갈 작업을 넣어준다
        if (jobsList.size != 0) {
            for (item in jobsList) {
                if (item[0] == i) {
                    //작업을 넣는다
                    jobQueue.add(item)
                    //println("add : ${item.first()},${item.last()}")
                    //큐에들어간 작업은 대기리스트에서 삭제한다
                    deleteList.add(item)
                }
            }
        }
        //큐에들어간 작업은 대기리스트에서 삭제한다
        jobsList.removeAll(deleteList)

        //작업이 끝난 작업을 processingJob에서 삭제한다
        if (i == currentProcessEndTime) {
            //요청시간과 반환시간을 저장한다
            val list = listOf(processingJob?.first(), i)
//            println("list : +${list}")
            result.add(list as List<Int>)


            processingJob = null
        }

        // 큐에들어온 작업을 우선순위따라 뽑아서 작업한다 이미작업중이면 넘어간다
        if (jobQueue.size != 0) {
            if (processingJob == null) {
                //지금들어온 작업의 예상종료시간을 저장한다
                currentProcessEndTime = i + jobQueue.peek()[1]
//                println("currentProcessEndTime: ${currentProcessEndTime}")
                //작업스타트
                processingJob = jobQueue.poll()
            }
        }
        i++
//        println("i : $i")
//        println("processingJob")
//        print("${processingJob?.first()} ,")
//        print(processingJob?.last())
//        println()
//        println()
//        println(currentProcessEndTime)


    }



    //println(result)

    var sum=0

    result.forEach {
        sum += it[1] - it[0]
    }


    val temp = sum / jobs.size


    return temp
}
