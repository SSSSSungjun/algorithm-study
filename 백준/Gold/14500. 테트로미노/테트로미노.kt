import kotlin.collections.*
import kotlin.math.*

var N = 0
var M = 0
lateinit var field: MutableList<MutableList<Int>>
var result = 0

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        N = this[0]
        M = this[1]
    }
    field = MutableList(N) {
        readLine().split(" ").map { it.toInt() }.toMutableList()
    }

    for (i in 0 until N) {
        for (k in 0 until M) {
            for (n in TET.indices) {
                Mapping(i, k, n)
            }
        }
    }

    print(result)
}

fun Mapping(i: Int, k: Int, n: Int) {

    var sum = 0

    for (d in TET[n]) {
        val (nx, ny) = Pair(d.first + i, d.second + k)
        if (nx !in 0 until N || ny !in 0 until M) return
        sum+=field[nx][ny]
    }
    result=max(result,sum)
}

val TET=listOf(
    listOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(0,3)),
    listOf(Pair(0,0),Pair(1,0),Pair(2,0),Pair(3,0)),

    listOf(Pair(0,0),Pair(0,1),Pair(1,0),Pair(1,1)),

    listOf(Pair(0,0),Pair(1,0),Pair(2,0),Pair(2,1)),
    listOf(Pair(0,0),Pair(1,0),Pair(2,0),Pair(2,-1)),
    listOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(-1,2)),
    listOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(1,2)),
    listOf(Pair(0,1),Pair(0,0),Pair(1,0),Pair(2,0)),
    listOf(Pair(0,-1),Pair(0,0),Pair(1,0),Pair(2,0)),
    listOf(Pair(-1,0),Pair(0,0),Pair(0,1),Pair(0,2)),
    listOf(Pair(1,0),Pair(0,0),Pair(0,1),Pair(0,2)),

    listOf(Pair(0,0),Pair(1,0),Pair(1,1),Pair(2,1)),
    listOf(Pair(0,0),Pair(1,0),Pair(1,-1),Pair(2,-1)),
    listOf(Pair(0,0),Pair(0,1),Pair(-1,1),Pair(-1,2)),
    listOf(Pair(0,0),Pair(0,1),Pair(1,1),Pair(1,2)),

    listOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(1,1)),
    listOf(Pair(0,0),Pair(1,0),Pair(1,1),Pair(2,0)),
    listOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(-1,1)),
    listOf(Pair(0,0),Pair(1,0),Pair(1,-1),Pair(2,0)),
) //이게 ㄹㅇ 브루트포스지 
