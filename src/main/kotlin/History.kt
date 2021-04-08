/*fun findDuplicates(values: MutableList<Int>) {
    if (values.size <= 1) return
    var attempts = 0
    var unique: List<Int>

    loop@ for ((index, duplicate) in values.withIndex()) {
        attempts += 1
        val rightOfDuplicate = values.slice(index.plus(1)..values.lastIndex)

        when (duplicate) {
            in rightOfDuplicate -> {
                unique = values.filter { it != duplicate }
                println("found duplicate $duplicate in $attempts ${if (attempts > 1) "checks" else "check"}")
//                break@loop
            }
            else -> {
                continue@loop
            }
        }
    }
}*/

//fun main() {
//    val p1 = mutableListOf(Card(Ace, HEARTS), Card(Two, HEARTS), Card(Three, HEARTS), Card(Four, HEARTS))
//    val p2 = mutableListOf(Card(Four, HEARTS), Card(Four, HEARTS), Card(Three, HEARTS), Card(Eight, HEARTS))
//    val p3 = mutableListOf(Card(Eight, HEARTS), Card(Eight, HEARTS), Card(Eight, HEARTS), Card(Ten, HEARTS))
//    val p4 = mutableListOf(Card(Six, HEARTS), Card(Six, HEARTS), Card(Six, HEARTS), Card(Six, HEARTS))
//    val p5 = mutableListOf(Card(Six, HEARTS), Card(Six, HEARTS), Card(Seven, HEARTS), Card(Seven, HEARTS))
//    val p6 = mutableListOf(Card(Nine, HEARTS), Card(Nine, HEARTS), Card(Six, HEARTS), Card(Three, HEARTS))
//    val p7 = mutableListOf(Card(Five, HEARTS), Card(Ten, HEARTS), Card(Ten, HEARTS), Card(Ten, HEARTS))
//    val p8 = mutableListOf(Card(Five, HEARTS), Card(Ace, HEARTS), Card(Ten, HEARTS), Card(Ace, HEARTS))
//
//    val hands = listOf(p1, p2, p3, p4, p5, p6, p7, p8)
//
//    hands.forEach { hand ->
//        val playerHasDuplicates = playerHasDuplicates(hand)
//        if (playerHasDuplicates) {
//            val r = separateDuplicates(hand)
//            println("$hand -> $r")
//        } else {
//            println("no duplicates found. player must drop card")
//        }
//    }
//    dropCard(p1)
//}


//class Game {
//
//    val players: MutableList<Player> = addPlayers()
//    val deck = Deck()
//
//    fun start() {
////        deck.shuffle()
////        deck.dealCards(players)
////        println(deck)
////
////        val duplicateFinder = DuplicateCardFinder()
////        for (player in players) {
////            player.drawCard(deck.cards)
////            println(player)
////            duplicateFinder.hasDuplicates(player.hand)
////        }
//        val duplicateFinder = DuplicateCardFinder()
////        duplicateFinder.hasDuplicates(4, 8, 8, 7)
////        findDuplicates(listOf(4, 8, 8, 7))
//        println("Duplicates: ${duplicateFinder.duplicates}\nUnique: ${duplicateFinder.unique}")
//
//
//    }
//}



/*class DuplicateCardFinder {
    private var checks = 0
    val numberOfChecks = checks
    lateinit var unique: List<Card>
    lateinit var duplicates: List<Card>


    fun hasDuplicates (cards: MutableList<Card>) {
        var dups: List<Int>
        for ((i, card) in cards.withIndex()) {
            ++checks
            val remainder = cards.slice(i.plus(1)..cards.lastIndex)

            when (card) {
                in remainder -> {
                    println("found duplicate $card in $checks ${if (checks > 1) "checks" else "check"}")
                    duplicates = cards.filter { it == card }
                    unique = cards.filter { it != card }
                    break
                }
                else -> {
//                    println("No duplicates")
                    duplicates = listOf<Card>()
                    unique = duplicates
                    continue
                }
            }
        }
//        return true
    }

}*/
