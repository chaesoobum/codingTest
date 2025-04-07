class GreedyGymClothes {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0

        val studentList = mutableListOf<MutableList<Int>>()

        for (i in 0..n - 1) {

            // 도난당한학생
            if (lost.contains(i + 1)) {
                //도난당했지만 여벌이 있음
                if (reserve.contains(i + 1)){
                    studentList.add(i, mutableListOf(i + 1, 1))
                }
                // 도난당하고 여벌도 없음
                else{
                    studentList.add(i, mutableListOf(i + 1, 0))
                }

            } else if (reserve.contains(i + 1)) {
                //println(mutableListOf(i + 1, 2))
                studentList.add(i, mutableListOf(i + 1, 2))
            } else {
                studentList.add(i, mutableListOf(i + 1, 1))
            }
        }
        //println(studentList)

        for (i in 0..n - 1) {

            // 1번학생
            if (i == 0) {
                //처음학생이 여벌옷이 있을경우(==2)
                if (studentList[i][1] == 2) {
                    //바로 뒤에 학생이 옷이 없으면 빌려준다(==0)
                    if (studentList[i + 1][1] == 0) {
                        studentList[i][1] -= 1
                        studentList[i + 1][1] += 1
                    }
                }
            }
            // 마지막학생
            else if (i == n - 1) {
                //마직막 학생이 여벌옷이 있을경우(==2)
                if (studentList[i][1] == 2) {
                    //바로 앞에 학생이 여벌옷이 없으면 빌려준다
                    if (studentList[i - 1][1] == 0) {
                        studentList[i][1] -= 1
                        studentList[i - 1][1] += 1
                    }
                }

            }
            //중간학생들
            else {
                //여벌옷이 있을경우
                if (studentList[i][1] == 2) {

                    //앞뒤학생의 체육복 소지여부 체크
                    var front = 1
                    var rear = 1

                    //앞쪽학생의 체육복 소지여부 체크
                    if (studentList[i - 1][1] == 0) {
                        front = 0
                    }

                    //뒤쪽학생의 체육복 소지여부 체크
                    if (studentList[i + 1][1] == 0) {
                        rear = 0
                    }

                    //1. 앞쪽학생만 체육복이 없을 경우
                    //2. 뒤쪽학생만 체육복이 없을 경우
                    //3. 둘다 없을경우 (이경우 뒤쪽에 빌려준다)

                    if (front == 0 && rear == 1) {
                        studentList[i][1] -= 1
                        studentList[i - 1][1] += 1
                    }
                    if (front == 1 && rear == 0) {
                        studentList[i][1] -= 1
                        studentList[i + 1][1] += 1
                    }
                    if (front == 0 && rear == 0) {
                        studentList[i][1] -= 1
                        studentList[i - 1][1] += 1
                    }
                }
            }
        }

        //println(studentList)

        answer = studentList.count { it[1] == 1 || it[1] == 2 }

        return answer
    }
}

fun main() {
    val a = GreedyGymClothes()
    println(a.solution(10, intArrayOf(1,3,5,7,9), intArrayOf(2,4)))
}