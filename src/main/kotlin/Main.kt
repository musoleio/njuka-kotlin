fun main() {
    startGame()
}

fun startGame() {
    var isGameOver = false
    val players = addPlayers()
    val deck = Deck()
    deck.shuffle()
    deck.dealCards(players)
    println("$players")

    while (!isGameOver && deck.cards.size > 0) {
        l2@ for (player in players) {
            player.drawCard(deck.cards)
            println("${player.name} : ${player.hand} --- ${deck.cards.size}")
            val handContainsDuplicate = playerHasDuplicates(player.hand)
            if (handContainsDuplicate) {
                val unique = separateDuplicates(player.hand)["unique"]
                if (unique != null && hasPlayerWon(unique)) {
                    isGameOver = true
                    println("${player.name} has won | ${player.hand}")
                    break@l2
                }
            }
            player.dropCard()
        }
    }
}


