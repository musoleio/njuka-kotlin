class Deck {
    var cards: MutableList<Card> = createDeck() // figure out how to make this prop immutable

    private fun createDeck(): MutableList<Card> {
        val suits = listOf("hearts", "clubs", "spades", "diamonds")

        val cards = mutableListOf<Card>()
        for (suit in suits) {
            for (i in 1..10) {
                cards.add(Card(suit = "$$suit", value = i))
            }
        }

        return cards
    }

    fun shuffle() = cards.shuffle()

    fun dealCards(players: MutableList<Player>) {
        players.forEach { player ->
            player.hand.addAll(cards.slice(0..2))
            cards = cards.slice(3..cards.lastIndex).toMutableList()
        }
    }

    override fun toString(): String = "${cards.size} ${cards}"
}
