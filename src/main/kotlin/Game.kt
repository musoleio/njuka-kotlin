
class Game {

    val players: MutableList<Player> = addPlayers()

    private fun addPlayers(): MutableList<Player> {
        println("How many people are playing?")
        val numOfPlayers = readLine()!!.toInt()
        val players = mutableListOf<Player>()

        repeat(numOfPlayers) {
            players.add(Player(name = "player $it"))
        }

        return players
    }

    fun checkWinStatus(playerHand: MutableList<Card>) {}
}
