import kotlin.collections.*

var M = 0
var N = 0
var P = 0
var HP = 0
lateinit var field: MutableList<MutableList<Char>>
lateinit var visited: MutableList<MutableList<MutableList<Boolean>>>

var dps = MutableList(26) { 0 }
var raidUser = mutableListOf<Char>()
var bossTime = 0

data class User(val x: Int, val y: Int, val id: Char, val cnt: Int) //BFS할 때 쓰게

val dx = listOf(0, 1, 0, -1)
val dy = listOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        M = this[0]
        N = this[1]
        P = this[2]
    }
    val queue = ArrayDeque<User>()

    field = MutableList(M) { MutableList(N) { ' ' } }
    visited = MutableList(M) {
        MutableList(N) { MutableList(P) { false } }
    }

    repeat(M) { x ->
        field[x] = readLine().toCharArray().toMutableList()

        field[x].forEachIndexed { y, v ->
            field[x][y] = v
            if (v != '.' && v.isLowerCase()) {
                queue += User(x, y, v, 0)
                visited[x][y][v.code - 97] = true
            }
        }
    }

    repeat(P) {
        readLine().split(" ").apply {
            dps[this[0][0].code - 97] = this[1].toInt()
        }
    }

    HP = readLine().toInt()
    BFS(queue)
    print(raidUser.size)
}

fun BFS(queue: ArrayDeque<User>) {
    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        if (raidUser.isNotEmpty() && bossTime != cur.cnt) Raid()
        if (HP <= 0) return
        bossTime = cur.cnt

        for (d in 0..3) {
            val (nx, ny) = Pair(cur.x + dx[d], cur.y + dy[d])

            if (nx !in 0 until M || ny !in 0 until N) continue
            if (field[nx][ny] == 'X' || visited[nx][ny][cur.id.code - 97]) continue
            visited[nx][ny][cur.id.code - 97] = true

            if (field[nx][ny] == 'B') {
                raidUser += cur.id
                break
            }

            queue += User(nx, ny, cur.id, cur.cnt + 1)

        }

    }
}

fun Raid() {
    raidUser.forEach {
        HP -= dps[it.code - 97]
    }
}
