data class Card(val rank: Rank, val suit: Suit) {
    override fun toString() = "${rank.value}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (rank != other.rank) return false

        return true
    }

    override fun hashCode(): Int {
        return rank.value
    }
}