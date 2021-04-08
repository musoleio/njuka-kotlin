class Deck {
    private val suits = Suit.values()
    private val ranks = Rank.values()
    var cards: MutableList<Card> = createDeck()
    val droppedCards: MutableList<Card> = mutableListOf()
    val numberOfCards: Int
        get() = cards.size

    private fun createDeck(): MutableList<Card> {
        return suits
            .flatMap { suit -> ranks.map { rank -> Card(rank = rank, suit = suit) } }
            .toMutableList()
    }

    fun shuffle() = cards.shuffle()

    fun dealCards(players: MutableList<Player>) {
        players.forEach { player ->
            player.hand.addAll(cards.slice(0..2))
            cards = cards.slice(3..cards.lastIndex).toMutableList()
        }
    }

    override fun toString() = "${cards.size} $cards"
}