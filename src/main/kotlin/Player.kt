class Player(
    val name: String,
    val hand: MutableList<Card> = mutableListOf(),
) {

    fun drawCard(deck: MutableList<Card>) = hand.add(deck.removeFirst())

    fun dropCard() {
        println("drop one card!")
        val toDrop = readLine()!!.toInt()
        hand.removeIf { it.value == toDrop }
    }

    override fun toString(): String = "${name} | ${hand}"

}