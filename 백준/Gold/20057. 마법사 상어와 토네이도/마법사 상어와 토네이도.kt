import kotlin.collections.*

lateinit var field: MutableList<MutableList<Int>>
var N = 0

val dx = listOf(0, 1, 0, -1)
val dy = listOf(-1, 0, 1, 0)

val rating = listOf(1, 0, 1, 2, 7, 0, 7, 2, 10, -2, 10, 5) // -1은y -2은 a
val spread = listOf(1, 2, 1, 0)

var outOfField = 0

fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    field = MutableList(N) {
        readLine().split(" ").map { it.toInt() }.toMutableList()
    }

    var (curX, curY) = Pair(N / 2, N / 2)
    var direction = 0

    for (i in 1 until N) {
        repeat(if (i < N - 1) 2 else 3) {
            repeat(i) {
                curX += dx[direction]
                curY += dy[direction]
                Tornado(curX, curY, direction)
            }
            direction = (direction + 1) % 4
        }
    }
    println(outOfField)

}

//0 왼쪽 1 아래 2 오른쪽 3 위쪽
fun Tornado(x: Int, y: Int, direction: Int) {
    var rIdx = 0
    val op = if (direction % 3 != 0) 1 else -1

    var moveSendQuantity = 0 //흩날린 모래양. a 구하기 위해서 필요
    var alphaXY = Pair(0, 0)

    (-1..2).forEach {
        if (direction % 2 == 0) {
            val ny = y + it * op
            for (nx in x - spread[it + 1]..x + spread[it + 1]) {

                if (rating[rIdx] == -2) {
                    alphaXY = Pair(nx, ny)
                    rIdx++
                    continue
                }

                val moveSand = (field[x][y].times((rating[rIdx] * 0.01)).toInt())
                moveSendQuantity += moveSand

                if (nx !in 0 until N || ny !in 0 until N)
                    outOfField += moveSand
                else
                    field[nx][ny] += moveSand

                rIdx++
            }
        }

        if (direction % 2 != 0) {
            val nx = x + it * op
            for (ny in y - spread[it + 1]..y + spread[it + 1]) {

                if (rating[rIdx] == -2) {
                    alphaXY = Pair(nx, ny)
                    rIdx++
                    continue
                }

                val moveSand = (field[x][y].times((rating[rIdx] * 0.01)).toInt())
                moveSendQuantity += moveSand

                if (nx !in 0 until N || ny !in 0 until N)
                    outOfField += moveSand
                else
                    field[nx][ny] += moveSand

                rIdx++
            }
        }
    }

    val isOuter = alphaXY.let {
        val c1 = it.first !in 0 until N
        val c2 = it.second !in 0 until N
        c1 || c2
    }
    if (isOuter) {
        outOfField += field[x][y].minus(moveSendQuantity)
    } else {
        field[alphaXY.first][alphaXY.second] += field[x][y].minus(moveSendQuantity)
    }
    field[x][y] = 0
}

//direction : 좌0 밑1 우2 위3


