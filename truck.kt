import java.util.LinkedList
import java.util.Queue

class truck {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        // 다리에올라간 트럭을 담을 큐
        var bridge_queue: Queue<Int> = LinkedList()

        // 대기중인 트럭을 담을 큐
        var truck_list: Queue<Int> = LinkedList()

        // 대기중인 트럭을 큐에 담아준다
        truck_weights.forEach {
            truck_list.add(it)
        }
        var time = 0

        val arrivalTruck = mutableListOf<Int>()

        while (arrivalTruck.size != truck_weights.size) {
            //현재 다리위에있는 트럭들의 무게를 구한다
            var sum = 0
            bridge_queue.forEach {
                sum += it
            }

            var peekWeight = truck_list.peek() ?: 0

            if (bridge_queue.size == bridge_length){
                peekWeight -= bridge_queue.peek()
            }

            //브리지의 길이가 트럭이 올라갈수있는 상태고 새로올라갈 트럭까지의 무게를 다리가 견딜수있드면 다리에 트럭을 올린다
            if (bridge_queue.size <= bridge_length && sum + peekWeight < weight+1) {

                bridge_queue.add(truck_list.poll() ?: 0)
                time++

            } else {
                //다리에 새로운트럭이 올라갈수 없으므로 0이 들어간다
                bridge_queue.add(0)
                time++
            }
            //println("bridge_queue : $bridge_queue")
            // 다리를 모두 지난 트럭은 빼준다
            if (bridge_queue.size > bridge_length) {
                if (bridge_queue.peek() == 0) {
                    bridge_queue.poll()
                } else {
                    arrivalTruck.add(bridge_queue.poll())
                }
                //println("arrivalTruck : ${arrivalTruck ?: "null"}")
            }
            //println("time : ${time ?: "null"}")
            //println()

        }


        answer = time


        return answer
    }
}