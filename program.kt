//https://www.acmicpc.net/problem/2747
fun main(){
    val dp = Array<Long>(1001){0}

    dp[0] = 0
    dp[1] = 1

    for (i in 2..1000){
        dp[i] = dp[i-1]+dp[i-2]
    }

    val target = readln().toInt()

    println(dp[target])
}