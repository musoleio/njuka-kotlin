class Player(
    val name: String,
    var hand: MutableList<Card> = mutableListOf(),
) {
    fun drawCard(deck: MutableList<Card>) = hand.add(deck.removeFirst())

    fun dropCard() {
        val cardValues: List<Int> = hand.map { card -> card.rank.value }
        var hasDroppedCard = false
        println("choose a card to drop from $hand")
        while (!hasDroppedCard) {
            val userChoice = readLine()?.toIntOrNull()
            if (userChoice != null && userChoice in cardValues) {
                val cardDropped = hand.find { it.rank.value == userChoice }
                cardDropped?.also {
                    hand = hand.minus(it).toMutableList()
                }
                hasDroppedCard = true
            } else println("You must enter a valid card value from $hand")
        }
    }

    override fun toString(): String = "${name} | ${hand}"

}