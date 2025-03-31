fun solution(clothes: Array<Array<String>>): Int {
    var answer = 0

    val list = clothes.toMutableList()

    val hashMap = HashMap<String,Int>()

    var group = list.groupBy { it[1] }

    group.forEach {
        hashMap[it.key] = it.value.size
    }

    //옷종류 리스트를 만든다
    val clothesCategoryList:List<String> = list.map { it[1] }.distinct()


    //한개만 고를떄
    answer += clothes.size

    if (clothesCategoryList.size == 1){
        return answer
    }

    val countList = mutableListOf<Int>()
    val categoryList = mutableListOf<List<String>>()

    for (i in 2 .. clothesCategoryList.size-1){
        //i는 n개의 옷종류중 i개를 선택할경우
        //for문은 2.. n-1개의 종류의 옷을 선택해서 옷을 고르는 경우를 누적함

        // n개의 종류중 i개를 선택했을떄 선택한 옷종류 i개를 담을 리스트
        combination(categoryList, clothesCategoryList, Array<Boolean>(clothesCategoryList.size) { false }, 0,  i)

        categoryList.forEach { category->

            category.forEach { k->
                val num = hashMap[k]
                if (num != null) {
                    countList.add(num)
                }
            }
            var sum = 1
            countList.forEach { c->
                sum*=c
            }

            countList.clear()
            answer+= sum
        }
        categoryList.clear()


    }




    //종류별로 한개씩만 고를때
    val clothesGroup = list.groupBy { it[1] }
    var temp = 1
    clothesGroup.forEach {
        temp *= it.value.size
    }
    answer += temp




    return answer
}

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