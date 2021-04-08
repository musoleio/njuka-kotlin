import Rank.*
import Suit.*

fun playerHasDuplicates(playerHand: MutableList<Card>) = playerHand.size != playerHand.toSet().size

fun separateDuplicates(playerHand: MutableList<Card>): MutableMap<String, List<Card>> {
    val separatedHand: MutableMap<String, List<Card>> = mutableMapOf()
    for ((cardIdx, duplicate) in playerHand.withIndex()) {
        if (cardIdx == playerHand.lastIndex) break
        val remainder = playerHand.slice(cardIdx.plus(1)..playerHand.lastIndex)
        if (duplicate in remainder) {
            separatedHand["duplicates"] = listOf(duplicate, duplicate)
            separatedHand["unique"] = playerHand.minus(duplicate).minus(duplicate)
            break
        }
    }
    return separatedHand
}

fun hasPlayerWon(cards: List<Card>) = (cards[0].rank.value - cards[1].rank.value) in listOf(1, -1)

fun dropCard(hand: MutableList<Card>) {
    println("$hand")
    val cardValues = hand.map { card -> card.rank.value }
    var hasDroppedCard = false
    println("choose a card to drop from $hand")
    while (!hasDroppedCard) {
        val toDrop = readLine()?.toIntOrNull()
        if (toDrop != null && cardValues.indexOf(toDrop) != -1) {
            val r = hand.find { it.rank.value == toDrop }
            if (r != null) hand.minus(r)
            r?.also { hand.minus(it) }
            hasDroppedCard = true
        } else println("You must enter a valid card value from $hand")
    }
    println("$hand")
}

fun addPlayers(): MutableList<Player> {
    val players = mutableListOf<Player>()
    val numberOfPlayers = getNumberOfPlayers()
    repeat(numberOfPlayers) {
        val playerName = getPlayerName(it)
        players.add(Player(name = playerName))
    }
    return players
}

fun getPlayerName(playerNumber: Int): String {
    print("Enter player ${playerNumber + 1}'s name: ")
    val userInput = readLine()
    return if (userInput != null &&
        (userInput.isNotBlank() || userInput.isNotEmpty())) userInput else "Player ${playerNumber + 1}"
}

fun getNumberOfPlayers(): Int {
    var isValidNumber = false
    var playerCount = 0
    print("Enter number of players: ")
    while (!isValidNumber) {
        val userInput = readLine()?.toIntOrNull()
        userInput?.also {
            playerCount = userInput
            isValidNumber = true
        }
        if (!isValidNumber) println("Please enter a valid number of players")
    }
    return playerCount
}
