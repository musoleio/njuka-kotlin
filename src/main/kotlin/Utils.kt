fun playerHasDuplicates(playerHand: MutableList<Card>) = playerHand.size != playerHand.toSet().size

fun separateDuplicates(playerHand: MutableList<Card>): MutableMap<String, List<Card>> {
    val separatedHand: MutableMap<String, List<Card>> = mutableMapOf() // 1
    for ((cardIdx, duplicate) in playerHand.withIndex()) {
        if (cardIdx == playerHand.lastIndex) break
        val remainder = playerHand.slice(cardIdx.plus(1)..playerHand.lastIndex) // 1
        if (duplicate in remainder) {
            separatedHand["duplicates"] = listOf(duplicate, duplicate) // 1
            separatedHand["unique"] = playerHand.minus(duplicate).minus(duplicate) // 2
            break
        }
    }
    return separatedHand
}

//fun separateDuplicates(playerHand: MutableList<Card>): MutableMap<String, List<Card>> {
//    val separatedHand = mutableMapOf<String, List<Card>>()
//    var pointer = 0
//
//    var foundDuplicates = false
//    while (!foundDuplicates) {
//        var remainder = playerHand.slice(pointer + 1..playerHand.lastIndex)
//        for (card in remainder) {
//            if (playerHand[pointer].rank == card.rank) {
//                separatedHand["duplicates"] = listOf(card, card)
//                separatedHand["unique"] = playerHand.minus(card).minus(card)
//                foundDuplicates = true
//                break
//            }
//        }
//        if (foundDuplicates || pointer >= playerHand.size) break else pointer += 1
//    }
//    return separatedHand
//}

fun hasPlayerWon(cards: List<Card>) = (cards[0].rank.value - cards[1].rank.value) in listOf(1, -1)

fun dropCard(hand: MutableList<Card>) {
    println("$hand")
    val cardValues = hand.map { card -> card.rank.value }
    var hasDroppedCard = false
    var drop: Card
    println("choose a card to drop from $hand")
    while (!hasDroppedCard) {
        val toDrop = readLine()?.toIntOrNull()
        if (toDrop != null && cardValues.indexOf(toDrop) != -1) {
            val r = hand.find { it.rank.value == toDrop }
            r?.also {
                hand.minus(it)
                drop = it
            }
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
        (userInput.isNotBlank() || userInput.isNotEmpty())
    ) userInput else "Player ${playerNumber + 1}"
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
            val cardDropped = player.dropCard()
            cardDropped?.also { deck.droppedCards.add(it) }
        }
    }
    println("dropped card: ${deck.droppedCards}")
}

